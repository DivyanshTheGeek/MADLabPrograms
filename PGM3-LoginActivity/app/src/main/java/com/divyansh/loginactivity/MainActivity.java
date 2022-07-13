package com.divyansh.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText emailText, passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        emailText=findViewById(R.id.editTextTextEmailAddress);
        passwordText=findViewById(R.id.editTextTextPassword);
    }
    public void signup(View view) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if (!isValidPassword(password)) {
            Toast.makeText(this, "Password does not satisfy rules!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, login.class);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        startActivity(intent);
    }
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern specialCharacter=Pattern.compile("^.*[a-zA-Z0-9].*$");
    private Boolean isValidPassword(String password)
    {
        if(password.length()<8)
        {
            return false;
        }
        if(!lowercase.matcher(password).matches()){
            return false;
        }
        if (!uppercase.matcher(password).matches()){
            return  false;
        }
        if (!specialCharacter.matcher(password).matches()){
            return false;
        }
        return true;
    }
}