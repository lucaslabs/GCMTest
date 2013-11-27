package com.google.android.gcm.demo.app.networking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Wrapper of {@link com.android.volley.RequestQueue} to handle request life
 * cycle (added to queue, pending, cancel).
 * 
 * @author Lucas Nobile
 */
public class RequestManager {

	private static final String TAG = RequestManager.class.getSimpleName();
	private RequestQueue mRequestQueue;

	public RequestManager(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
	}

	/**
	 * Adds the specified request to the global queue, if tag is specified then
	 * it is used, otherwise default TAG is used.
	 * 
	 * @param request
	 * @param tag
	 */
	public <T> void addToRequestQueue(Request<T> request, String tag) {
		// set the default tag if tag is empty
		request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
		addToRequestQueue(request);
	}

	/**
	 * Adds the specified request to the global queue using the default TAG.
	 * 
	 * @param request
	 */
	public <T> void addToRequestQueue(Request<T> request) {
		Log.d("Adding request to queue: %s", request.getUrl());
		// set the default tag
		request.setTag(TAG);
		mRequestQueue.add(request);
	}

	/**
	 * Cancels all pending requests by the specified TAG, it is important to
	 * specify a TAG so that the pending/ongoing requests can be cancelled.
	 * 
	 * @param tag
	 */
	public void cancelPendingRequests(Object tag) {
		if (mRequestQueue != null) {
			mRequestQueue.cancelAll(tag);
		}
	}

	public RequestQueue getRequestQueue() {
		return mRequestQueue;
	}
}
