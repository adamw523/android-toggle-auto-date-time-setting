package ca.tbcn.timesettings;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class TimeSettingsActivity extends Activity {
	public static String TAG = "TimeSettings"; 
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    	try {
    		
			int autoTime = android.provider.Settings.System.getInt(getContentResolver(),
					android.provider.Settings.System.AUTO_TIME);
			Log.i(TAG, new Integer(autoTime).toString());
			
			CheckBox cbAutoTime = (CheckBox) findViewById(R.id.cb_auoto_time);
			Log.i(TAG, cbAutoTime.toString());
			cbAutoTime.setChecked(autoTime == 1);
			cbAutoTime.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					android.provider.Settings.System.putInt(getContentResolver(),
							android.provider.Settings.System.AUTO_TIME, isChecked ? 1 : 0);
				} 
			
			});
			
		} catch (SettingNotFoundException e) {
			e.printStackTrace();
		}

    }
}