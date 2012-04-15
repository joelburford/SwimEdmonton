package model;

import com.parse.ParseGeoPoint;

import java.util.ArrayList;
import java.util.Collection;

public class Facility {

    private ParseGeoPoint geoPoint;
	private String address;
	private double price_min;
	private double price_max;
	private ArrayList<Feature> features;

    public Facility(ParseGeoPoint gPoint, String address, double price_min, double price_max) {

        this.geoPoint = gPoint;
        this.address = address;
        this.price_min = price_min;
        this.price_max = price_max;
        this.features = new ArrayList<Feature>();

    }

    public void setFeatures(ArrayList<Feature> features) {

        this.features = features;

    }

	public ParseGeoPoint getGeoPoint() {
        return geoPoint;
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