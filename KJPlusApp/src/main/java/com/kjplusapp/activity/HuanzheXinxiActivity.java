package com.kjplusapp.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.kjplusapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HuanzheXinxiActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.ll_sex)
    LinearLayout llSex;
    RadioGroup rbDanxuan;
    @Bind(R.id.activity_huanzhen_xinxi)
    LinearLayout activityHuanzhenXinxi;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.tv_bingshi)
    TextView tvBingshi;
    @Bind(R.id.ll_bingshi)
    LinearLayout llBingshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huanzhe_xinxi);
        ButterKnife.bind(this);
        llSex.setOnClickListener(this);
        llBingshi.setOnClickListener(this);

        //创建一个线性布局
        LinearLayout mLayout;
        mLayout = (LinearLayout) findViewById(R.id.ll_main);
        //现在我要往mLayout里边添加一个TextView
        //你可能会想直接在布局文件里边配置不就行了 那是 但是这里为了说明问题我们用代码实现
        TextView textView = new TextView(this);
        textView.setText("Text View" );
        //这里请不要困惑，这里是设置 这个textView的布局 FILL_PARENT WRAP_CONTENT 和在xml文件里边设置是一样的如
        //在xml里边怎么配置高宽大家都会的。
        //第一个参数为宽的设置，第二个参数为高的设置。
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1);
        //调用addView()方法增加一个TextView到线性布局中
        mLayout.addView(textView,p);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_sex:
                dialogNormal();
                break;
            case R.id.ll_bingshi:
                dialogList();
                break;
            default:
                break;
        }
    }
    //设置dialog
    private void dialogList() {
        final String items[] = {"高血压", "糖尿病", "冠心病", "慢阻肺","残疾人"};
         final boolean[] mulchoice = new boolean[items.length];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(items, mulchoice,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {

//                        Toast.makeText(HuanzheXinxiActivity.this,
//                                items[which] + isChecked, Toast.LENGTH_SHORT)
//                                .show();
                        mulchoice[which] = isChecked;
                    }
                });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
//                Toast.makeText(HuanzheXinxiActivity.this, "确定", Toast.LENGTH_SHORT)
//                        .show();
                String s = "";
                for(int i=0;i<items.length;i++){
                    if(mulchoice[i]){
                        s = s + items[i] + ",";
                    }
                }
                tvBingshi.setText(s.substring(0, s.length()-1));
            }
        });
        builder.create().show();
    }

    private void dialogNormal() {
        final String[] colors = {"男", "女", "未说明"};
        new AlertDialog.Builder(this).setTitle("指定背景颜色")
                .setSingleChoiceItems(colors, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
//                        Toast.makeText(HuanzheXinxiActivity.this, colors[which], Toast.LENGTH_SHORT).show();
                        tvSex.setText(colors[which]);
                    }
                }).show();
    }
}


