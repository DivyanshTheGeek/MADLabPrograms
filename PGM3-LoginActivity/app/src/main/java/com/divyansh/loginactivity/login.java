package com.divyansh.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText emailText, passwordText;
    String rEmail,rPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        emailText = findViewById(R.id.editTextTextEmailAddress2);
        passwordText = findViewById(R.id.editTextTextPassword2);
        rEmail = getIntent().getStringExtra("email");
        rPassword = getIntent().getStringExtra("password");
    }
    public void login(View view)
    {
        String email=emailText.getText().toString();
        String password= passwordText.getText().toString();
        if(rEmail.equals(email) && rPassword.equals(password))
        {
            Intent intent=new Intent(this,success.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }
}