package com.kjplusapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kjplusapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhenliaoServiceActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title_content)
    TextView tvTitleContent;
    @Bind(R.id.tv_save)
    TextView tvSave;
    @Bind(R.id.iv_photo)
    ImageView ivPhoto;
    @Bind(R.id.ll_information)
    LinearLayout llInformation;
    @Bind(R.id.tv_qiehuan)
    TextView tvQiehuan;
    @Bind(R.id.tv_xinjian)
    TextView tvXinjian;
    @Bind(R.id.activity_zhenliao_service)
    LinearLayout activityZhenliaoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhenliao_service);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_save:
                break;
        }
    }
}
