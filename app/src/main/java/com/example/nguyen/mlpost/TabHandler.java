package com.example.nguyen.mlpost;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Nguyen on 4/15/2017.
 */

public class TabHandler extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private TabLayout layout;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucitabs_layout);

        Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        layout = (TabLayout) findViewById(R.id.tabLayout);
        layout.addTab(layout.newTab().setText("Wisconsin UCI Breast Cancer Data Set"));
        layout.addTab(layout.newTab().setText("Example of Data Set"));

        pager = (ViewPager) findViewById(R.id.pager);

        UCITabs adapter = new UCITabs(getSupportFragmentManager(), layout.getTabCount());
        pager.setAdapter(adapter);
        layout.setOnTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
