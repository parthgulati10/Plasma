package com.parthgulati.plasma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.core.Amplify;

public class ConfirmationActivity extends AppCompatActivity {
    EditText username;
    EditText password;
   public void ConfirmSignUp(View view){
       username = (EditText) findViewById(R.id.username);
       password = (EditText) findViewById(R.id.password);
       Intent intent = new Intent(getApplicationContext(), MainActivity.class);
       Amplify.Auth.confirmSignUp(
               username.getText().toString(),
               password.getText().toString(),
               result -> startActivity(intent),
               error -> Log.e("AuthQuickStart22", "Sign up failed", error)
        );
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

    }
}
