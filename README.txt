1. Configuration and running environment locally
- Install Android Studio
- Install Appium
- Set systempath for Java SDK, Java JRE and Android sdk and add system variables for ANDROID_HOME, JAVA_HOME
- Get the virtual device info:
 +) from Android virtual device manager (device virtual name, platformName, version Android...)
 +) emulator name : go to cmd : enter : adb devices
 +) get apk info (package name, activity) by
   *) 1. Run apk in virtual device
   *) 2.go to cmd , enter :
 adb shell
 dumpsys window windows | grep -E 'mCurrentFocus'
- Import project as maven => get libs from pom file ( TestNg, Appium , Selenium)


Running :
- Open virtual device -> open app
- Open Appium -> setup host 127.0.0.1, port :4723 -> add device Info, apk info in desired capabilities
- You can run directly from zigzagTest or by command line : mvn test

2. Integrate with Jenkins
- It would be best if you can run test in Jenkins with device farm ( AWS device farm)
- Set up android, appium , java in server machine
- Config Jenkins with github/bitbucket/gitlab links, also the branch, credential
- Setup the type of trigger (after developer build, at certain time by cron expression)

- Run by command
mvn test
- Send report if failed to email