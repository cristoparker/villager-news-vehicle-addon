# 🚁🚤 Villager News Vehicle Addon - Minecraft Bedrock Edition

[![Minecraft Bedrock](https://img.shields.io/badge/Minecraft-Bedrock%201.20%2B-brightgreen.svg)](https://minecraft.net/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

An authentic, fully-featured **Villager News Vehicle Addon** for Minecraft Bedrock Edition! Built directly from the legendary Element Animation *Villager News* series, featuring the iconic **Villager Helicopter** and the massive **Villager Boat**—both constructed entirely out of villagers doing their best impressions of vehicle parts.

---

## ✨ Included Vehicles & Features

### 1. 🚁 Villager News Helicopter (`renderphoenix:helicopter`)
- **Iconic 3D Model**: 173-bone full custom model made of villagers linked together into a helicopter chassis with dedicated 3D tilt bone.
- **Advanced 6-DOF Flight Physics**:
  - **Vertical Collective**: Hold **Jump** (Spacebar / A / X) to ascend smoothly; look downward sharply to descend smoothly.
  - **Rock-Solid Aerodynamic Hover**: Releasing controls holds altitude stably with realistic aerodynamic hover micro-bobbing.
  - **Cyclic Horizontal Movement (WASD)**:
    - Press **W**: Leans nose forward (-20° pitch) and propels forward.
    - Press **S**: Leans nose backward (+16° pitch) and brakes/reverses.
    - Press **A / D**: Banks laterally left/right (±16° roll) for realistic helicopter strafing.
  - **Smooth Yaw Heading**: Rotates smoothly with inertia to track your look direction.
  - **Authentic Rotor Audio**: Custom rhythmic dual-frequency chopper rotor acoustics that dynamically transition between ground idle and fast high-RPM flight.
- **Animated Dual Propellers**:
  - **Main Rotor (`main_propeller`)**: Quad-villager rotor blades spinning at high RPM.
  - **Tail Rotor (`back_propeller`)**: Tail stabilization villager rotor spinning rapidly in the Y-Z plane.
- **Villager Pilot AI (Random Wandering Flight)**:
  - Villagers can board the helicopter when nearby or when invited using an **Emerald**.
  - When piloted by a villager, it activates autonomous random flight AI (`minecraft:behavior.random_fly`)!
- **Auto-Landing & Touchdown**:
  - Touch down safely on ground or water, automatically re-engaging landing physics (`has_gravity: true`).
- **Hitbox**:
  - Custom hit test: `width: 3.4`, `height: 4`, `pivot: [0, 2, -0.6]`.

---

### 2. 🚤 Villager News Boat (`renderphoenix:boat`)
- **Massive 3D Model**: 217-bone full custom model made of villagers lying horizontally to form the hull floor (`boat_down`) and standing to form the bow, stern, and sides (`boat_up`).
- **Water Buoyancy**:
  - Floats and slides realistically on water and flowing water with wave simulation (`minecraft:buoyant`).
- **Multi-Seater (4 Seats)**:
  - **Captain's Seat (Main Rider/Control)**: `[0, 0.5, 1.7]`
  - **Passenger Seat 2**: `[0, 0.5, -0.5]`
  - **Passenger Seat 3**: `[0, 0.5, -2]`
  - **Passenger Seat 4**: `[0, 0.5, -3]`
- **Steering & Propulsion**:
  - Direct player rudder/ground control with WASD when seated in the pilot seat.
  - Villagers can also ride along in passenger seats or pilot the boat!
- **Hitbox**:
  - Custom hit test: `width: 3`, `height: 2.2`, `pivot: [0, 1.1, 0]`.

---

### 3. 🚒 Villager News Firefighter Car (`renderphoenix:firefighter`)
- **Iconic 3D Model**: Massive custom fire engine constructed entirely out of villagers, complete with a rooftop ladder pipe and 4 rolling villager-head wheels.
- **Dynamic Head & Looking AI**:
  - The front villager head actively looks at players when nearby (`minecraft:behavior.look_at_player`) and glances around randomly (`minecraft:behavior.random_look_around`).
  - Head rotation animation tracks entity target pitch and yaw (`query.target_x_rotation`, `query.target_y_rotation`).
- **Smooth 4-Wheel Rotation Animation**:
  - All 4 wheels (`wheel1`, `wheel2`, `wheel3`, `wheel4`) physically rotate forward along the X-axis axle as the vehicle moves along the ground using `query.modified_distance_moved`.
- **Spawn Egg / Command Summoning**:
  - Does not spawn randomly or naturally in the Overworld, keeping worlds clean. Spawnable via Spawn Egg or `/summon renderphoenix:firefighter`.
- **Driveable by Player**:
  - Hop aboard into the driver's seat at `[0, 4.1, 4.5]` and steer smoothly using **WASD** ground controls.
  - Safely steps over 1-block terrain obstacles (`minecraft:step_height: 1.06`).
  - Automatically switches back to wandering AI when the player dismounts.
- **Hitbox**:
  - Custom hit test: `width: 3.4`, `height: 3.5`, `pivot: [0, 1.75, 0.9]`.

---

### 4. 🪖 Villager News Tank (`renderphoenix:tank`)
- **Iconic 3D Model**: 231-bone authentic reconstruction straight from *Villager News: WAR!*, featuring the arched villager cannon, rotating turret (`tank_head`), and dual caterpillar tracks made of villagers chanting *"I am a wheel!"*.
- **Authentic Villager Wheels & Tracks**:
  - Full oval tread loop on each side complete with front idler curves, ground treads, top return runs, and rear sprocket curves.
  - 8 rotating road wheels (`wheel_r1`..`wheel_r4`, `wheel_l1`..`wheel_l4`) and sprocket wheels that roll along their pitch axis as the tank travels (`query.modified_distance_moved`).
  - Full 46-bone caterpillar tread and track chain conveyor animation moving in sync with road wheels.
- **Aiming Turret & Missile Launcher**:
  - Turret and arched cannon smoothly track target yaw (`query.target_y_rotation`) to aim where you look.
  - **Shoot Villager Missiles**: Right-click / tap while driving to launch a Villager Missile straight in the direction you are looking!
  - Missiles fly at high speed with billowing smoke trails and detonate on impact with a massive explosion!
- **Driveable Heavy Armor**:
  - Heavy armored chassis (200 HP) with `step_height: 1.06` to crawl over obstacles.
  - Mount the commander's hatch on top of the turret at `[0, 4.8, 1.5]` to command and drive across the terrain.
- **Hitbox**:
  - Custom hit test: `width: 5.0`, `height: 4.0`, `pivot: [0, 2.0, 0.2]`.

---

### 5. ✈️ Daladas Plane (`renderphoenix:plane`)
- **Iconic 3D Model**: Massive 471-bone custom airliner constructed entirely out of villagers forming the fuselage, swept wings, and tail fin straight from the legendary *Daladas Airlines* episode!
- **Exclusive Librarian Texture**:
  - Styled with the custom `librarian.png` texture as requested for Daladas.
- **Full Vanilla Vehicles Flight Mechanics**:
  - Ground roll taxi & acceleration: Hold **W** to accelerate along the runway.
  - Automatic lift-off transition to full 3D flight mode with gravity disengagement (`has_gravity: false`).
  - Smooth view-direction navigation and banking: The entire aircraft dynamically tilts and banks left/right when steering.
  - Realistic pitch climbing and diving via view direction.
  - **No Fuel Required**: Direct, seamless flight anytime without needing redstone or fuel items.
  - **Clean Aero Dynamics**: No distracting smoke trails or particle systems.
- **Aerial Barrel Roll Trick**:
  - Attack / Punch (left-click) while flying to execute an authentic aerial barrel roll in your steering direction!
  - Includes cinematic third-person camera transitions and continuous roll impulse.
- **Smooth Landing & Auto-Dismount Safety**:
  - Safe touchdown upon landing on ground or water, automatically re-engaging ground physics (`has_gravity: true`).
- **Air-to-Ground Missile Cannon**:
  - Right-click / tap **Shoot Missile** while flying to launch Villager Missiles in the direction you look!
- **Hitbox**:
  - Custom hit test: `width: 3.7`, `height: 2.0`, `pivot: [0, 1, 0]`.

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
  - 🚒 **Villager News Firefighter Spawn Egg**
  - 🪖 **Villager News Tank Spawn Egg**
  - ✈️ **Spawn Daladas Plane**
- **Commands**:
  ```mcfunction
  /summon renderphoenix:helicopter
  /summon renderphoenix:boat
  /summon renderphoenix:firefighter
  /summon renderphoenix:tank
  /summon renderphoenix:plane
  ```
- **Controls (Helicopter)**:
  - Right-click / tap **Fly Helicopter** to enter the pilot seat.
  - Hold **Space / Jump** to lift off and ascend smoothly into the sky.
  - Look down sharply to descend smoothly.
  - Release controls to hold altitude in a stable aerodynamic hover.
  - Press **W** to lean forward (-20° pitch) and propel forward.
  - Press **S** to lean backward (+16° pitch) and reverse/brake.
  - Press **A / D** to bank laterally (±16° roll) and strafe sideways.
  - Look around to turn and steer the helicopter heading smoothly.
  - Descend to the ground to land safely (automatically re-engages ground physics).
  - Sneak / Shift to dismount.
- **Controls (Boat)**:
  - Right-click / tap **Board Vehicle** to enter.
  - Use **WASD** to steer across rivers and oceans.
  - Sneak / Shift to dismount.
- **Controls (Firefighter)**:
  - Right-click / tap **Drive Firefighter** to hop into the driver seat at `[0, 4.1, 4.5]`.
  - Steer with **WASD** to drive around.
  - Sneak / Shift to dismount (the fire engine will resume wandering autonomously).
- **Controls (Tank)**:
  - Right-click / tap **Drive Tank** to mount the commander hatch on top of the turret at `[0, 4.8, 1.5]`.
  - Steer with **WASD** to drive across rough terrain.
  - Left-click to fire villager cannon missiles.
  - Look around to aim the rotating villager cannon.
  - Sneak / Shift to dismount.
- **Controls (Daladas Plane)**:
  - Right-click / tap **Fly Daladas Plane** to enter the cockpit.
  - Hold **W** to accelerate along the runway until taking off into the air.
  - Look in 3D space to smoothly steer, bank, climb, and dive.
  - Left-click / Attack while flying to perform an **aerial barrel roll trick**!
  - Right-click / tap **Shoot Missile** to launch Villager Missiles.
  - Touch down on ground or water to land smoothly.
  - Sneak / Shift to dismount.
- **Villager Boarding**:
  - Villagers can enter when nearby, or hold an **Emerald** and interact to invite the nearest villager aboard!
