package com.example.firebaseandroid;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class synchronize {

    UploadTask upload;
    public void setFCMKey(String deviceID, String fcmKey) {
        final String URL = "http://posapitesting.indomobil.co.id/FCM/sendFCMKey";
        upload = new UploadTask();
        // Post params to be sent to the server
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("deviceID", deviceID);
        params.put("fcmKey", fcmKey);

        JsonObjectRequest req = new JsonObjectRequest(URL, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        // add the request object to the queue to be executed
        upload.getInstance().addToRequestQueue(req);
    }
}
