# 🚁🚤 Villager News Vehicle Addon - Minecraft Bedrock Edition

[![Minecraft Bedrock](https://img.shields.io/badge/Minecraft-Bedrock%201.20%2B-brightgreen.svg)](https://minecraft.net/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

An authentic, fully-featured **Villager News Vehicle Addon** for Minecraft Bedrock Edition! Built directly from the legendary Element Animation *Villager News* series, featuring the iconic **Villager Helicopter** and the massive **Villager Boat**—both constructed entirely out of villagers doing their best impressions of vehicle parts.

---

## ✨ Included Vehicles & Features

### 1. 🚁 Villager News Helicopter (`villager_news:helicopter`)
- **Iconic 3D Model**: 171-bone full custom model made of villagers linked together into a helicopter chassis.
- **Animated Dual Propellers**:
  - **Main Rotor (`main_propeller`)**: Quad-villager rotor blades spinning smoothly horizontally in the X-Z plane at high RPM.
  - **Tail Rotor (`back_propeller`)**: Tail stabilization villager rotor spinning rapidly in the Y-Z plane.
- **Player-Controlled 3D Flight**:
  - Steer in 3D space in the direction you look using standard movement controls (WASD).
  - Hold **Jump** (Spacebar / A / X) to ascend vertically.
  - Player cockpit seat positioned precisely at `[0, 0.5, -0.6]`.
- **Villager Pilot AI (Random Wandering Flight)**:
  - Villagers can board the helicopter when nearby or when invited using an **Emerald**.
  - When piloted by a villager, it activates autonomous random flight AI (`minecraft:behavior.random_fly`) and takes off across the sky!
- **Auto-Landing & Dismount Safety**:
  - Real-time animation controller monitors rider presence (`query.has_rider`).
  - When riders dismount, gravity re-engages and the helicopter safely touches down on the ground.
- **Hitbox**:
  - Custom hit test: `width: 3.4`, `height: 4`, `pivot: [0, 2, -0.6]`.

---

### 2. 🚤 Villager News Boat (`villager_news:boat`)
- **Massive 3D Model**: 217-bone full custom model made of villagers lying horizontally to form the hull floor (`boat_down`) and standing to form the bow, stern, and sides (`boat_up`).
- **Water Buoyancy**:
  - Floats and slides realistically on water and flowing water with wave simulation (`minecraft:buoyant`).
- **Dual Seating (2-Seater)**:
  - **Captain's Seat (Pilot)**: `[0, 0.4, -0.6]`
  - **Passenger Seat**: `[0, 0.4, 0.8]`
- **Steering & Propulsion**:
  - Direct player rudder/ground control with WASD when seated in the pilot seat.
  - Villagers can also ride along or pilot the boat!
- **Hitbox**:
  - Custom hit test: `width: 3.8`, `height: 2.2`, `pivot: [0, 1.1, 0]`.

---

## 📁 Repository Structure

```
villager-news-vehicle-addon/
├── .gitignore                                      # Git ignore rules
├── README.md                                       # Full documentation
├── update.bat                                      # 1-Click sync to com.mojang dev folders
├── pack_icon.png                                   # Addon thumbnail & pack icon
├── farmer.png                                      # Base texture
├── villager_helecopter.geo.json                     # Original helicopter geometry
├── villager_boat.json                              # Original boat geometry
├── villager_news_vehicle_bp/                       # Behavior Pack (BP)
│   ├── manifest.json
│   ├── pack_icon.png
│   ├── animation_controllers/
│   │   └── villager_helicopter.animation_controllers.json
│   └── entities/
│       ├── villager_helicopter.json
│       └── villager_boat.json
└── villager_news_vehicle_rp/                       # Resource Pack (RP)
    ├── manifest.json
    ├── pack_icon.png
    ├── animations/
    │   └── villager_helicopter.animation.json
    ├── entity/
    │   ├── villager_helicopter.entity.json
    │   └── villager_boat.entity.json
    ├── models/
    │   └── entity/
    │       ├── villager_helicopter.geo.json
    │       └── villager_boat.geo.json
    ├── render_controllers/
    │   ├── villager_helicopter.render_controllers.json
    │   └── villager_boat.render_controllers.json
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
Run `update.bat` by double-clicking it. It automatically syncs both packs directly to your local `com.mojang` development folders:
```bat
update.bat
```

### 2. Activate in Minecraft
1. Open **Minecraft Bedrock Edition**.
2. Create or edit a world.
3. Under **Behavior Packs**, activate **Villager News Vehicle Addon BP**.
4. Under **Resource Packs**, activate **Villager News Vehicle Addon RP**.

### 3. Spawning & Controls
- **Creative Spawn Eggs**:
  - 🚁 **Villager News Helicopter Spawn Egg**
  - 🚤 **Villager News Boat Spawn Egg**
- **Commands**:
  ```mcfunction
  /summon villager_news:helicopter
  /summon villager_news:boat
  ```
- **Controls (Helicopter)**:
  - Right-click / tap **Fly Helicopter** to enter the pilot seat.
  - Look where you want to go and press **WASD**.
  - Hold **Space / Jump** to ascend.
  - Sneak / Shift to dismount.
- **Controls (Boat)**:
  - Right-click / tap **Board Vehicle** to enter.
  - Use **WASD** to steer across rivers and oceans.
  - Sneak / Shift to dismount.
- **Villager Boarding**:
  - Villagers can enter when nearby, or hold an **Emerald** and interact to invite the nearest villager aboard!
