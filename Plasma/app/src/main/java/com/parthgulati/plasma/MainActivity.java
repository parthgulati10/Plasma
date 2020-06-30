package com.parthgulati.plasma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;

    public void SignIn(View view){
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        String a = username.toString();
        Amplify.Auth.signIn(
                username.getText().toString(),
                password.getText().toString(),
                result -> Log.i("AuthQuickstart", result.isSignInComplete() ? "Sign in succeeded" : "Sign in not complete"),
                error -> Log.e("AuthQuickstart", error.toString())
        );
        Intent intent = new Intent(getApplicationContext(), DonorsActivity.class);

        Amplify.Auth.fetchAuthSession(
                result-> startActivity(intent),
                error-> Toast.makeText(this, "Incorrect Credentials", Toast.LENGTH_SHORT).show()
        );
    }
    public void SignUp(View view){
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Amplify.Auth.signUp(
//                "Parth4454",
//                "Password123",
//                AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), "parthgulati10@gmail.com").build(),
//                result -> Log.i("AuthQuickStart", "Result: " + result.toString()),
//                error -> Log.e("AuthQuickStart", "Sign up failed", error)
//        );
//        Amplify.Auth.confirmSignUp(
//                "Parth4454",
//                "860789",
//                result -> Log.i("AuthQuickstart", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete"),
//                error -> Log.e("AuthQuickstart", error.toString())
//        );
//        Amplify.Auth.signIn(
//                "Parth4454",
//                "Password123",
//                result -> Log.i("AuthQuickstart", result.isSignInComplete() ? "Sign in succeeded" : "Sign in not complete"),
//                error -> Log.e("AuthQuickstart", error.toString())
//        );
        Amplify.Auth.signOut(
                () -> Log.i("AuthQuickstart", "Signed out successfully"),
                error -> Log.e("AuthQuickstart", error.toString())
        );
    }
}
