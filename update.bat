@echo off
setlocal enabledelayedexpansion

title Villager News Vehicle Addon - Sync Tool

echo ==============================================================================
echo    VILLAGER NEWS VEHICLE ADDON - MOJANG DEVELOPMENT PACK SYNC TOOL
echo ==============================================================================
echo.

:: Determine source directories
set "SOURCE_DIR=%~dp0"
set "BP_SRC=%SOURCE_DIR%villager_news_vehicle_bp"
set "RP_SRC=%SOURCE_DIR%villager_news_vehicle_rp"

if not exist "%BP_SRC%" (
    echo [ERROR] Behavior Pack folder not found at: %BP_SRC%
    goto :error
)

if not exist "%RP_SRC%" (
    echo [ERROR] Resource Pack folder not found at: %RP_SRC%
    goto :error
)

:: Build list of all valid com.mojang target directories
set "TARGET_COUNT=0"

:: 1. Check all user profile directories under Roaming\Minecraft Bedrock\Users
if exist "%APPDATA%\Minecraft Bedrock\Users" (
    for /d %%U in ("%APPDATA%\Minecraft Bedrock\Users\*") do (
        set "T_PATH=%%~fU\games\com.mojang"
        if not exist "!T_PATH!" mkdir "!T_PATH!" 2>nul
        set /a TARGET_COUNT+=1
        set "TARGET_!TARGET_COUNT!=!T_PATH!"
    )
)

:: 2. Check standard UWP Bedrock directory
if exist "%LOCALAPPDATA%\Packages\Microsoft.MinecraftUWP_8wekyb3d8bbwe\LocalState\games\com.mojang" (
    set /a TARGET_COUNT+=1
    set "TARGET_!TARGET_COUNT!=%LOCALAPPDATA%\Packages\Microsoft.MinecraftUWP_8wekyb3d8bbwe\LocalState\games\com.mojang"
)

:: 3. Check Minecraft Preview / Beta directory
if exist "%LOCALAPPDATA%\Packages\Microsoft.MinecraftWindowsBeta_8wekyb3d8bbwe\LocalState\games\com.mojang" (
    set /a TARGET_COUNT+=1
    set "TARGET_!TARGET_COUNT!=%LOCALAPPDATA%\Packages\Microsoft.MinecraftWindowsBeta_8wekyb3d8bbwe\LocalState\games\com.mojang"
)

if %TARGET_COUNT% EQU 0 (
    echo [ERROR] No com.mojang directories found.
    goto :error
)

echo [INFO] Found %TARGET_COUNT% com.mojang target locations:
for /L %%i in (1,1,%TARGET_COUNT%) do (
    echo        [%%i] !TARGET_%%i!
)
echo.

:: Deploy packs to all targets
for /L %%i in (1,1,%TARGET_COUNT%) do (
    set "CUR_TARGET=!TARGET_%%i!"
    echo ------------------------------------------------------------------------------
    echo [SYNCING TO TARGET %%i/%TARGET_COUNT%] !CUR_TARGET!
    echo ------------------------------------------------------------------------------

    :: Clean up old deprecated helicopter-only pack folders if present
    if exist "!CUR_TARGET!\development_behavior_packs\villager_helicopter_bp" (
        rmdir /s /q "!CUR_TARGET!\development_behavior_packs\villager_helicopter_bp" 2>nul
    )
    if exist "!CUR_TARGET!\development_resource_packs\villager_helicopter_rp" (
        rmdir /s /q "!CUR_TARGET!\development_resource_packs\villager_helicopter_rp" 2>nul
    )

    set "DEV_BP=!CUR_TARGET!\development_behavior_packs\villager_news_vehicle_bp"
    set "DEV_RP=!CUR_TARGET!\development_resource_packs\villager_news_vehicle_rp"

    echo   [1/2] Copying Behavior Pack...
    if not exist "!DEV_BP!" mkdir "!DEV_BP!"
    robocopy "%BP_SRC%" "!DEV_BP!" /MIR /FFT /Z /NP /NJH /NJS /NDL
    if errorlevel 8 (
        echo   [ERROR] Failed to sync Behavior Pack to !CUR_TARGET!
        goto :error
    )
    echo         ^-- Behavior Pack updated!

    echo   [2/2] Copying Resource Pack...
    if not exist "!DEV_RP!" mkdir "!DEV_RP!"
    robocopy "%RP_SRC%" "!DEV_RP!" /MIR /FFT /Z /NP /NJH /NJS /NDL
    if errorlevel 8 (
        echo   [ERROR] Failed to sync Resource Pack to !CUR_TARGET!
        goto :error
    )
    echo         ^-- Resource Pack updated!
    echo.
)

echo ==============================================================================
echo [SUCCESS] Villager News Vehicle Addon updated across all Minecraft profiles!
echo           Vehicles: Helicopter, Daladas Plane, Tank, Boat, Firefighter
echo           Ready to test in Minecraft Bedrock Edition!
echo ==============================================================================
echo.
pause
exit /b 0

:error
echo.
echo ==============================================================================
echo [FAILED] An error occurred while updating the packs.
echo ==============================================================================
echo.
pause
exit /b 1
