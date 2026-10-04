package com.villagernews.client.render.geo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BedrockModelLoader {

    public static class RawCube {
        public float ox, oy, oz;
        public float sx, sy, sz;
        public int u, v;
        public float inflate;
        public boolean mirror;
    }

    public static class RawBone {
        public String name;
        public String parent;
        public float px, py, pz;
        public float rx, ry, rz;
        public List<RawCube> cubes = new ArrayList<>();
        public List<RawBone> children = new ArrayList<>();
    }

    public static ModelPart load(String resourcePath) {
        try (InputStream in = BedrockModelLoader.class.getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new IllegalArgumentException("Resource not found: " + resourcePath);
            }
            JsonObject rootObj = JsonParser.parseReader(new InputStreamReader(in, StandardCharsets.UTF_8)).getAsJsonObject();
            JsonArray geoArray = rootObj.getAsJsonArray("minecraft:geometry");
            JsonObject geo = geoArray.get(0).getAsJsonObject();

            JsonObject desc = geo.getAsJsonObject("description");
            int texWidth = desc.has("texture_width") ? desc.get("texture_width").getAsInt() : 64;
            int texHeight = desc.has("texture_height") ? desc.get("texture_height").getAsInt() : 64;

            JsonArray bonesArray = geo.getAsJsonArray("bones");
            Map<String, RawBone> boneMap = new LinkedHashMap<>();
            List<RawBone> rootBones = new ArrayList<>();

            for (JsonElement elem : bonesArray) {
                JsonObject bObj = elem.getAsJsonObject();
                RawBone bone = new RawBone();
                bone.name = bObj.get("name").getAsString();
                if (bObj.has("parent")) {
                    bone.parent = bObj.get("parent").getAsString();
                }

                if (bObj.has("pivot")) {
                    JsonArray piv = bObj.getAsJsonArray("pivot");
                    bone.px = piv.get(0).getAsFloat();
                    bone.py = piv.get(1).getAsFloat();
                    bone.pz = piv.get(2).getAsFloat();
                }

                if (bObj.has("rotation")) {
                    JsonArray rot = bObj.getAsJsonArray("rotation");
                    bone.rx = rot.get(0).getAsFloat();
                    bone.ry = rot.get(1).getAsFloat();
                    bone.rz = rot.get(2).getAsFloat();
                }

                if (bObj.has("cubes")) {
                    JsonArray cubesArray = bObj.getAsJsonArray("cubes");
                    for (JsonElement cElem : cubesArray) {
                        JsonObject cObj = cElem.getAsJsonObject();
                        RawCube cube = new RawCube();
                        JsonArray orig = cObj.getAsJsonArray("origin");
                        cube.ox = orig.get(0).getAsFloat();
                        cube.oy = orig.get(1).getAsFloat();
                        cube.oz = orig.get(2).getAsFloat();

                        JsonArray sz = cObj.getAsJsonArray("size");
                        cube.sx = sz.get(0).getAsFloat();
                        cube.sy = sz.get(1).getAsFloat();
                        cube.sz = sz.get(2).getAsFloat();

                        if (cObj.has("uv")) {
                            JsonElement uvElem = cObj.get("uv");
                            if (uvElem.isJsonArray()) {
                                JsonArray uvArr = uvElem.getAsJsonArray();
                                cube.u = uvArr.get(0).getAsInt();
                                cube.v = uvArr.get(1).getAsInt();
                            } else if (uvElem.isJsonObject()) {
                                JsonObject uvObj = uvElem.getAsJsonObject();
                                if (uvObj.has("north") && uvObj.getAsJsonObject("north").has("uv")) {
                                    JsonArray nuv = uvObj.getAsJsonObject("north").getAsJsonArray("uv");
                                    cube.u = nuv.get(0).getAsInt();
                                    cube.v = nuv.get(1).getAsInt();
                                }
                            }
                        }

                        if (cObj.has("inflate")) {
                            cube.inflate = cObj.get("inflate").getAsFloat();
                        }
                        if (cObj.has("mirror")) {
                            cube.mirror = cObj.get("mirror").getAsBoolean();
                        }
                        bone.cubes.add(cube);
                    }
                }

                boneMap.put(bone.name, bone);
            }

            // Build hierarchy
            for (RawBone bone : boneMap.values()) {
                if (bone.parent != null && boneMap.containsKey(bone.parent)) {
                    boneMap.get(bone.parent).children.add(bone);
                } else {
                    rootBones.add(bone);
                }
            }

            MeshDefinition mesh = new MeshDefinition();
            PartDefinition rootPartDef = mesh.getRoot();

            for (RawBone rootBone : rootBones) {
                addBoneRecursively(rootPartDef, rootBone, 0, 0, 0);
            }

            LayerDefinition layer = LayerDefinition.create(mesh, texWidth, texHeight);
            return layer.bakeRoot();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Bedrock model: " + resourcePath, e);
        }
    }

    private static void addBoneRecursively(PartDefinition parentDef, RawBone bone, float parentPx, float parentPy, float parentPz) {
        float relX = bone.px - parentPx;
        float relY = bone.py - parentPy;
        float relZ = bone.pz - parentPz;

        float radX = (float) Math.toRadians(bone.rx);
        float radY = (float) Math.toRadians(bone.ry);
        float radZ = (float) Math.toRadians(bone.rz);

        PartPose pose = PartPose.offsetAndRotation(relX, relY, relZ, radX, radY, radZ);

        CubeListBuilder cubeBuilder = CubeListBuilder.create();
        for (RawCube cube : bone.cubes) {
            float boxX = cube.ox - bone.px;
            float boxY = cube.oy - bone.py;
            float boxZ = cube.oz - bone.pz;

            cubeBuilder.texOffs(cube.u, cube.v)
                    .mirror(cube.mirror)
                    .addBox(boxX, boxY, boxZ, cube.sx, cube.sy, cube.sz, new CubeDeformation(cube.inflate));
        }

        PartDefinition currentDef = parentDef.addOrReplaceChild(bone.name, cubeBuilder, pose);

        for (RawBone child : bone.children) {
            addBoneRecursively(currentDef, child, bone.px, bone.py, bone.pz);
        }
    }
}
