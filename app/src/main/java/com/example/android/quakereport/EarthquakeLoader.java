package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;


/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */


    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.e("Loader", "Loader onStartLoading");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */

    @Override
    public List<Earthquake> loadInBackground() {
        // Don't perform the request if there are no URLs, or the first URL is null
        Log.e("Loader", "Loader loadInBackground");
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        Log.e("Loader", "QueryUtils is fetching earthquake data");
        return earthquakes;
    }
}