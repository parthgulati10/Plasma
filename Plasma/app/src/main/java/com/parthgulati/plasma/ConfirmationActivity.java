package com.parthgulati.plasma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Donor;
import com.amplifyframework.datastore.generated.model.Todo;

import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ABNegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ABPlus;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ANegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.APlus;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.BNegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.BPlus;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ONegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.OPlus;
import static com.parthgulati.plasma.RegisterActivity.addressHelper;
import static com.parthgulati.plasma.RegisterActivity.bloodGroupHelper;
import static com.parthgulati.plasma.RegisterActivity.emailHelper;
import static com.parthgulati.plasma.RegisterActivity.phoneHelper;
import static com.parthgulati.plasma.RegisterActivity.usernameHelper;

public class ConfirmationActivity extends AppCompatActivity {

    EditText password;
    com.amplifyframework.datastore.generated.model.BloodGroupTypes Blood;

    public void fun(EditText username){
        Todo todo = Todo.builder()
                .name(username.getText().toString())
                .description(password.getText().toString())
                .build();

        Amplify.API.mutate(
                ModelMutation.create(todo),
                response -> Log.i("MyAmplifyApp", "Added Todo with id: " + response.getData().getId()),
                error -> Log.e("MyAmplifyApp", "Create failed", error)
        );
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
   public void ConfirmSignUp(View view){

       password = (EditText) findViewById(R.id.password);

       Amplify.Auth.confirmSignUp(
               usernameHelper,
               password.getText().toString(),
               result -> {
                   Donor donor = Donor.builder()
                           .name(usernameHelper)
                           .email(emailHelper)
                           .bloodGroup(Blood)
                           .phoneNo(phoneHelper)
                           .address(addressHelper)
                           .build();

                   Amplify.API.mutate(
                           ModelMutation.create(donor),
                           response -> {
                                  Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                  startActivity(intent);
                               },
                           error -> Log.e("MyAmplifyApp", "Create failed", error)
                   );


               },
               error -> Log.e("AuthQuickStart22", "Sign up failed", error)
        );
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        if(bloodGroupHelper.equals("A+")){
            Blood = APlus;
        }
        else if(bloodGroupHelper.equals("A-")){
            Blood = ANegative;
        }
        else if(bloodGroupHelper.equals("B+")){
            Blood = BPlus;
        }
        else if(bloodGroupHelper.equals("B-")){
            Blood = BNegative;
        }
        else if(bloodGroupHelper.equals("AB+")){
            Blood = ABPlus;
        }
        else if(bloodGroupHelper.equals("AB-")){
            Blood = ABNegative;
        }
        else if(bloodGroupHelper.equals("O+")){
            Blood = OPlus;
        }
        else if(bloodGroupHelper.equals("O-")){
            Blood = ONegative;
        }


    }
}
