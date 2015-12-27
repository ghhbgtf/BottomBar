package com.example.atlas.wechatsample;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.RadioGroup;
import java.lang.reflect.Method;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    //界面可以分成三个部分:actionBar,fragment,RadioGroup
    private ActionBar actionBar;
    private MyFragment myFragment;
    private RadioGroup bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化组件
        initView();
        //设置 actionBar 的相关属性
        editActionBar();
        //显示初始化界面,即第一个 fragment
        showFragment(R.id.bottom_bar_1);

    }

    private void initView() {
        bottomBar = (RadioGroup) findViewById(R.id.bottom_bar);
        bottomBar.setOnCheckedChangeListener(this);
    }

    private void editActionBar() {
        //使用非限制主题,可以使用 getActionBar
        actionBar = getActionBar();
        actionBar.setTitle("微信");
        actionBar.setIcon(R.drawable.logo);
    }

    private void showFragment(int id) {
        myFragment = new MyFragment(id);//此处应该在适当时机释放资源------------------------------------
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_show, myFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //此处可以直接使用 getMenuInflater
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    //此处使用的是反射机制----没学好----
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    //设置上下文菜单显示图标
                    m.setAccessible(true);
                    //
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.bottom_bar_1:
                showFragment(R.id.bottom_bar_1);
                break;
            case R.id.bottom_bar_2:
                showFragment(R.id.bottom_bar_2);
                break;
            case R.id.bottom_bar_3:
                showFragment(R.id.bottom_bar_3);
                break;
            case R.id.bottom_bar_4:
                showFragment(R.id.bottom_bar_4);
                break;
        }
    }

}
