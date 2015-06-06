# SmartPhoneStatus
An Android application designed and developed for my research, which shows the charging and power status of the phone. Logs the power to a file for further analysis.

Install the application and when you open it, the app has two tabs. Tap on the Battery tab and you can see the voltage, charging, status, temperature.

Usage:

1. After installing the app, open it. You will see two tabs 1. Phone and 2. Battery.
2. By default the Phone tab is activated when the app is opened. This tab contains the Cellular network related information.
3. Tap on the Battery tab. You will see different kinds of information such as Health of the battery, Status of the battery [Charging or Discharging], Battery Technology, Temperature, Voltage and Battery Level. 
4. Now you can minimize the application and let it run in background. Don't close or quit the application. 
5. You can observe that there is a folder named "PowerStatus" is created in your SD Card[Memory Card/Internal Storage]. Under this folder, you have a file called as "LogFile.txt" created.
6. The Battery Level keeps on logging to the LogFile.

Note: If you close/ quit the application, the battey level data is not appended to the LogFile. In case you close the application, when you re-open it, make sure you tap on the battery tab and then minimize the application. Unless you tap on the Battery tab, the data is not logged. When the phone is switched off, all the minimized applications are closed. So, when you reboot your device, you have run the application again. [The PowerStatus directory and the LogFile.txt file doesnt get deleted if the application is quit or phone is closed.]
