package com.salton123.productdisplay;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;
import com.salton123.productdisplay.facade.FacadeActivity;
import com.salton123.productdisplay.function.EmuiActivity;
import com.salton123.productdisplay.other.base.BaseActivity;
import com.salton123.productdisplay.other.widget.MenuViewItem;
import com.salton123.productdisplay.pickup.PickupActivity;
import com.salton123.productdisplay.property.BatteryActivity;
import com.salton123.productdisplay.property.SlugActivity;
import com.salton123.productdisplay.utils.ScreenUtils;

import java.util.Timer;
import java.util.TimerTask;

import static com.salton123.productdisplay.R.id.big_battery_iv;
import static com.salton123.productdisplay.R.id.choose_show_rl;
import static com.salton123.productdisplay.R.id.home_back_iv;
import static com.salton123.productdisplay.R.id.home_facade_mv;
import static com.salton123.productdisplay.R.id.home_function_mv;
import static com.salton123.productdisplay.R.id.home_parent_rl;
import static com.salton123.productdisplay.R.id.home_phone_iv;
import static com.salton123.productdisplay.R.id.home_pickup_mv;
import static com.salton123.productdisplay.R.id.home_play_iv;
import static com.salton123.productdisplay.R.id.home_property_mv;
import static com.salton123.productdisplay.R.id.home_slide_right_iv;
import static com.salton123.productdisplay.R.id.home_up_iv;
import static com.salton123.productdisplay.R.id.menu_close_iv;
import static com.salton123.productdisplay.R.id.mv_show_ll;
import static com.salton123.productdisplay.R.id.slug_iv;

/**
 * User: newSalton@outlook.com
 * Date: 2017/9/4 20:54
 * ModifyTime: 20:54
 * Description:
 */
public class HomeActivity  extends BaseActivity
        implements View.OnClickListener
{
    private ImageView ivBack;
    private ImageView ivBigBattery;
    private ImageView ivCloseMenu;
    private ImageView ivPhone;
    private ImageView ivPlay;
    private ImageView ivSlide;
    private ImageView ivSlug;
    private ImageView ivUp;
    private LinearLayout llShowMv;
    private DetailFragment mDetailFragment;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mFragmentContainer;
    private FragmentManager mFragmentManager;
    private MenuViewItem mvFacade;
    private MenuViewItem mvFunction;
    private MenuViewItem mvPickup;
    private MenuViewItem mvProperty;
    private RelativeLayout rlParent;
    private RelativeLayout rlShoeChoose;
    private TimerTask task = new TimerTask()
    {
        public void run()
        {
            if ((System.currentTimeMillis() - ScreenUtils.getTouchTime(HomeActivity.this)) / 1000L > 15L)
            {
                Intent localIntent = new Intent(HomeActivity.this, PhoneVedioActivity.class);
                localIntent.addFlags(268435456);
                HomeActivity.this.startActivity(localIntent);
            }
        }
    };
    private Timer timer = new Timer();

    private void initEvent()
    {
        this.ivSlide.setOnClickListener(this);
        this.ivUp.setOnClickListener(this);
        this.mvFacade.setOnClickListener(this);
        this.mvPickup.setOnClickListener(this);
        this.mvFunction.setOnClickListener(this);
        this.mvProperty.setOnClickListener(this);
        this.ivCloseMenu.setOnClickListener(this);
        this.llShowMv.setOnClickListener(this);
        this.rlShoeChoose.setOnClickListener(this);
        this.ivBigBattery.setOnClickListener(this);
        this.ivSlug.setOnClickListener(this);
        this.rlParent.setOnClickListener(this);
        this.ivPlay.setOnClickListener(this);
        this.ivBack.setOnClickListener(this);
    }

    private void initView() {
        this.mFragmentContainer = ((FrameLayout) findViewById(R.id.fragment_container));
        this.ivSlide = ((ImageView) findViewById(R.id.home_slide_right_iv));
        this.ivUp = ((ImageView) findViewById(home_up_iv));
        this.mDrawerLayout = ((DrawerLayout) findViewById(R.id.home_drawer_layout));
        this.mDrawerLayout.setDrawerLockMode(1);
        this.mvFacade = ((MenuViewItem) findViewById(home_facade_mv));
        this.mvPickup = ((MenuViewItem) findViewById(home_pickup_mv));
        this.mvFunction = ((MenuViewItem) findViewById(home_function_mv));
        this.mvProperty = ((MenuViewItem) findViewById(home_property_mv));
        this.ivCloseMenu = ((ImageView) findViewById(menu_close_iv));
        this.llShowMv = ((LinearLayout) findViewById(mv_show_ll));
        this.rlShoeChoose = ((RelativeLayout) findViewById(choose_show_rl));
        this.ivBigBattery = ((ImageView) findViewById(big_battery_iv));
        this.ivSlug = ((ImageView) findViewById(slug_iv));
        this.rlParent = ((RelativeLayout) findViewById(home_parent_rl));
        this.ivPlay = ((ImageView) findViewById(home_play_iv));
        this.ivBack = ((ImageView) findViewById(home_back_iv));
        this.ivPhone = ((ImageView) findViewById(home_phone_iv));
    }

    private void showAllMv() {
        this.llShowMv.setVisibility(View.VISIBLE);
        this.rlShoeChoose.setVisibility(View.GONE);
        this.rlShoeChoose.setAlpha(0.0F);
        this.ivPhone.setVisibility(View.VISIBLE);
        this.ivBack.setVisibility(View.GONE);
    }

    private void showDetailFragment() {
        if (this.mDetailFragment == null) {
            this.mDetailFragment = new DetailFragment();
        }
        this.mFragmentContainer.setVisibility(View.VISIBLE);
        this.mFragmentManager = getSupportFragmentManager();
        FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
        localFragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit);
        if (this.mDetailFragment.isAdded()) {
            localFragmentTransaction.show(this.mDetailFragment).commit();
            return;
        }
        localFragmentTransaction.add(R.id.fragment_container, this.mDetailFragment).commit();
    }

    private void showProperty() {
        this.llShowMv.setVisibility(View.GONE);
        this.rlShoeChoose.setVisibility(View.VISIBLE);
        this.ivPhone.setVisibility(View.GONE);
        this.ivBack.setVisibility(View.VISIBLE);
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.rlShoeChoose, "alpha", new float[]{0.0F, 1.0F});
        localObjectAnimator.setDuration(700L);
        localObjectAnimator.setRepeatCount(0);
        localObjectAnimator.start();
    }

    private void startUIAnimation() {
        ViewAnimator.animate(new View[]{this.mvFacade}).translationY(new float[]{70.0F, 0.0F}).alpha(new float[]{0.0F, 1.0F}).duration(250L).thenAnimate(new View[]{this.mvPickup}).alpha(new float[]{0.0F, 1.0F}).translationY(new float[]{70.0F, 0.0F}).duration(250L).thenAnimate(new View[]{this.mvProperty}).alpha(new float[]{0.0F, 1.0F}).translationY(new float[]{70.0F, 0.0F}).duration(250L).thenAnimate(new View[]{this.mvFunction}).alpha(new float[]{0.0F, 1.0F}).translationY(new float[]{70.0F, 0.0F}).duration(250L).start().onStop(new AnimationListener.Stop() {
            public void onStop() {
                Log.e("rory", "----finish----");
            }
        });
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
        if (this.rlShoeChoose.isShown()) {
            showAllMv();
            return;
        }
        super.onBackPressed();
    }

    public void onClick(View paramView) {
        ScreenUtils.setTouchTime(this, System.currentTimeMillis());
        switch (paramView.getId())
        {

            case home_slide_right_iv:
                this.mDrawerLayout.openDrawer(5);
                return;
            case home_up_iv:
                showDetailFragment();
                return;
            case home_facade_mv:
                startActivity(new Intent(this, FacadeActivity.class));
                return;
            case home_pickup_mv:
                startActivity(new Intent(this, PickupActivity.class));
                return;
            case home_function_mv:
                startActivity(new Intent(this, EmuiActivity.class));
                return;
            case home_property_mv:
                showProperty();
                return;
            case menu_close_iv:
                this.mDrawerLayout.closeDrawer(5);

                return;
            case big_battery_iv:
                startActivity(new Intent(this, BatteryActivity.class));
                return;
            case slug_iv:
                startActivity(new Intent(this, SlugActivity.class));
                return;
            case home_parent_rl:
                showAllMv();
                return;
            case choose_show_rl:
                showAllMv();
                return;
            case home_back_iv:
                showAllMv();
                return;
            case home_play_iv:
               Intent itente = new Intent(this, PhoneVedioActivity.class);
                itente.addFlags(268435456);
                startActivity(itente);
                return;
        }

    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_home);
        initView();
        initEvent();
        startUIAnimation();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.task != null) {
            this.task.cancel();
        }
        if (this.timer != null) {
            this.timer.cancel();
        }
    }
}
