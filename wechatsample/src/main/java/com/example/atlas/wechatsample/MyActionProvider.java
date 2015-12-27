package com.example.atlas.wechatsample;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Atlas on 15/12/18.
 */
public class MyActionProvider extends ActionProvider implements MenuItem.OnMenuItemClickListener{

    private Context context;

    /**
     * Creates a new instance. ActionProvider classes should always implement a
     * constructor that takes a single Context parameter for inflating from menu XML.
     *
     * @param context Context for accessing resources.
     */
    public MyActionProvider(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View onCreateActionView() {
        return null;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        super.onPrepareSubMenu(subMenu);
        subMenu.clear();
        subMenu.add("发起群聊")
                .setIcon( R.drawable.ofm_group_chat_icon)
                .setOnMenuItemClickListener(this);
        subMenu.add("添加朋友")
                .setIcon(R.drawable.ofm_add_icon)
                .setOnMenuItemClickListener(this);
        subMenu.add("视频聊天")
                .setIcon(R.drawable.ofm_video_icon)
                .setOnMenuItemClickListener(this);
        subMenu.add("扫一扫")
                .setIcon(R.drawable.ofm_qrcode_icon)
                .setOnMenuItemClickListener(this);
        subMenu.add("拍照分享")
                .setIcon(R.drawable.ofm_camera_icon)
                .setOnMenuItemClickListener(this);
    }

    @Override
    public boolean hasSubMenu() {
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
