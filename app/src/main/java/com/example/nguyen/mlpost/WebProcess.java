package com.example.nguyen.mlpost;

import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Nguyen on 4/14/2017.
 */

public class WebProcess extends AsyncTask<String, String, String> {

    private Context mContext;
    private View mView;
    private String result = "No Response Received";
    private TextView out;



    public WebProcess(Context context, View v){
        mContext=context;
        mView = v;
        out = (TextView) v.findViewById(R.id.out);
    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(String... params){
        String urlString = params[0];
        String inputs = params[1];
        InputStream in = null;
        try{
            final int in1 = Character.getNumericValue(inputs.charAt(0));
            final int in2 = Character.getNumericValue(inputs.charAt(1));
            final int in3 = Character.getNumericValue(inputs.charAt(2));
            final int in4 = Character.getNumericValue(inputs.charAt(3));
            final int in5 = Character.getNumericValue(inputs.charAt(4));
            final int in6 = Character.getNumericValue(inputs.charAt(5));
            final int in7 = Character.getNumericValue(inputs.charAt(6));
            final int in8 = Character.getNumericValue(inputs.charAt(7));
            final int in9 = Character.getNumericValue(inputs.charAt(8));
            Log.d("Input sent " , in1 + in2 + in3 + in4 + in5 + in6 + in7 + in8 + in9 + "");

            Response.Listener<String> responseListener = new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {
                    try{
                        JSONObject jsonResponse = new JSONObject(response);
                        Log.d("pre", jsonResponse.toString());
                        boolean success = jsonResponse.getBoolean("success");
                        if(success){
                            String UCIResult = jsonResponse.getString("return");
                            if(UCIResult.contains("2")){
                                out.setText("The result shows cancer may not be present.");
                            }
                            else if(UCIResult.contains("4")){
                                out.setText("The result shows cancer may be present.");
                            }
                            else if(UCIResult == null){
                                out.setText("Null Returned");
                            }
                        }
                        else{
                            Snackbar snackbar = Snackbar.make(mView , "Server Error", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                }
            };
            sendDataUCI requestSend = new sendDataUCI(in1,in2,in3,in4,in5,in6,in7,in8,in9,responseListener);
            RequestQueue queue = Volley.newRequestQueue(mContext);
            Log.d("Request",requestSend.toString());
            queue.add(requestSend);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result){
        //Log.d("Execute", result);
    }



}
