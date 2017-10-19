package com.app.logintest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MySqliteHelper helper;
    String name;
    String mypwd;

    private EditText user;
    private EditText pwd;

    int userflag;
    int loginflag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        user = (EditText) findViewById(R.id.editText1);
        pwd = (EditText) findViewById(R.id.editText2);
    }

    public void insert(){
        helper = new MySqliteHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        String aql1 = "select * from users";
        Cursor cursor = db.rawQuery(aql1,null);
        while (cursor.moveToNext()){
            name = cursor.getString(1);
            mypwd = cursor.getString(2);

            if((user.getText().toString().isEmpty())||(pwd.getText().toString().isEmpty())) {
                Toast.makeText(MainActivity.this, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                break;
            }
            userflag = 1;
            if((user.getText().toString().equals(name))) {
                Toast.makeText(MainActivity.this, "此用户已存在", Toast.LENGTH_SHORT).show();
                userflag = 0;
                break;
            }
        }
        if(userflag == 1) {
            String sql2 = "insert into users(name,pwd) values ('"+user.getText().toString()+"','"+pwd.getText().toString()+"')";
            db.execSQL(sql2);
            Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
        }
    }
    public void select(){
        helper = new MySqliteHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select * from users";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            name = cursor.getString(1);
            mypwd = cursor.getString(2);

            if((user.getText().toString().equals(name)) && (pwd.getText().toString().equals(mypwd))) {
                Toast.makeText(MainActivity.this, "用户验证成功", Toast.LENGTH_SHORT).show();
                loginflag = 1;

                Intent MainActivity = new Intent();
                MainActivity.setClass(this,SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("user",user.getText().toString());
                MainActivity.putExtras(bundle);
                this.startActivity(MainActivity);
                finish();
            }
        }
        if((user.getText().toString().isEmpty())||(pwd.getText().toString().isEmpty())) {
            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
        }
        if(loginflag!=1) {
            Toast.makeText(MainActivity.this, "账号或密码输入错误", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
        db.close();
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                select();

                break;
            case R.id.button2:
                insert();
                break;
        }
    }
}
