package org.shellzero.smartphonestatus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.shellzero.smartphonestatus.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

public class BatteryStatusActivity extends Activity {
	
	TextView textBatteryLevel = null;
	String batteryLevelInfo = "Battery Level";
		
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battery);
		textBatteryLevel = (TextView) findViewById(R.id.batterylevel);
		registerBatteryLevelReceiver();
	}
	
	/*
	 * Subscription to the Battery related Broadcast events and update the appropriate UI controls
	 * */
	private BroadcastReceiver battery_receiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			boolean isPresent = intent.getBooleanExtra("present", false);
			//Battery Technology
			String technology = intent.getStringExtra("technology");
			//Battery Plugged Information
			int plugged = intent.getIntExtra("plugged", -1);
            //Battery Scale
			int scale = intent.getIntExtra("scale", -1);
			//Battery Health
			int health = intent.getIntExtra("health", 0);
			//Battery Charging Status
			int status = intent.getIntExtra("status", 0);
			//Battery temperature
			int temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
			//Battery voltage
			int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
			//Battery charging level
			int rawlevel = intent.getIntExtra("level", -1);
			int level = 0;
			Bundle bundle = intent.getExtras();
			Log.i("BatteryLevel", bundle.toString());
			if (isPresent) {
				if (rawlevel >= 0 && scale > 0) {
					level = (rawlevel * 100) / scale;
				}
				String info = "Battery Level: " + level + "%\n";
				info += ("Technology: " + technology + "\n");
				info += ("Plugged: " + getPlugTypeString(plugged) + "\n");
				info += ("Health: " + getHealthString(health) + "\n");
				info += ("Status: " + getStatusString(status) + "\n");
				info += ("Temperature: "+ temp + "\n");
				info += ("Voltage: "+ voltage + "\n");
				setBatteryLevelText(info);
				/*try{
					TimeUnit.MINUTES.sleep(10);
				}catch(InterruptedException e){
					e.printStackTrace();
				}*/
				addLog(level+"%".toString());
			} else {
				setBatteryLevelText("Battery not present!!!");
			}
		}
	};

	/*
	 * Battery Plugged Information
	 * */
	private String getPlugTypeString(int plugged) {
		String plugType = "Unknown";

		switch (plugged) {
		case BatteryManager.BATTERY_PLUGGED_AC:
			plugType = "AC";
			break;
		case BatteryManager.BATTERY_PLUGGED_USB:
			plugType = "USB";
			break;
		}

		return plugType;
	}

	/*
	 * General health of the Battery
	 * */
	private String getHealthString(int health) {
		String healthString = "Unknown";

		switch (health) {
		case BatteryManager.BATTERY_HEALTH_DEAD:
			healthString = "Dead";
			break;
		case BatteryManager.BATTERY_HEALTH_GOOD:
			healthString = "Good";
			break;
		case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
			healthString = "Over Voltage";
			break;
		case BatteryManager.BATTERY_HEALTH_OVERHEAT:
			healthString = "Over Heat";
			break;
		case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
			healthString = "Failure";
			break;
		}

		return healthString;
	}

	/*
	 * Charging status of the Battery
	 * */
	private String getStatusString(int status) {
		String statusString = "Unknown";

		switch (status) {
		case BatteryManager.BATTERY_STATUS_CHARGING:
			statusString = "Charging";
			break;
		case BatteryManager.BATTERY_STATUS_DISCHARGING:
			statusString = "Discharging";
			break;
		case BatteryManager.BATTERY_STATUS_FULL:
			statusString = "Full";
			break;
		case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
			statusString = "Not Charging";
			break;
		}

		return statusString;
	}
	
	/*
	 * Power status of the Battery
	 *
	private String getPowerStatusString(int power){
		String powerStatusString = "Unknown";
		
		switch(power){
		case BatteryManager.BATTERY_PROPERTY_CAPACITY:
		}
		
		
		return powerStatusString;
		
	} */

	/*
	 * Battery Status TextView update
	 * */
	private void setBatteryLevelText(String text) {
		textBatteryLevel.setText(text);
	}

	/*
	 * Battery Related Broadcast event registration 
	 * */
	private void registerBatteryLevelReceiver() {
		IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(battery_receiver, filter);
	}
	
	/*
	 * Logging the changes in the power consumption in time intervals to a file stored on internal
	 * storage in Android
	 */
	public void addLog(String power_level){
		/* creates a logFile in the root directory of the internal storage of the application.
		// If the file does not exists, then it is created.
		//File logFile = new File(((Context)this).getExternalFilesDir(null), "logFile.txt");
		//File logFile = new File(getFilesDir(), "logFile.txt");
		Log.d("FilesDir Path", getFilesDir().getAbsolutePath());
		Log.d("FilesDir Name", getFilesDir().getName());
		Log.d("Path on Android", logFile.getPath());
		Log.d("Absolute Path on Android", logFile.getAbsolutePath());
		Log.d("Parent", logFile.getParent());
		if(!logFile.exists()){
			try{
				logFile.createNewFile();
			}catch(IOException io){
				io.printStackTrace();
			}
		}
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
			writer.write("Battery level reading");
			writer.append(power_level);
			System.out.println("Current Power Level: " +power_level);
			Log.d("Power_Level in try", power_level);
			writer.newLine();
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		} */
		Log.d("Entry", "In the addLog method");

		try{
			File root = new File(Environment.getExternalStorageDirectory(),"PowerStatus");
			if(!root.exists()){
				Log.d("If loop", "Entered if loop");
				root.mkdirs();
			}
			
			
			File logFile = new File(root, "logFile.txt");
			Log.d("File path", logFile.getAbsolutePath());
			if(!logFile.exists()){
				logFile.createNewFile();
			}
			//FileWriter writer = new FileWriter(logFile);
			BufferedWriter writer = new BufferedWriter(new FileWriter(logFile,true));
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			//Long tsLong = System.currentTimeMillis()/1000;
			Date date = new Date(timestamp.getTime());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy' 'HH:mm:ss");
			String date_format = simpleDateFormat.format(timestamp);
			//String ts = tsLong.toString();
			//int count =1;
			//writer.write("Battery level reading");
			String formatStr = "%20s %20s%n";
			//writer.append(date_format + " " + power_level);
			writer.append(String.format(formatStr, date_format, power_level));
			//count++;
			writer.newLine();
			writer.flush();
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
