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

:: Detect com.mojang location
set "MOJANG_DIR="

:: Check new Bedrock Launcher directory (Roaming)
if exist "%APPDATA%\Minecraft Bedrock\Users\Shared\games\com.mojang" (
    set "MOJANG_DIR=%APPDATA%\Minecraft Bedrock\Users\Shared\games\com.mojang"
)

:: Check standard UWP Bedrock directory
if not defined MOJANG_DIR (
    if exist "%LOCALAPPDATA%\Packages\Microsoft.MinecraftUWP_8wekyb3d8bbwe\LocalState\games\com.mojang" (
        set "MOJANG_DIR=%LOCALAPPDATA%\Packages\Microsoft.MinecraftUWP_8wekyb3d8bbwe\LocalState\games\com.mojang"
    )
)

:: Check Minecraft Preview / Beta directory
if not defined MOJANG_DIR (
    if exist "%LOCALAPPDATA%\Packages\Microsoft.MinecraftWindowsBeta_8wekyb3d8bbwe\LocalState\games\com.mojang" (
        set "MOJANG_DIR=%LOCALAPPDATA%\Packages\Microsoft.MinecraftWindowsBeta_8wekyb3d8bbwe\LocalState\games\com.mojang"
    )
)

:: If none found, create standard launcher path
if not defined MOJANG_DIR (
    if exist "%APPDATA%\Minecraft Bedrock" (
        set "MOJANG_DIR=%APPDATA%\Minecraft Bedrock\Users\Shared\games\com.mojang"
    ) else (
        set "MOJANG_DIR=%LOCALAPPDATA%\Packages\Microsoft.MinecraftUWP_8wekyb3d8bbwe\LocalState\games\com.mojang"
    )
    echo [INFO] com.mojang folder was not found. Initializing at:
    echo        !MOJANG_DIR!
    echo.
)

echo [TARGET] com.mojang path detected:
echo          %MOJANG_DIR%
echo.

:: Clean up old deprecated helicopter-only pack folders if present
if exist "%MOJANG_DIR%\development_behavior_packs\villager_helicopter_bp" (
    rmdir /s /q "%MOJANG_DIR%\development_behavior_packs\villager_helicopter_bp" 2>nul
)
if exist "%MOJANG_DIR%\development_resource_packs\villager_helicopter_rp" (
    rmdir /s /q "%MOJANG_DIR%\development_resource_packs\villager_helicopter_rp" 2>nul
)

set "DEV_BP=%MOJANG_DIR%\development_behavior_packs\villager_news_vehicle_bp"
set "DEV_RP=%MOJANG_DIR%\development_resource_packs\villager_news_vehicle_rp"

echo [1/2] Syncing Behavior Pack...
echo       From: %BP_SRC%
echo       To:   %DEV_BP%
if not exist "%DEV_BP%" mkdir "%DEV_BP%"
robocopy "%BP_SRC%" "%DEV_BP%" /MIR /FFT /Z /NP /NJH /NJS /NDL
if errorlevel 8 (
    echo [ERROR] Failed to sync Behavior Pack.
    goto :error
)
echo       ^-- Behavior Pack updated successfully!
echo.

echo [2/2] Syncing Resource Pack...
echo       From: %RP_SRC%
echo       To:   %DEV_RP%
if not exist "%DEV_RP%" mkdir "%DEV_RP%"
robocopy "%RP_SRC%" "%DEV_RP%" /MIR /FFT /Z /NP /NJH /NJS /NDL
if errorlevel 8 (
    echo [ERROR] Failed to sync Resource Pack.
    goto :error
)
echo       ^-- Resource Pack updated successfully!
echo.

echo ==============================================================================
echo [SUCCESS] Villager News Vehicle Addon updated in com.mojang!
echo           Vehicles included: Helicopter, Boat, Firefighter Car, and Tank
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
