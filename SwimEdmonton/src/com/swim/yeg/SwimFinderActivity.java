package com.swim.yeg;

import com.swim.yeg.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import model.ParseHelper;

public class SwimFinderActivity extends Activity implements LocationListener {
	/** Called when the activity is first created. */
	private LocationManager locationManager;
	private String provider;
/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        ParseHelper pHelp = new ParseHelper();
        pHelp.setGeoPoints();

        // BELOW CODE AND COMMENTS NEED TO BE CITED OR SUBSTANTIALLY CHANGED -Joel
		// Get the location manager
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// Define the criteria how to select the location provider -> use default
		Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		Location location = locationManager.getLastKnownLocation(provider);

		// Initialize the location fields
		if (location != null) {
			double lat = location.getLatitude();
			double lng = location.getLongitude();
            //Toast hooray = Toast.makeText(this, "(" + lng + ", " + lat + ")", 5);
            //hooray.show();
		} else {
			//Toast error = Toast.makeText(this, "Provider not available", 5);
			//error.show();
		}
	}

	/* Request updates at startup */
	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(provider, 400, 1, this);
	}


	public void onLocationChanged(Location location) {
		  //Location should be queried only once when activity is entered or resumed
		int lat = (int) (location.getLatitude());
		int lng = (int) (location.getLongitude());
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	
	public void onProviderEnabled(String provider) {
		Toast.makeText(this, "Enabled new provider " + provider,
				Toast.LENGTH_SHORT).show();

	}

	public void onProviderDisabled(String provider) {
		Toast.makeText(this, "Disabled provider " + provider,
				Toast.LENGTH_SHORT).show();
	}
	
	
}