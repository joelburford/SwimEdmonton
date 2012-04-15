package model;

import java.util.ArrayList;
import java.util.Collection;

public class Facility {

	private double longitude;
	private double latitude;
	private String address;
	private double price_min;
	private double price_max;
	private ArrayList<Feature> features;
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public double getMinPrice() {
		return price_min;
	}

	public double getMaxPrice() {
		return price_max;
	}

	public ArrayList<Feature> getFeatures() {
		return features;
	}
	
	public String getAddress() {
		return address;
	}
}