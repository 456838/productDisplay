package com.salton123.productdisplay.pickup;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.salton123.productdisplay.DetailFragment;
import com.salton123.productdisplay.PhoneVedioActivity;
import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.utils.ScreenUtils;

import static com.salton123.productdisplay.R.anim.enter;
import static com.salton123.productdisplay.R.anim.exit;
import static com.salton123.productdisplay.R.id.fragment_container;
import static com.salton123.productdisplay.R.id.home_back_iv;
import static com.salton123.productdisplay.R.id.home_drawer_layout;
import static com.salton123.productdisplay.R.id.home_play_iv;
import static com.salton123.productdisplay.R.id.home_slide_right_iv;
import static com.salton123.productdisplay.R.id.home_up_iv;
import static com.salton123.productdisplay.R.id.ll_choose_parent;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.id.pickup_beauty_iv;
import static com.salton123.productdisplay.R.id.pickup_cate_iv;
import static com.salton123.productdisplay.R.id.pickup_focus_iv;
import static com.salton123.productdisplay.R.id.rl_choose_parent;
import static com.salton123.productdisplay.R.layout.activity_pickup;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:53
 * ModifyTime: 20:53
 * Description:
 */
public class PickupActivity extends BaseActivity
        implements View.OnClickListener {
    private ImageView ivBack;
    private ImageView ivBeauty;
    private ImageView ivCate;
    private ImageView ivCloseMenu;
    private ImageView ivFocus;
    private ImageView ivPlay;
    private ImageView ivSlide;
    private ImageView ivUp;
    private LinearLayout llParent;
    private DetailFragment mDetailFragment;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mFragmentContainer;
    private FragmentManager mFragmentManager;
    private RelativeLayout rlParent;

    private void initEvent() {
        this.ivSlide.setOnClickListener(this);
        this.ivUp.setOnClickListener(this);
        this.ivCloseMenu.setOnClickListener(this);
        this.ivBeauty.setOnClickListener(this);
        this.ivFocus.setOnClickListener(this);
        this.ivCate.setOnClickListener(this);
        this.llParent.setOnClickListener(this);
        this.rlParent.setOnClickListener(this);
        this.ivPlay.setOnClickListener(this);
        this.ivBack.setOnClickListener(this);
    }

    private void initView() {
        this.mFragmentContainer = ((FrameLayout) findViewById(fragment_container));
        this.ivSlide = ((ImageView) findViewById(home_slide_right_iv));
        this.ivUp = ((ImageView) findViewById(home_up_iv));
        this.mDrawerLayout = ((DrawerLayout) findViewById(home_drawer_layout));
        this.mDrawerLayout.setDrawerLockMode(1);
        this.ivCloseMenu = ((ImageView) findViewById(menu_close_iv));
        this.ivBeauty = ((ImageView) findViewById(pickup_beauty_iv));
        this.ivFocus = ((ImageView) findViewById(pickup_focus_iv));
        this.ivCate = ((ImageView) findViewById(pickup_cate_iv));
        this.llParent = ((LinearLayout) findViewById(ll_choose_parent));
        this.rlParent = ((RelativeLayout) findViewById(rl_choose_parent));
        this.ivPlay = ((ImageView) findViewById(home_play_iv));
        this.ivBack = ((ImageView) findViewById(home_back_iv));
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.llParent, "alpha", new float[]{0.0F, 1.0F});
        localObjectAnimator.setDuration(700L);
        localObjectAnimator.setRepeatCount(0);
        localObjectAnimator.start();
    }

    private void showDetailFragment() {
        if (this.mDetailFragment == null) {
            this.mDetailFragment = new DetailFragment();
        }
    this.mFragmentContainer.setVisibility(View.VISIBLE);

        FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
        localFragmentTransaction.setCustomAnimations(enter, exit);
        if (this.mDetailFragment.isAdded()) {
            localFragmentTransaction.show(this.mDetailFragment).commit();
            return;
        }
        localFragmentTransaction.add(fragment_container, this.mDetailFragment).commit();
    }

    public void hideDeatailFragment() {
        this.mFragmentManager.beginTransaction().remove(this.mDetailFragment).commit();
        this.mFragmentContainer.setVisibility(View.GONE);
    }

    public void onBackPressed() {
        if (this.mDrawerLayout.isDrawerVisible(5)) {
            this.mDrawerLayout.closeDrawer(5);
        }
        if (this.mFragmentContainer.getVisibility() == View.VISIBLE) {
            hideDeatailFragment();
            return;
        }
        super.onBackPressed();
    }

    public void onClick(View paramView) {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (paramView.getId()) {

            case home_slide_right_iv:
                this.mDrawerLayout.openDrawer(5);
                return;
            case home_up_iv:
                showDetailFragment();
                return;
            case menu_close_iv:
                this.mDrawerLayout.closeDrawer(5);
                return;
            case pickup_beauty_iv:
                startActivity(new Intent(this, BeautyActivity.class));
                return;
            case pickup_focus_iv:
                startActivity(new Intent(this, FocusActivity.class));
                return;
            case pickup_cate_iv:
                startActivity(new Intent(this, CateActivity.class));
                return;
            case ll_choose_parent:
                finish();
                return;
            case rl_choose_parent:
                finish();
                return;
            case home_play_iv:
                Intent intent = new Intent(this, PhoneVedioActivity.class);
                intent.addFlags(268435456);
                startActivity(intent);
                return;
            case home_back_iv:
                finish();
                break;
        }
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(activity_pickup);
        this.mFragmentManager = getSupportFragmentManager();
        initView();
        initEvent();
    }
}
