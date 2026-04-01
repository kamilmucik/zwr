#!/bin/bash

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

echo $SCRIPT_DIR

mvn clean

watchman watch-del-all

rm -rf node_modules

rm -rfv $SCRIPT_DIR/android/build
#rm -rfv $SCRIPT_DIR/android/app/build
rm -rfv $SCRIPT_DIR/android/.gradle
cd $SCRIPT_DIR/android/
gradle wrapper
cd $SCRIPT_DIR


#npm install @react-native-community
npm install @react-navigation/native
expo install react-native-screens react-native-safe-area-context
npm install @react-navigation/native-stack


npm install

#react-native run-android
rm -rfv $SCRIPT_DIR/android/app/src/main/res/drawable-*
rm -rfv $SCRIPT_DIR/android/app/src/main/res/raw

#cp -a ..app/assets/android/* …/android/app/src/main/res
mkdir -p $SCRIPT_DIR/android/app/src/main/assets

npx react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle --assets-dest android/app/src/main/res

cd $SCRIPT_DIR/android/

$SCRIPT_DIR/android/gradlew clean assembleDebug

# cd $SCRIPT_DIR
echo 'scp '$SCRIPT_DIR'/android/app/build/outputs/apk/debug/app-debug.apk ubuntu@e-strix.pl:/home/ubuntu/wp/releases/megapack/202501/version-debug.apk'
#sshpass -p 'syjAkywapy1' scp $SCRIPT_DIR/android/app/build/outputs/apk/release/app-release.apk ubuntu@e-strix.pl:/home/ubuntu/wp/releases/megapack/2.6.0/version.apk

sshpass -p 'syjAkywapy1' scp $SCRIPT_DIR/android/app/build/outputs/apk/debug/app-debug.apk ubuntu@e-strix.pl:/home/ubuntu/wp/releases/megapack/2.6.0/version.apk

