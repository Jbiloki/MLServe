package com.example.nguyen.mlpost;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;
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
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(String... params){
        String urlString = params[0];
        String resultToDisplay = "";
        InputStream in = null;
        try{
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedInputStream(urlConnection.getInputStream());

        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        try{
            resultToDisplay = IOUtils.toString(in, "UTF-8");

        }catch(IOException e){
            e.printStackTrace();
        }
        return resultToDisplay;
    }

    @Override
    protected void onPostExecute(String result){
        //Log.d("Execute", result);
    }



}
