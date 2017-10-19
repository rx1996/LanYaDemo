package com.kjplusapp.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iknet.iknetbluetoothlibrary.BluetoothManager;
import com.iknet.iknetbluetoothlibrary.BluetoothManager.OnBTMeasureListener;
import com.iknet.iknetbluetoothlibrary.MeasurementResult;
import com.iknet.iknetbluetoothlibrary.util.PermissionUtil;
import com.kjplusapp.R;

import java.util.List;

/**
 * 蓝牙连接与测量
 * @author Administrator
 *
 */
public class BluetoothConnActivity extends Activity implements OnClickListener {
//	private static final String TAG = "BluetoothConnActivity";
	
	private View imgAnim;
	private BluetoothAdapter _bluetooth = BluetoothAdapter.getDefaultAdapter();
	private TextView tv_connect_state, tv_turgoscope_power, tv_heart;
	private Button btn_stop_measure;
	private Animation operatingAnim;
	private BluetoothManager bluetoothManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bluetooth);
		initView();
		initData();
		setBluetooth();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		bluetoothManager.stopBTAffair();
//		stopService(new Intent(getApplicationContext(), BluetoothService.class));
	}
	
	public void initView() {
		imgAnim = findViewById(R.id.imgAnim);
		tv_connect_state = (TextView) findViewById(R.id.tv_connect_state);
		tv_turgoscope_power = (TextView) findViewById(R.id.tv_turgoscope_power);
		tv_heart = (TextView) findViewById(R.id.tv_heart);
		btn_stop_measure = (Button) findViewById(R.id.btn_stop_measure);
		
		btn_stop_measure.setOnClickListener(this);
	}
	
	private void initData() {
		bluetoothManager = BluetoothManager.getInstance(this);
		bluetoothManager.initSDK();
	}
	
	/**
	 * 设置蓝牙信息 ：如果蓝牙可用，则打开蓝牙； 如果蓝牙不可用，则进行提示
	 */
	private void setBluetooth() {
		
		if (_bluetooth == null) {
			Toast.makeText(this,"本机没有找到蓝牙硬件或驱动！",Toast.LENGTH_LONG).show();
			finish();
			return;
		}

		if (!_bluetooth.isEnabled()) {
			//提醒用户打开蓝牙
			Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBtIntent, 1);
		}else{
			startAnim();
			//蓝牙已经打开，开始搜索、连接和测量
			bluetoothManager.startBTAffair(onBTMeasureListener);
		}

	}
	
	/**
	 * sdk会自动申请权限，如果失败则手动申请
	 */
	@SuppressLint("NewApi")
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		switch (requestCode) {
		case BluetoothManager.REQUEST_FINE_LOCATION:
			//23以上版本蓝牙扫描需要定位权限(android.permission.ACCESS_COARSE_LOCATION)，此处判断是否获取成功
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				// 获取权限成功
				bluetoothManager.searchBluetooth();
			} else {
				// 获取权限失败
				Toast.makeText(BluetoothConnActivity.this, "权限获取失败", 0).show();
				setPermissionApplyDialog();
			}
			break;

		}
	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent intent) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, intent);
		if(arg0 == 1){
			if(arg1 == Activity.RESULT_OK){
				startAnim();
				//蓝牙打开成功，开始搜索、连接和测量
				bluetoothManager.startBTAffair(onBTMeasureListener);
			}else{
				//蓝牙不能正常打开
				finish();
			}
		}else if(arg0 == REQUEST_CODE_PERMISSION_SETTING){
			if(PermissionUtil.checkLocationPermission(this)){
				bluetoothManager.searchBluetooth();
			}else{ 
				Toast.makeText(BluetoothConnActivity.this, "权限获取失败", 0).show();
				finish();
			}
		}
	}
	
	/**
	 * 权限申请
	 */
	private void setPermissionApplyDialog() {
		try {
			new AlertDialog.Builder(this)
			.setTitle("提示")
			.setMessage("蓝牙扫描需要定位权限。\n请点击“设置”-“权限管理”-“定位”打开所需权限。")
			.setCancelable(false)
			.setNegativeButton("拒绝", 
					new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						BluetoothConnActivity.this.finish();
					}
				})
			.setPositiveButton("设置",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							startAppSettings();
						}
					}).show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static final int REQUEST_CODE_PERMISSION_SETTING = 102;
	/**
	 *  启动应用的设置
	 */
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, REQUEST_CODE_PERMISSION_SETTING);
    }
	
	private OnBTMeasureListener onBTMeasureListener = new OnBTMeasureListener() {
		
		@Override
		public void onRunning(String running) {
			//测量过程中的压力值
			tv_heart.setText(running);
		}
		
		@Override
		public void onPower(String power) {
			//测量前获取的电量值
			setPower(power);
		}
		
		@Override
		public void onMeasureResult(MeasurementResult result) {
			//测量结果
			String systolic = String.valueOf(result.getCheckShrink());
			String diastole = String.valueOf(result.getCheckDiastole());
			String heart = String.valueOf(result.getCheckHeartRate());
			Intent intent = new Intent(BluetoothConnActivity.this, XueyaActivity.class);
			intent.putExtra("systolic", systolic);
			intent.putExtra("diastole", diastole);
			intent.putExtra("heart", heart);
			startActivity(intent);
			finish();
//			Toast.makeText(BluetoothConnActivity.this, "result=="+result, Toast.LENGTH_SHORT).show();
		}
		
		@Override
		public void onMeasureError() {
			//测量错误
			Toast.makeText(BluetoothConnActivity.this,
					"测量失败", Toast.LENGTH_SHORT).show();
			btn_stop_measure.setText(getResources().getString(R.string.re_test));
			stopAnim();
		}
		
		@Override
		public void onFoundFinish(List<BluetoothDevice> deviceList) {
			//搜索结束，deviceList.size()如果为0，则没有搜索到设备
			if(deviceList.size() == 0){
				Toast.makeText(BluetoothConnActivity.this, "未搜索到设备", Toast.LENGTH_SHORT).show();
				finish();
			}
		}
		
		@Override
		public void onDisconnected(BluetoothDevice device) {
			//断开连接
			stopAnim();
			tv_heart.setText("0");
			tv_connect_state.setText(getResources().getString(R.string.not_connect_bluetooth));
			tv_turgoscope_power.setText("0");
			btn_stop_measure.setEnabled(true);
			btn_stop_measure.setText(getResources().getString(R.string.re_test));
		}
		
		@Override
		public void onConnected(boolean isConnected, BluetoothDevice device) {
			//是否连接成功
			if(isConnected){
				Toast.makeText(BluetoothConnActivity.this,
						device.getName() + getResources().getString(R.string.was_connected), Toast.LENGTH_SHORT).show();
				btn_stop_measure.setText(getResources().getString(R.string.stop_measurement));
				btn_stop_measure.setEnabled(true);
				tv_connect_state.setText(getResources().getString(R.string.connect_bluetooth));
			}else{
				stopAnim();
				Toast.makeText(BluetoothConnActivity.this,
						getResources().getString(R.string.unable_to_connect_device) + device.getName(), Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	// 开始播放蓝牙搜索动画
	public void startAnim() {
		operatingAnim = AnimationUtils.loadAnimation(this, R.anim.tip);
		LinearInterpolator lin = new LinearInterpolator();
		operatingAnim.setInterpolator(lin);
		imgAnim.startAnimation(operatingAnim);
		if (_bluetooth.isEnabled() == false) {
			imgAnim.clearAnimation();
		}
	}

	public void stopAnim() {
		imgAnim.clearAnimation();
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_stop_measure:
			dealStopMeasureBtn();
			break;
		}
	}

	private void dealStopMeasureBtn() {
		if (btn_stop_measure.getText().toString().equals(getResources().getString(R.string.stop_measurement))) {
			tv_heart.setText("0");
			stopAnim();
			bluetoothManager.stopMeasure();
			btn_stop_measure.setText(getResources().getString(R.string.re_test));
			
		}else if(btn_stop_measure.getText().toString().equals(getResources().getString(R.string.re_test))){
			tv_heart.setText("0");
			startAnim();
			btn_stop_measure.setText(getResources().getString(R.string.stop_measurement));
			if(bluetoothManager.isConnectBT()){
				bluetoothManager.startMeasure();
			}else{
				bluetoothManager.startBTAffair(onBTMeasureListener);
			}
			
		}
	}

	private void setPower(String power) {
		if (Integer.valueOf(power) > 3600) {
			tv_turgoscope_power.setText("剩余电量：" + power);
		} else {
			stopAnim();
			tv_turgoscope_power.setText("血压计电量不足,请及时充电");
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
////			if (_bluetooth.isEnabled()) {
////				_bluetooth.disable();
////			}
			bluetoothManager.stopMeasure();
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
