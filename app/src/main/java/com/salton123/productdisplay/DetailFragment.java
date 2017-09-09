package com.salton123.productdisplay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.salton123.productdisplay.pickup.PickupActivity;
import com.salton123.productdisplay.utils.ScreenUtils;

/**
 * Created by Administrator on 2017/9/4.
 */

public class DetailFragment extends Fragment implements View.OnTouchListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View paramLayoutInflater = inflater.inflate(R.layout.fragment_detail_layout, container, false);
        ImageView home_detail_iv = (ImageView)paramLayoutInflater.findViewById(R.id.home_detail_iv);
        paramLayoutInflater.findViewById(R.id.close).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                ScreenUtils.setTouchTime(DetailFragment.this.getActivity(), System.currentTimeMillis());
                if ((DetailFragment.this.getActivity() instanceof HomeActivity)) {
                    ((HomeActivity)DetailFragment.this.getActivity()).hideDeatailFragment();
                }

                if ((DetailFragment.this.getActivity() instanceof PickupActivity)){
                    ((PickupActivity)DetailFragment.this.getActivity()).hideDeatailFragment();
                }
            }
        });
        paramLayoutInflater.setOnTouchListener(this);
        return paramLayoutInflater;
    }

    @Override
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
        ScreenUtils.setTouchTime(getActivity(), System.currentTimeMillis());
        return true;
    }
}
