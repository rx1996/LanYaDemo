package com.kjplusapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.kjplusapp.R;
import com.kjplusapp.common.BaseFragment;
import com.kjplusapp.fragment.information.CenliangFragment;
import com.kjplusapp.fragment.information.JiankangFragment;
import com.kjplusapp.fragment.information.QianyueFragment;
import com.kjplusapp.fragment.information.SuifangFragment;
import com.kjplusapp.fragment.information.TijianFragment;
import com.kjplusapp.fragment.information.TuisongFragment;
import com.kjplusapp.fragment.information.ZhenliaoFragment;
import com.kjplusapp.fragment.information.ZhuanzhenFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InformationActivity extends AppCompatActivity {

    @Bind(R.id.tv_title_content)
    TextView tvTitleContent;
    @Bind(R.id.iv_photo)
    ImageView ivPhoto;
    @Bind(R.id.ll_information)
    LinearLayout llInformation;
    @Bind(R.id.tv_qiehuan)
    TextView tvQiehuan;
    @Bind(R.id.tv_xinjian)
    TextView tvXinjian;
    @Bind(R.id.rb_tijian)
    RadioButton rbTijian;
    @Bind(R.id.rb_suifang)
    RadioButton rbSuifang;
    @Bind(R.id.rb_zhenliao)
    RadioButton rbZhenliao;
    @Bind(R.id.rb_zhuanzhen)
    RadioButton rbZhuanzhen;
    @Bind(R.id.rb_jiankang)
    RadioButton rbJiankang;
    @Bind(R.id.rb_celiang)
    RadioButton rbCeliang;
    @Bind(R.id.rb_qianyue)
    RadioButton rbQianyue;
    @Bind(R.id.rb_tuisong)
    RadioButton rbTuisong;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;
    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
    @Bind(R.id.activity_information)
    LinearLayout activityInformation;
    @Bind(R.id.iv_back)
    ImageView ivBack;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ButterKnife.bind(this);
        //初始多个页面对应的Fragment并且设置默认的Fragment页面
        initFragment();

        //设置RadioGroup的选中监听
        rgMain.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选择首页
        rgMain.check(R.id.rb_tijian);

    }

    @OnClick({R.id.iv_back, R.id.ll_information})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_information:
//                Intent intent = new Intent(InformationActivity.this, Information2Activity.class);
//                startActivity(intent);
                break;
        }
    }


    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_tijian:
                    position = 0;
                    break;
                case R.id.rb_suifang:
                    position = 1;
                    break;
                case R.id.rb_zhenliao:
                    position = 2;
                    break;
                case R.id.rb_zhuanzhen:
                    position = 3;
                    break;
                case R.id.rb_jiankang:
                    position = 4;
                    break;
                case R.id.rb_celiang:
                    position = 5;
                    break;
                case R.id.rb_qianyue:
                    position = 6;
                    break;
                case R.id.rb_tuisong:
                    position = 7;
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
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

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
        fragments.add(new TijianFragment());
        fragments.add(new SuifangFragment());
        fragments.add(new ZhenliaoFragment());
        fragments.add(new ZhuanzhenFragment());
        fragments.add(new JiankangFragment());
        fragments.add(new CenliangFragment());
        fragments.add(new QianyueFragment());
        fragments.add(new TuisongFragment());
    }
}
