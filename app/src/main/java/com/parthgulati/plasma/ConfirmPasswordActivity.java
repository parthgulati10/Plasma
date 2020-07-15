package com.parthgulati.plasma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.core.Amplify;

public class ConfirmPasswordActivity extends AppCompatActivity {
    String password;
    String code;
    public void confirmPassword(View view){
        EditText newPassword = findViewById(R.id.password);
        password = newPassword.getText().toString();
        EditText confirmationCode = findViewById(R.id.code);
        code = confirmationCode.getText().toString();
        Amplify.Auth.confirmResetPassword(
                password,
                code,
                () -> {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                },
                error -> Log.e("AuthQuickstart", error.toString())
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_password);


    }
}
