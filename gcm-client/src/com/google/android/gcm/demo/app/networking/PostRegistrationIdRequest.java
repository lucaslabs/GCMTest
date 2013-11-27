package com.google.android.gcm.demo.app.networking;

import java.util.HashMap;
import java.util.Map;

import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gcm.demo.app.GCMTestApp;

/**
 * Request to send the device registration ID to the server.
 * 
 * @author Lucas Nobile
 */
public class PostRegistrationIdRequest {

    private String prepareUrl() {
        Uri.Builder builder = Uri.parse("http://10.0.0.5:3000/register").buildUpon();
        return builder.build().toString();
    }

    public void performRequest(final String registrationId, Listener<String> listener, ErrorListener errorListener) {

        StringRequest request = new StringRequest(Request.Method.POST, prepareUrl(), listener, errorListener) {

            // POST parameters
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("regId", registrationId);

                return params;
            }
        };

        GCMTestApp.REQUEST_MANAGER.addToRequestQueue(request);
    }
}