package com.parthgulati.plasma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.core.Amplify;

public class PasswordActivity extends AppCompatActivity {
     String name;
    public void resetPassword(View view){
        EditText username = findViewById(R.id.username);
        name = username.getText().toString();
        Intent intent = new Intent(getApplicationContext(), ConfirmPasswordActivity.class);
        Amplify.Auth.resetPassword(
                name,
                result -> startActivity(intent),
                error -> Log.e("AuthQuickstart", error.toString())
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);



    }
}
