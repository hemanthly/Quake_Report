package com.example.quake_report;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {
    private double magnitude;
    private String location;
    private long rdate;
    private long mTimeInMilliseconds;
    /** Website URL of the earthquake */
    private String mUrl;


    public Earthquake(double mag, String loc, long date, String url)
    {
        magnitude = mag;
        location = loc;
        rdate = date;
        mUrl = url;
    }
    public double getMagnitude(){
        return magnitude;
    }

    public String getLocation(){
        return location;
    }
    public long getmTimeInMilliseconds()
    {
        return mTimeInMilliseconds;
    }
    public String getUrl() {
        return mUrl;
    }
}
