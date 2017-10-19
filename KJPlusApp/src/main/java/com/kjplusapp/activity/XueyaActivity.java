package com.kjplusapp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iknet.iknetbluetoothlibrary.MeasurementResult;
import com.kjplusapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XueyaActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etSystolic;
    EditText etDiastole;
    EditText etHeartRate;
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
    @Bind(R.id.tv_systolic)
    TextView tvSystolic;
    @Bind(R.id.tv_diastole)
    TextView tvDiastole;
    @Bind(R.id.tv_heart_rate)
    TextView tvHeartRate;
    @Bind(R.id.btn_celiang)
    Button btnCeliang;
    @Bind(R.id.btn_luru)
    Button btnLuru;
    @Bind(R.id.activity_xueya)
    LinearLayout activityXueya;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xueya);
        ButterKnife.bind(this);
        btnCeliang.setOnClickListener(this);
        tvSystolic.setText(getIntent().getStringExtra("systolic"));
        Log.e("TAG", "tvSystolic=="+tvSystolic);
        tvDiastole.setText(getIntent().getStringExtra("diastole"));
        Log.e("TAG", "tvDiastole=="+tvDiastole);
        tvHeartRate.setText(getIntent().getStringExtra("heart"));
        Log.e("TAG", "tvHeartRate=="+tvHeartRate);
    }

    @OnClick({R.id.btn_luru, R.id.iv_back,R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_luru:
                View view1 = getLayoutInflater().inflate(R.layout.dialog_xueya, null);
                //初始化
                etSystolic = (EditText) view1.findViewById(R.id.et_systolic);
                etDiastole = (EditText) view1.findViewById(R.id.et_diastole);
                etHeartRate = (EditText) view1.findViewById(R.id.et_heart_rate);


                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(view1);//dialog中显示布局
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //从dialog中获取文本信息
                        String systolic = etSystolic.getText().toString();
                        Log.e("TAG", "systolic==" + systolic);
                        String diastole = etDiastole.getText().toString();
                        Log.e("TAG", "diastole==" + diastole);
                        String rate = etHeartRate.getText().toString();
                        Log.e("TAG", "rate==" + rate);

                        tvSystolic.setText(systolic);
                        tvDiastole.setText(diastole);
                        tvHeartRate.setText(rate);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_save:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(XueyaActivity.this, BluetoothConnActivity.class);
        startActivity(intent);
    }
}
