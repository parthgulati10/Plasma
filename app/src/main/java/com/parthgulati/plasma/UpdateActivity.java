package com.parthgulati.plasma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.core.Amplify;

public class UpdateActivity extends AppCompatActivity {
   public void updatePassword(View view){
       EditText oldPassword = findViewById(R.id.oldPassword);
       String oldpassword = oldPassword.getText().toString();
       EditText newPassword = findViewById(R.id.newPassword);
       String newpassword = newPassword.getText().toString();
       Intent intent= new Intent(getApplicationContext(), UpdateActivity.class);
       Amplify.Auth.updatePassword(
               oldpassword,
               newpassword,
               () -> runOnUiThread(()-> super.onBackPressed()),
               error -> Log.e("AuthQuickstart", error.toString())
       );
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }
}
