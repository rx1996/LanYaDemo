package com.kjplusapp.fragment.measuremen;

import android.view.View;

import com.kjplusapp.R;
import com.kjplusapp.common.BaseFragment;

/**
 * Created by Administrator on 2017/10/16.
 */

public class BloodPressureFragment extends BaseFragment {
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_blood_pressure,null);
        return view;
    }
}
