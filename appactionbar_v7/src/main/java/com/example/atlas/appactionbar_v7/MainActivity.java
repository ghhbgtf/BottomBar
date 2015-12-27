package com.example.atlas.appactionbar_v7;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ShareActionProvider;


public class MainActivity extends Activity implements ActionBar.TabListener {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        MenuItem shareItem = menu.findItem(R.id.menu_item_share);
        ShareActionProvider actionProvider = (ShareActionProvider) shareItem.getActionProvider();
        actionProvider.setShareIntent(getShareIntent());

        return super.onCreateOptionsMenu(menu);
    }

    private Intent getShareIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        return intent;
    }

    private void editActionBar() {
        actionBar = getActionBar();
        actionBar.setTitle("this is a v7 supported actionbar");

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab = actionBar
                .newTab()
                .setText("tab1")
                .setTabListener(this);
        ActionBar.Tab tab1 = actionBar
                .newTab()
                .setText("tab1")
                .setTabListener(this);
        ActionBar.Tab tab2 = actionBar
                .newTab()
                .setText("tab1")
//                .setTabListener(this);
                .setTabListener(new MyTabLiatener<MyFragment>(this, "taber1", MyFragment.class));
        actionBar.addTab(tab);
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
