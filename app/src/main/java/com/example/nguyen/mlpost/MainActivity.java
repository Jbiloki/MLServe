package com.example.nguyen.mlpost;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView out;
    private Button request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out = (TextView)findViewById(R.id.output);
        request = (Button) findViewById(R.id.SendRequest);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String response = new WebProcess(getApplicationContext(), findViewById(android.R.id.content)).execute("http://node34.ecs.fullerton.edu/processInput.php").get();
                } catch (Exception e) {
                    out.setText("Error getting that URL");
                    e.printStackTrace();
                }
            }
        });

    }


}
