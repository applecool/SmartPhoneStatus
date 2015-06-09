# SmartPhoneStatus
An Android application designed and developed for my research, which shows the charging and power status of the phone. Logs the power to a file for further analysis.

Install the application and when you open it, the app has two tabs. Tap on the Battery tab and you can see the voltage, charging, status, temperature.

Installation Instructions:

Method 1:

1. You need to modify your Android’s settings to allow the installation of applications from other sources. Under “Settings,” select “Application Settings” and then enable “Unknown Sources.” Also under “Settings,” select “SD Card” and “Phone Storage,” and finally enable “Disable Use for USB Storage”.
2. Copy the .apk file [APK stands for Android Application Package] to your SD card.
3. Tap on the .apk file to install it on your phone or tablet.

Method 2:

1. Copy the apk to SD card.
2. Download an app called "AppInstaller" from Android Market [Google Play].
3. On opening the app you can see the apk file in the list.
4. Click on the app, and it gets installed.

Method 3: [Most easiest way]

1. Attach the .apk file to your gmail account and send it to yourself.
2. Open the mail on your mobile and click [tap] on the the .apk file. 
3. It'll be automatically installed into your android device.


Note: For all the three methods, You need to Enable the "Unknown Sources" under your Application Settings as indicated in the step 1 of the Method 1.


Usage:

1. After installing the app, open it. You will see two tabs 1. Phone and 2. Battery.
2. By default the Phone tab is activated when the app is opened. This tab contains the Cellular network related information.
3. Tap on the Battery tab. You will see different kinds of information such as Health of the battery, Status of the battery [Charging or Discharging], Battery Technology, Temperature, Voltage and Battery Level. 
4. Now you can minimize the application and let it run in background. Don't close or quit the application. 
5. You can observe that there is a folder named "PowerStatus" is created in your SD Card[Memory Card/Internal Storage]. Under this folder, you have a file called as "LogFile.txt" created.
6. The Battery Level keeps on logging to the LogFile.

Note: If you close/ quit the application, the battey level data is not appended to the LogFile. In case you close the application, when you re-open it, make sure you tap on the battery tab and then minimize the application. Unless you tap on the Battery tab, the data is not logged. When the phone is switched off, all the minimized applications are closed. So, when you reboot your device, you have run the application again. [The PowerStatus directory and the LogFile.txt file doesnt get deleted if the application is quit or phone is closed.]
