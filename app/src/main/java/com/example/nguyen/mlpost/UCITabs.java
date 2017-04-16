package com.example.nguyen.mlpost;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Nguyen on 4/15/2017.
 */

public class UCITabs extends FragmentStatePagerAdapter{

    private int tabCount;

    public UCITabs(FragmentManager fm,int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                UCIExplainFrag frag1 = new UCIExplainFrag();
                return frag1;
            case 1:
                UCIInterface frag2 = new UCIInterface();
                return frag2;
            default:
                return null;
        }
    }

    public int getCount(){
        return tabCount;
    }


}
