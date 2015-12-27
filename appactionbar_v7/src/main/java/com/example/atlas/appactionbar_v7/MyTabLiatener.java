package com.example.atlas.appactionbar_v7;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;

/**
 * Created by Atlas on 15/12/18.
 */
public class MyTabLiatener<T extends Fragment> implements ActionBar.TabListener {
    private Fragment fragment;
    private Activity activity;
    private String tag;
    private Class<T> mClass;

    public MyTabLiatener(Activity activity, String tag, Class<T> mClass) {
        this.activity = activity;
        this.tag = tag;
        this.mClass = mClass;
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        if (fragment != null) {
            ft.attach(fragment);
        } else {
            fragment = Fragment.instantiate(activity, mClass.getName());
            ft.add(android.R.id.content, fragment, tag);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        if (fragment != null) {
            ft.detach(fragment);
        }

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }
}
