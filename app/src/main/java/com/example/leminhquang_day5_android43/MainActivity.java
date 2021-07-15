package com.example.leminhquang_day5_android43;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.leminhquang_day5_android43.databinding.ActivityMainBinding;

import Presenter.LoginPresenter;
import models.iLogin;

public class MainActivity extends AppCompatActivity implements iLogin {

    ActivityMainBinding binding;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        loginPresenter = new LoginPresenter(this);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.user.getText().toString();
                String password = binding.pass.getText().toString();

                loginPresenter.onLogin(username,password);
            }
        });
    }

    @Override
    public void onLoginSuccess(String mess) {
        Toast.makeText(getBaseContext(),mess,Toast.LENGTH_LONG).show();
        startActivity(new Intent(getBaseContext(),Orderfood.class));
    }

    @Override
    public void onLoginError(String mess) {
        Toast.makeText(getBaseContext(),mess,Toast.LENGTH_LONG).show();
    }
}