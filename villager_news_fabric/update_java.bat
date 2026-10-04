@echo off
setlocal enabledelayedexpansion

echo ========================================================
echo   VILLAGER NEWS VEHICLES - FABRIC AUTO UPDATE SCRIPT
echo ========================================================
echo.

:: Configure Java Runtime from FreesmLauncher
set "JAVA_HOME=C:\Users\Miku\AppData\Roaming\FreesmLauncher\java\java-runtime-epsilon"
set "PATH=%JAVA_HOME%\bin;%PATH%"

:: Configure Target Mods Directory
set "TARGET_MODS_DIR=C:\Users\Miku\AppData\Roaming\FreesmLauncher\instances\26.3\minecraft\mods"

:: Determine Project Directory
set "SCRIPT_DIR=%~dp0"
if exist "%SCRIPT_DIR%gradlew.bat" (
    set "PROJECT_DIR=%SCRIPT_DIR%"
) else if exist "%SCRIPT_DIR%villager_news_fabric\gradlew.bat" (
    set "PROJECT_DIR=%SCRIPT_DIR%villager_news_fabric"
) else (
    echo [ERROR] Could not locate gradlew.bat!
    pause
    exit /b 1
)

echo [1/4] Using Java Runtime: %JAVA_HOME%
"%JAVA_HOME%\bin\java.exe" -version
echo.

echo [2/4] Building Fabric Mod...
pushd "%PROJECT_DIR%"
call gradlew.bat build
if %ERRORLEVEL% neq 0 (
    echo.
    echo [ERROR] Gradle build failed with exit code %ERRORLEVEL%!
    popd
    pause
    exit /b %ERRORLEVEL%
)

:: Locate built jar (excluding sources jar)
set "BUILT_JAR="
for /f "delims=" %%F in ('dir /b /o-d "build\libs\villagernews-*.jar" 2^>nul') do (
    echo %%F | findstr /i "sources" >nul
    if errorlevel 1 (
        if not defined BUILT_JAR (
            set "BUILT_JAR=%PROJECT_DIR%\build\libs\%%F"
            set "JAR_NAME=%%F"
        )
    )
)

if not defined BUILT_JAR (
    echo [ERROR] Could not find built villagernews jar in %PROJECT_DIR%\build\libs!
    popd
    pause
    exit /b 1
)

echo.
echo [3/4] Found built mod: %JAR_NAME%
popd

:: Ensure target mods directory exists
if not exist "%TARGET_MODS_DIR%" (
    echo Creating target mods directory...
    mkdir "%TARGET_MODS_DIR%"
)

echo [4/4] Updating mod in Minecraft instance...
:: Remove old versions
del /f /q "%TARGET_MODS_DIR%\villagernews-*.jar" 2>nul
del /f /q "%TARGET_MODS_DIR%\modid-*.jar" 2>nul

:: Copy new version
copy /y "%BUILT_JAR%" "%TARGET_MODS_DIR%\" >nul
if %ERRORLEVEL% equ 0 (
    echo.
    echo ========================================================
    echo   UPDATE SUCCESSFUL!
    echo   Deployed: %JAR_NAME%
    echo   Target:   %TARGET_MODS_DIR%
    echo ========================================================
    echo.
) else (
    echo.
    echo [ERROR] Failed to copy %JAR_NAME% to %TARGET_MODS_DIR%!
    pause
    exit /b 1
)

endlocal
