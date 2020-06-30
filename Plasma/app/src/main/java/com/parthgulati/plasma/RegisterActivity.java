package com.parthgulati.plasma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class RegisterActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText email;
    public void SignUp(View view){
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email= (EditText) findViewById(R.id.email);
        Intent intent = new Intent(getApplicationContext(), ConfirmationActivity.class);
        Amplify.Auth.signUp(
                username.getText().toString(),
                password.getText().toString(),
                AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), email.getText().toString()).build(),
                result -> startActivity(intent),
                error -> Log.e("AuthQuickStart", "Sign up failed", error)
        );



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
