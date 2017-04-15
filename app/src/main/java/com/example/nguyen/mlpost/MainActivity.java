package com.example.nguyen.mlpost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out = (TextView)findViewById(R.id.output);
        try{
        String response = new WebProcess().execute("http://node34.ecs.fullerton.edu/test.php").get();
            out.setText(response);
        }catch(Exception e){
            out.setText("Error getting that URL");
            e.printStackTrace();
        }


    }
}
