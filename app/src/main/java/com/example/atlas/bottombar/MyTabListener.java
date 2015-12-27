package com.example.atlas.bottombar;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.Fragment;

/**
 * Created by Atlas on 15/12/18.
 */
public class MyTabListener<T extends Fragment> implements ActionBar.TabListener {

    private Fragment fragment;
    private Activity activity;
    private String strTag;
    private Class<T> tClass;

    public MyTabListener(Activity activity, String strTag, Class<T> tClass) {
        this.activity = activity;
        this.strTag = strTag;
        this.tClass = tClass;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }
}
