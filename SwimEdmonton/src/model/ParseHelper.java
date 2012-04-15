package model;

import android.util.Log;
import com.parse.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Derek
 * Date: 4/15/12
 * Time: 2:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class ParseHelper {

    private static String FACILITY_OBJECT_NAME = "Facility";
    private static String COL_NAME_ADDRESS = "Address";
    private static String COL_NAME_MAX_FEE = "MaxFee";
    private static String COL_NAME_MIN_FEE = "MinFee";
    private static String COL_NAME_GEOPOINT = "GeoPoint";
    private static String COL_NAME_LATITUDE = "LATITUDE";
    private static String COL_NAME_LONGITUDE = "LONGITUDE";

    //hacky way to deal with anonymous callback class
    private List<ParseObject> objects;

    public ParseHelper() {

    }

    public ArrayList<Facility> getFacilities(double latitude, double longitude) {

        ParseGeoPoint currentLocation = new ParseGeoPoint(latitude, longitude);

        ParseQuery query = new ParseQuery(FACILITY_OBJECT_NAME);
        query.whereNear("location", currentLocation);

        List<ParseObject> objects;

        query.findInBackground(new FindCallback() {
           public void done(List<ParseObject> o, ParseException e) {
                if (e == null) {

                    setObjects(o);

                } else {
                   Log.d("score", "Error: " + e.getMessage());
                }
           }});


        return parseFacilities(this.objects);

    }

    private void setObjects(List<ParseObject> o) {
        this.objects = o;
    }

    private ArrayList<Facility> parseFacilities(List<ParseObject> objects) {

        ArrayList<Facility> facilities = new ArrayList<Facility>();

        for(ParseObject o : objects) {

            ParseGeoPoint p = o.getParseGeoPoint(COL_NAME_GEOPOINT);
            String address = o.getString(COL_NAME_ADDRESS);
            double min = o.getDouble(COL_NAME_MIN_FEE);
            double max = o.getDouble(COL_NAME_MAX_FEE);

            Facility f = new Facility(p, address, min, max);

            facilities.add(f);
        }

        return facilities;

    }

    public void setGeoPoints() {

        ParseQuery query = new ParseQuery(FACILITY_OBJECT_NAME);

        List<ParseObject> objects = null;

        try {

            objects = query.find();

            for(ParseObject o : objects) {

                double lat = o.getDouble(COL_NAME_LATITUDE);
                double longitude = o.getDouble(COL_NAME_LONGITUDE);

                ParseGeoPoint p = new ParseGeoPoint(lat, longitude);

                o.put(COL_NAME_GEOPOINT, p);

                o.saveInBackground();

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
