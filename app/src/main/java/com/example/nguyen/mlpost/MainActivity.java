package com.example.nguyen.mlpost;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity{

    private FragmentTransaction ft;


    private Button UCI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UCI = (Button) findViewById(R.id.UCIgo);
        UCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getApplicationContext(), TabHandler.class);
                startActivity(newIntent);
                /*UCIInterface newInterface = new UCIInterface();
                UCITabs newInterface = new UCITabs();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(android.R.id.content,newInterface, "UCIInterface");
                ft.addToBackStack(null);
                ft.commit();*/
            }
        });

    }




}
