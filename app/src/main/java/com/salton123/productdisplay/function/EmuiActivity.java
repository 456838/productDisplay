package com.salton123.productdisplay.function;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;

import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.utils.ScreenUtils;

import static com.salton123.productdisplay.R.id.clone_mode_iv;
import static com.salton123.productdisplay.R.id.emui_go_back_iv;
import static com.salton123.productdisplay.R.id.emui_slide_iv;
import static com.salton123.productdisplay.R.id.eye_mode_iv;
import static com.salton123.productdisplay.R.id.home_drawer_layout;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.id.pay_mode_iv;
import static com.salton123.productdisplay.R.id.screenshot_mode_iv;
import static com.salton123.productdisplay.R.id.student_mode_iv;
import static com.salton123.productdisplay.R.layout.activity_emui;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:54
 * ModifyTime: 20:54
 * Description:
 */

@Deprecated
public class EmuiActivity extends BaseActivity
        implements View.OnClickListener {
    private ImageView ivBack;
    private ImageView ivClone;
    private ImageView ivCloseMenu;
    private ImageView ivEye;
    private ImageView ivPay;
    private ImageView ivScreenShot;
    private ImageView ivSlide;
    private ImageView ivStudent;
    private DrawerLayout mDrawerLayout;

    private void initEvent() {
        this.ivSlide.setOnClickListener(this);
        this.ivBack.setOnClickListener(this);
        this.ivCloseMenu.setOnClickListener(this);
        this.ivStudent.setOnClickListener(this);
        this.ivPay.setOnClickListener(this);
        this.ivEye.setOnClickListener(this);
        this.ivClone.setOnClickListener(this);
        this.ivScreenShot.setOnClickListener(this);
    }

    private void initView() {
        this.mDrawerLayout = ((DrawerLayout) findViewById(home_drawer_layout));
        this.mDrawerLayout.setDrawerLockMode(1);
        this.ivBack = ((ImageView) findViewById(emui_go_back_iv));
        this.ivSlide = ((ImageView) findViewById(emui_slide_iv));
        this.ivCloseMenu = ((ImageView) findViewById(menu_close_iv));
        this.ivStudent = ((ImageView) findViewById(student_mode_iv));
        this.ivPay = ((ImageView) findViewById(pay_mode_iv));
        this.ivEye = ((ImageView) findViewById(eye_mode_iv));
        this.ivClone = ((ImageView) findViewById(clone_mode_iv));
        this.ivScreenShot = ((ImageView) findViewById(screenshot_mode_iv));
    }

    public void onClick(View paramView) {
        Intent intent = new Intent(this, EmuiVedioActivity.class);
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (paramView.getId()) {
            case emui_slide_iv:
                this.mDrawerLayout.openDrawer(5);
                return;
            case menu_close_iv:
                this.mDrawerLayout.closeDrawer(5);
                return;
            case emui_go_back_iv:
                finish();
                return;
            case student_mode_iv:
                intent.putExtra("mode", 1);
                startActivity(intent);
                return;
            case pay_mode_iv:
                intent.putExtra("mode", 2);
                startActivity(intent);
                return;
            case eye_mode_iv:
                intent.putExtra("mode", 3);
                startActivity(intent);
                return;
            case clone_mode_iv:
                intent.putExtra("mode", 4);
                startActivity(intent);
                return;
            case screenshot_mode_iv:
                intent.putExtra("mode", 5);
                startActivity(intent);
                return ;
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(activity_emui);
        initView();
        initEvent();
    }
}