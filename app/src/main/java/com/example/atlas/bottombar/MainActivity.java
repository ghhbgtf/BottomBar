package com.example.atlas.bottombar;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup bottomBar;
    private MyFragment myFragment;
    private android.support.v7.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        showFragment(R.id.bottom_bar_1);
        editActionBar();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.bottom_bar_1:
                Toast.makeText(MainActivity.this, "this is the first bottom botton", Toast.LENGTH_SHORT).show();
                showFragment(R.id.bottom_bar_1);
                break;
            case R.id.bottom_bar_2:
                Toast.makeText(MainActivity.this, "this is the second bottom botton", Toast.LENGTH_SHORT).show();
                showFragment(R.id.bottom_bar_2);
                break;
            case R.id.bottom_bar_3:
                Toast.makeText(MainActivity.this, "this is the third bottom botton", Toast.LENGTH_SHORT).show();
                showFragment(R.id.bottom_bar_3);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu);

        final MenuItem searchItem = menu.findItem(R.id.menu_item_search);
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainActivity.this, "expanded", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(MainActivity.this, "collapse", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private Intent getMyIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(MainActivity.this, "goto home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_1:
                Toast.makeText(MainActivity.this, "menu item 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_share:
                startActivity(getMyIntent());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Toast.makeText(MainActivity.this, "menu opened", Toast.LENGTH_SHORT).show();
        return super.onMenuOpened(featureId, menu);
    }

    public void initView() {
        bottomBar = (RadioGroup) findViewById(R.id.bottom_bar);
        bottomBar.setOnCheckedChangeListener(this);
    }

    private void showFragment(int id) {
        myFragment = new MyFragment(id);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_show, myFragment)
                .commit();
    }

    public void editActionBar() {
        //主题使用的是 theme.appcompat,所以要使用 getSupportActionBar
        actionBar = getSupportActionBar();
        //设置主标题
        actionBar.setTitle("something");
        //设置子标题
        actionBar.setSubtitle("anything");
        //设置 icon
        actionBar.setIcon(R.drawable.ic_launcher_true);
        //以下两项同时设置,以显示 icon
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        //启用actionBar 图标的导航功能(其系统 id android.R.id.home)
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
}
