package com.kjplusapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.kjplusapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.tv_title_content)
    TextView tvTitleContent;
    @Bind(R.id.tv_title_back)
    TextView tvTitleBack;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.tv_team)
    TextView tvTeam;
    @Bind(R.id.ll_name)
    LinearLayout llName;
    @Bind(R.id.iv_erweima)
    ImageView ivErweima;
    @Bind(R.id.iv_photo)
    ImageView ivPhoto;
    @Bind(R.id.ll_information)
    LinearLayout llInformation;
    @Bind(R.id.tv_saoma)
    ImageView tvSaoma;
    @Bind(R.id.tv_qiehuan)
    ImageView tvQiehuan;
    @Bind(R.id.tv_xinjian)
    ImageView tvXinjian;
    @Bind(R.id.ll_xueya_celiang)
    LinearLayout llXueyaCeliang;
    @Bind(R.id.ll_xuetang_celiang)
    LinearLayout llXuetangCeliang;
    @Bind(R.id.ll_niaoye_celiang)
    LinearLayout llNiaoyeCeliang;
    @Bind(R.id.ll_tizhi_celiang)
    LinearLayout llTizhiCeliang;
    @Bind(R.id.ll_zhenliao_fuwu)
    LinearLayout llZhenliaoFuwu;
    @Bind(R.id.ll_jiankang_tijian)
    LinearLayout llJiankangTijian;
    @Bind(R.id.ll_zhuanzhen_fuwu)
    LinearLayout llZhuanzhenFuwu;
    @Bind(R.id.ll_suifang_fangshi)
    LinearLayout llSuifangFangshi;
    @Bind(R.id.ll_juming_liebiao)
    LinearLayout llJumingLiebiao;
    @Bind(R.id.ll_jiankang_zixun)
    LinearLayout llJiankangZixun;
    @Bind(R.id.ll_yuyue_guanli)
    LinearLayout llYuyueGuanli;
    @Bind(R.id.ll_celiang_liebiao)
    LinearLayout llCeliangLiebiao;
    @Bind(R.id.ll_suifang_jilu)
    LinearLayout llSuifangJilu;
    @Bind(R.id.ll_zhenliao_jilu)
    LinearLayout llZhenliaoJilu;
    @Bind(R.id.ll_qianyue_jilu)
    LinearLayout llQianyueJilu;
    @Bind(R.id.ll_zhuanzhen_jilu)
    LinearLayout llZhuanzhenJilu;
    @Bind(R.id.ll_tijian_liebiao)
    LinearLayout llTijianLiebiao;
    @Bind(R.id.ll_gongzuo_tongji)
    LinearLayout llGongzuoTongji;
    @Bind(R.id.ll_yiliao_gongju)
    LinearLayout llYiliaoGongju;
    @Bind(R.id.scrollView)
    ScrollView scrollView;
    @Bind(R.id.iv_set)
    ImageView ivSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    //点击事件
    @OnClick({R.id.tv_title_back, R.id.ll_information, R.id.tv_saoma, R.id.tv_qiehuan, R.id.tv_xinjian, R.id.ll_xueya_celiang, R.id.ll_xuetang_celiang, R.id.ll_niaoye_celiang, R.id.ll_tizhi_celiang, R.id.ll_zhenliao_fuwu, R.id.ll_jiankang_tijian, R.id.ll_zhuanzhen_fuwu, R.id.ll_suifang_fangshi, R.id.ll_juming_liebiao, R.id.ll_jiankang_zixun, R.id.ll_yuyue_guanli, R.id.ll_celiang_liebiao, R.id.ll_suifang_jilu, R.id.ll_zhenliao_jilu, R.id.ll_qianyue_jilu, R.id.ll_zhuanzhen_jilu, R.id.ll_tijian_liebiao, R.id.ll_gongzuo_tongji, R.id.ll_yiliao_gongju})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_title_back:
                Toast.makeText(MainActivity.this, "返回", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_information:
                //跳转界面
                Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_saoma:
                break;
            case R.id.tv_qiehuan:
                break;
            case R.id.tv_xinjian:
                Intent intent1 = new Intent(MainActivity.this, HuanzheXinxiActivity.class);
                startActivity(intent1);

                break;
            case R.id.ll_xueya_celiang:
                Intent intent2 = new Intent(MainActivity.this, XueyaActivity.class);
                startActivity(intent2);
                break;
            case R.id.ll_xuetang_celiang:
                break;
            case R.id.ll_niaoye_celiang:
                break;
            case R.id.ll_tizhi_celiang:
                break;
            case R.id.ll_zhenliao_fuwu:
                Intent intent3 = new Intent(MainActivity.this,ZhenliaoServiceActivity.class);
                startActivity(intent3);
                break;
            case R.id.ll_jiankang_tijian:
                break;
            case R.id.ll_zhuanzhen_fuwu:
                break;
            case R.id.ll_suifang_fangshi:
                Intent intent4 = new Intent(MainActivity.this,VisitActivity.class);
                startActivity(intent4);
                break;
            case R.id.ll_juming_liebiao:
                break;
            case R.id.ll_jiankang_zixun:
                break;
            case R.id.ll_yuyue_guanli:
                break;
            case R.id.ll_celiang_liebiao:
                break;
            case R.id.ll_suifang_jilu:
                break;
            case R.id.ll_zhenliao_jilu:
                break;
            case R.id.ll_qianyue_jilu:
                Intent intent5 = new Intent(MainActivity.this, SignActivity.class);
                startActivity(intent5);
                break;
            case R.id.ll_zhuanzhen_jilu:
                break;
            case R.id.ll_tijian_liebiao:
                break;
            case R.id.ll_gongzuo_tongji:
                break;
            case R.id.ll_yiliao_gongju:
                break;
        }
    }
}
