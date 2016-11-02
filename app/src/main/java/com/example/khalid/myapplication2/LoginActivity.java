package com.example.khalid.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG = "LoginActivity";
    Button btnLogin;
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        postData.put("txtUsername", username);
        postData.put("txtPassword", password);
        PostResponseAsyncTask task1 = new PostResponseAsyncTask(LoginActivity.this, postData,
                new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        Log.d(LOG, s);
                        if(s.contains("success")){
                            Toast.makeText(LoginActivity.this, "Sucessfully Login", Toast.LENGTH_LONG).show();
                            Intent in = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(in);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Try Again", Toast.LENGTH_LONG).show();
                        }
                    }
                });
        task1.execute("http://10.0.2.2:8080/mythimar/");
    }
}
