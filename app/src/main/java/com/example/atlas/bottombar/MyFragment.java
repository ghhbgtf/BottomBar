package com.example.atlas.bottombar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Atlas on 15/12/16.
 */
@SuppressLint("ValidFragment")
public class MyFragment extends android.support.v4.app.Fragment {

    private int bottom_bar_id ;
    private View root;


    public MyFragment(int id) {
        System.out.println(id);
        bottom_bar_id = id;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_show, null);
        TextView textView = (TextView) root.findViewById(R.id.tv_show_message);
        textView.setText("" + bottom_bar_id);
        return root;
    }
}
