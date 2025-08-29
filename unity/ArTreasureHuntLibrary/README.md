# AR Treasure Hunt Library - Android Project

This is a Unity-based Android project for AR Treasure Hunt functionality.

## Project Setup

### Prerequisites
- Android Studio (latest version)
- Android SDK with API level 35
- Android NDK version 23.1.7779620
- Java 17

### Environment Setup
1. Make sure you have the Android SDK installed at `/Users/diveroidteam/Library/Android/sdk/`
2. Ensure NDK version 23.1.7779620 is installed
3. Set JAVA_HOME to point to Java 17

### Opening in Android Studio
1. Open Android Studio
2. Select "Open an existing Android Studio project"
3. Navigate to this project directory and select it
4. Wait for the project to sync and build

### Building the Project

#### Command Line
```bash
# Clean the project
./gradlew clean

# Build the project
./gradlew build

# Create debug APK
./gradlew assembleDebug

# Create release APK
./gradlew assembleRelease
```

#### Android Studio
1. Open the project in Android Studio
2. Wait for Gradle sync to complete
3. Click "Build" → "Make Project" or press Ctrl+F9 (Cmd+F9 on Mac)
4. To create APK: "Build" → "Build Bundle(s) / APK(s)" → "Build APK(s)"

## Project Structure

- `launcher/` - Main Android application module
- `unityLibrary/` - Unity library module containing the game logic
- `unityLibrary/xrmanifest.androidlib/` - XR manifest library for AR functionality

## Key Features

- AR Core integration for augmented reality
- Unity game engine integration
- Android native development

## Troubleshooting

### Common Issues and Fixes

1. **Missing gradlew file**
   - The gradlew script has been created for Unix/Linux systems
   - Make sure it's executable: `chmod +x gradlew`

2. **NDK path issues**
   - NDK path has been updated to point to the correct version: `/Users/diveroidteam/Library/Android/sdk/ndk/23.1.7779620`

3. **IL2CPP build issues**
   - The build process has been modified to skip IL2CPP compilation if the library already exists
   - This prevents build failures when the il2cpp executable is missing

4. **Namespace conflicts**
   - Removed deprecated package attribute from AndroidManifest.xml
   - Namespace is now properly defined in build.gradle files

5. **Firebase dependencies**
   - Firebase dependencies are temporarily commented out
   - Local repository paths have been commented out to prevent build issues

### Build Warnings

The following warnings are expected and don't affect functionality:
- ARCore namespace conflicts between modules (this is normal for AR projects)
- Deprecated API usage in UnityPlayerGameActivity (Unity internal code)

## APK Location

Debug APK: `launcher/build/outputs/apk/debug/launcher-debug.apk`
Release APK: `launcher/build/outputs/apk/release/launcher-release.apk`

## Notes

- This project is configured for ARM64 architecture only
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 35 (Android 15)
- The project uses Unity's IL2CPP scripting backend
