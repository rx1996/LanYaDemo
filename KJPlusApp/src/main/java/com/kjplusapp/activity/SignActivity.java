package com.kjplusapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.kjplusapp.R;
import com.kjplusapp.adapter.InformationAdapter;
import com.kjplusapp.bean.InformationBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class SignActivity extends AppCompatActivity {


    @Bind(R.id.listView)
    ListView listView;
    @Bind(R.id.root_layout)
    LinearLayout rootLayout;

    String url = "http://118.190.157.94/kjplus-api/srvassignjson.html";
    @Bind(R.id.iv_finish)
    ImageView ivFinish;
    private InformationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        ButterKnife.bind(this);
        initData();
//        dynamic_add();
    }

    private void initData() {
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new MyStringCallback());
    }

    @OnClick(R.id.iv_finish)
    public void onViewClicked() {
        finish();
    }


    class MyStringCallback extends StringCallback {
        @Override
        public void onError(Call call, Exception e, int id) {
            Log.e("TAG", "请求失败==" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e("TAG", "请求成功==");
            processData(response);
        }
    }

    private void processData(String json) {
        InformationBean bean = JSON.parseObject(json, InformationBean.class);
        List<InformationBean.DataBean> been1 = bean.getData();
        adapter = new InformationAdapter(this, been1);
        listView.setAdapter(adapter);
    }


//    protected void dynamic_add(){
//        LinearLayout rootLayout = (LinearLayout)findViewById(R.id.root_layout);
//
//        RelativeLayout relativerLayout = new RelativeLayout(this);
//        Button button = new Button(this);
//        TextView textView = new TextView(this);
//
//        button.setText("button");
//        textView.setText("Some text");
//
//        LinearLayout.LayoutParams relativeLayout_parent_params
//                = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//        RelativeLayout.LayoutParams button_parent_params
//                = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
//        RelativeLayout.LayoutParams text_parent_params
//                = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
//
//        button_parent_params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//        text_parent_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//
//        relativerLayout.addView(button,button_parent_params);
//        relativerLayout.addView(textView,text_parent_params);
//        rootLayout.addView(relativerLayout,relativeLayout_parent_params);
//    }
}
