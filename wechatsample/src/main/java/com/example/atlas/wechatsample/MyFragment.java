package com.example.atlas.wechatsample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Atlas on 15/12/16.
 */
@SuppressLint("ValidFragment")
public class MyFragment extends android.app.Fragment {

    private int bottom_bar_id;
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
        //通过构造函数传递过来的 int id 显示对应的 layout
        switch (bottom_bar_id) {
            case R.id.bottom_bar_1:
                root = inflater.inflate(R.layout.fragment_show_1, null);
                break;
            case R.id.bottom_bar_2:
                root = inflater.inflate(R.layout.fragment_show_2, null);
                break;
            case R.id.bottom_bar_3:
                root = inflater.inflate(R.layout.fragment_show_3, null);
                break;
            case R.id.bottom_bar_4:
                root = inflater.inflate(R.layout.fragment_show_4, null);
                break;
        }
        return root;
    }
}
