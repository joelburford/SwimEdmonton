package Objects;

import java.util.ArrayList;
import java.util.Collection;

public class Facility {

	private double coord_longitude;
	private double coord_latitude;
	//address?
	private double price_min;
	private double price_max;
	private ArrayList<Feature> features;
	
	public double getLongitude() {
		return coord_longitude;
	}
	
	public double getCoord_latitude() {
		return coord_latitude;
	}

	public double getPrice_min() {
		return price_min;
	}

	public double getPrice_max() {
		return price_max;
	}

	public ArrayList<Feature> getFeatures() {
		return features;
	}


}
