package com.kjplusapp.fragment.information;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kjplusapp.R;
import com.kjplusapp.activity.InformationActivity;
import com.kjplusapp.common.BaseFragment;
import com.kjplusapp.fragment.measuremen.BloodPressureFragment;
import com.kjplusapp.fragment.measuremen.BloodSugarFragment;
import com.kjplusapp.fragment.measuremen.UrineMeasuremenFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/10.
 */

public class CenliangFragment extends BaseFragment {
    @Bind(R.id.rb_blood_pressure)
    RadioButton rbBloodPressure;
    @Bind(R.id.rb_blood_sugar)
    RadioButton rbBloodSugar;
    @Bind(R.id.rb_urine_measuremen)
    RadioButton rbUrineMeasuremen;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;
    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
    /**
     * Fragment的集合
     */
    private ArrayList<BaseFragment> fragments;
    /**
     * 选择某个Fragment的位置
     */
    private int position = 0;
    /**
     * 之前显示过的Fragment
     */
    private Fragment tempFragment;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_celiang, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        //初始多个页面对应的Fragment并且设置默认的Fragment页面
        initFragment();

        //设置RadioGroup的选中监听
        rgMain.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选择首页
        rgMain.check(R.id.rb_blood_pressure);
    }
    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_blood_pressure:
                    position = 0;
                    break;
                case R.id.rb_blood_sugar:
                    position = 1;
                    break;
                case R.id.rb_urine_measuremen:
                    position = 2;
                    break;
            }
            Fragment currentFragment = fragments.get(position);
            switchFragment(currentFragment);
        }
    }
    /**
     * 要显示的Fragment
     *
     * @param currentFragment
     */
    private void switchFragment(Fragment currentFragment) {
        if (currentFragment != tempFragment) {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();

            if (!currentFragment.isAdded()) {

                //把之前的隐藏
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                //把现在的添加
                ft.add(R.id.frameLayout, currentFragment);

            } else {
                //把之前的隐藏
                if (tempFragment != null) {
                    ft.hide(tempFragment);
                }
                //把当前的显示
                ft.show(currentFragment);
            }
            //提交
            ft.commit();

            tempFragment = currentFragment;
        }
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new BloodPressureFragment());
        fragments.add(new BloodSugarFragment());
        fragments.add(new UrineMeasuremenFragment());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
