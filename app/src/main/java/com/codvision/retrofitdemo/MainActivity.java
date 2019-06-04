package com.codvision.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codvision.retrofitdemo.module.MainContract;
import com.codvision.retrofitdemo.presenter.MainPresenter;

/**
 * Created by sxy on 2019/5/8 13:48
 * todo
 */
public class MainActivity extends AppCompatActivity implements MainContract.View {
    private EditText etName;
    private EditText etPwd;
    private MainPresenter presenter;
    private Button btRegister;
    private TextView tv_content;
    private String username;
    private String userpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        etName = findViewById(R.id.et_name);
        etPwd = findViewById(R.id.et_pwd);
        btRegister = findViewById(R.id.bt_register);
        tv_content = findViewById(R.id.tv_content);
        presenter = new MainPresenter(this, this);
    }

    private void initEvent() {
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etName.getText().toString().trim();
                userpwd = etPwd.getText().toString().trim();
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(userpwd)) {
                    presenter.userRegister(username, userpwd);
                }
            }
        });
    }

    @Override
    public void setContent(String content) {

    }
}
