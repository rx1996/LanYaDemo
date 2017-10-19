package com.kjplusapp.activity;

import android.content.Intent;
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

public class VisitActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
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
    @Bind(R.id.ll_followUp1)
    LinearLayout llFollowUp1;
    @Bind(R.id.ll_followUp2)
    LinearLayout llFollowUp2;
    @Bind(R.id.ll_followUp3)
    LinearLayout llFollowUp3;
    @Bind(R.id.ll_followUp4)
    LinearLayout llFollowUp4;
    @Bind(R.id.activity_visit)
    LinearLayout activityVisit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.ll_followUp1, R.id.ll_followUp2, R.id.ll_followUp3, R.id.ll_followUp4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_followUp1:
                Intent intent = new Intent(this,DiabetesActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_followUp2:
                break;
            case R.id.ll_followUp3:
                break;
            case R.id.ll_followUp4:
                break;
        }
    }
}
