package com.app.logintest2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username ;
    private EditText password ;

    private String UN;
    private String PWD;

    String name;
    String pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        username  = (EditText) findViewById(R.id.editText1);
        password  = (EditText) findViewById(R.id.editText2);

        SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
        UN = sp.getString("username", "");
        PWD = sp.getString("password", "");
        name = username .getText().toString();
        pwd = password .getText().toString();
    }
    public void select(){
        if(name != null && name.length()>0||pwd!=null&&pwd.length()>0) {
            if(name.equals(UN)&&pwd.equals(PWD)) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        }
    }
    public void insert(){
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("name", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();
        finish();
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
