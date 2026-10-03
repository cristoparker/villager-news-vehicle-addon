# 🚁 Villager News Helicopter - Minecraft Bedrock Add-on

[![Minecraft Bedrock](https://img.shields.io/badge/Minecraft-Bedrock%201.20%2B-brightgreen.svg)](https://minecraft.net/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

An authentic, fully-functional **Villager News Helicopter** vehicle add-on for Minecraft Bedrock Edition! Built straight out of the iconic Element Animation *Villager News* series, where the helicopter is crafted entirely of villagers doing their best impressions of helicopter components.

---

## ✨ Features

- **Iconic 3D Model**: 171-bone full custom model made of villagers linked together into a helicopter chassis.
- **Animated Dual Propellers**:
  - **Main Rotor**: Quad-villager rotor blades spinning smoothly at high RPM horizontally in the X-Z plane.
  - **Tail Rotor**: Rear stabilization villager rotor spinning rapidly in the Y-Z plane.
- **Player-Controlled 3D Flight**:
  - Steer smoothly in 3D space in the direction you look using standard movement controls (WASD).
  - Hold **Jump** (Space / A / X) to ascend into the clouds.
  - Custom player seat configured at `[0, 0.5, -0.6]` for a perfect cockpit view.
- **Villager Pilot AI (Random Wandering Flight)**:
  - Villagers can board the helicopter!
  - When a villager pilots the helicopter, it activates autonomous random flight AI (`minecraft:behavior.random_fly`) and takes off across the sky!
  - You can also invite nearby villagers aboard by holding an **Emerald** and interacting with the helicopter.
- **Automatic Landing & Dismount Safety**:
  - Real-time animation controller monitors rider presence (`query.has_rider`).
  - When riders dismount, gravity re-engages and the helicopter safely touches down on the ground.
- **Accurate Hitbox**: Configured with `minecraft:custom_hit_test` (`width: 3.1`, `height: 3.8`, `pivot: [0, 1.9, -0.6]`).
- **One-Click Dev Sync (`update.bat`)**: Automatically detects your Minecraft Bedrock installation and syncs the packs directly to `development_behavior_packs` and `development_resource_packs`.

---

## 📁 Repository Structure

```
villager-news-vehicle-addon/
├── .gitignore                                      # Git ignore rules
├── README.md                                       # Documentation & guide
├── update.bat                                      # 1-Click sync to com.mojang dev folders
├── pack_icon.png                                   # Add-on thumbnail & pack icon
├── farmer.png                                      # Base texture
├── villager_helecopter.geo.json                     # Original geometry model
├── villager_helicopter_bp/                         # Behavior Pack (BP)
│   ├── manifest.json
│   ├── pack_icon.png
│   ├── animation_controllers/
│   │   └── villager_helicopter.animation_controllers.json
│   └── entities/
│       └── villager_helicopter.json
└── villager_helicopter_rp/                         # Resource Pack (RP)
    ├── manifest.json
    ├── pack_icon.png
    ├── animations/
    │   └── villager_helicopter.animation.json
    ├── entity/
    │   └── villager_helicopter.entity.json
    ├── models/
    │   └── entity/
    │       └── villager_helicopter.geo.json
    ├── render_controllers/
    │   └── villager_helicopter.render_controllers.json
    ├── texts/
    │   ├── en_US.lang
    │   └── languages.json
    └── textures/
        └── entity/
            └── villager_helicopter/
                └── farmer.png
```

---

## 🎮 How to Play & Test

### 1. Fast Development Sync (`update.bat`)
Run `update.bat` by double-clicking it. It automatically copies the packs to your local `com.mojang` development folders:
```bat
update.bat
```

### 2. Activate in Minecraft
1. Open **Minecraft Bedrock Edition**.
2. Create or edit a world.
3. Under **Behavior Packs**, activate **Villager News Helicopter BP**.
4. Under **Resource Packs**, activate **Villager News Helicopter RP**.
5. Enable **Holiday Creator Features** / Experimental features if prompted.

### 3. Spawning & Controls
- **Creative Spawn Egg**: Find the **Villager News Helicopter** egg in the creative inventory under Nature/Spawn Eggs.
- **Command**:
  ```mcfunction
  /summon villager_news:helicopter
  ```
- **Boarding (Player)**:
  - Right-click / tap **Fly Helicopter** to enter the pilot seat.
  - Look in the direction you wish to fly and use WASD.
  - Hold **Space / Jump** to ascend.
  - Sneak / Shift to dismount.
- **Villager Pilot**:
  - When a villager walks close to an unpiloted helicopter (or you hold an Emerald and interact), the villager will board and fly around autonomously!
