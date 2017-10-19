package com.iknet.bloodmeasuredemo;

import com.iknet.iknetbluetoothlibrary.MeasurementResult;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 显示测量结果
 * @author Administrator
 *
 */
public class MeasurementResultActivity extends Activity{
	
	private TextView tv_ssy, tv_szy, tv_xl;
	
	private MeasurementResult measurementResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_measure_result);
		
		measurementResult = (MeasurementResult) getIntent().getSerializableExtra("measure_result");
		initView();
	}

	private void initView() {
		tv_ssy = (TextView) findViewById(R.id.tv_ssy);
		tv_szy = (TextView) findViewById(R.id.tv_szy);
		tv_xl = (TextView) findViewById(R.id.tv_xl);
		
		tv_ssy.setText("收缩压：" + measurementResult.getCheckShrink());
		tv_szy.setText("舒张压：" + measurementResult.getCheckDiastole());
		tv_xl.setText("心率：" + measurementResult.getCheckHeartRate());
	}
	
}
