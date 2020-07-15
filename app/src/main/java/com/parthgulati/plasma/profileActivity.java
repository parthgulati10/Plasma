package com.parthgulati.plasma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.BloodGroupTypes;
import com.amplifyframework.datastore.generated.model.Donor;

import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ABNegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ABPlus;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ANegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.APlus;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.BNegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.BPlus;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ONegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.OPlus;
import static com.parthgulati.plasma.DonorsActivity.username1;

public class profileActivity extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView bloodGroup;
    TextView phoneNo;
    TextView address;
    private static int IMAGE_CAPUTURE_CODE = 1001;
    private static int PERMISSION_CODE = 1000;
    public String getBloodGroupString(BloodGroupTypes Blood){

        if(Blood == APlus){
            return "A+";
        }
        if(Blood == ANegative){
            return "A-";
        }
        if(Blood == BPlus){
            return "B+";
        }
        if(Blood == BNegative){
            return "B-";
        }
        if(Blood == ABPlus){
            return "AB+";
        }
        if(Blood == ABNegative){
            return "AB-";
        }
        if(Blood == OPlus){
            return "O+";
        }
        return "O-";


    }
    public void getData(){
        Amplify.API.query(
                ModelQuery.list(Donor.class, Donor.NAME.eq(username1)),
                response -> {
                    for (Donor donor : response.getData()) {
                        String nameText = "Username: " +donor.getName();
                        String emailText = "Email: " +donor.getEmail();
                        String bloodGroupText = "BloodGroup: " + getBloodGroupString(donor.getBloodGroup());
                        String phoneText = "Phone No: " +donor.getPhoneNo();
                        String addressText = "Address: " +donor.getAddress();
                         runOnUiThread(()-> name.setText(nameText));
                        runOnUiThread(()-> email.setText(emailText));
                        runOnUiThread(()-> bloodGroup.setText(bloodGroupText));
                        runOnUiThread(()-> phoneNo.setText(phoneText));
                        runOnUiThread(()-> address.setText(addressText));
                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (requestCode == PERMISSION_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//            }
//            else{
//                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
    public void makePayment(View view){
        Intent intent= new Intent(getApplicationContext(), PaymentActivity.class);
        startActivity(intent);
    }

    public void phoneCall(View view){

        String x = phoneNo.getText().toString();
        String[] splitString = x.split(" ");

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + splitString[2]));// Initiates the Intent
        startActivity(intent);
    }
//    public void makephoneCall(View view){
//        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED ) {
////
//            String[] permission = {Manifest.permission.CALL_PHONE};
//            requestPermissions(permission, PERMISSION_CODE);
//        } else {
//            Intent intent = new Intent(Intent.ACTION_CALL);
//            String x = phoneNo.getText().toString();
//            String[] splitString = x.split(" ");
//            intent.setData(Uri.parse(splitString[2]));
//            //Log.i("INFO", intent.getData().toString());
//            startActivity(intent);
//        }
//
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
         name = findViewById(R.id.username);
         email = findViewById(R.id.email);
        bloodGroup = findViewById(R.id.bloodGroup);
         phoneNo = findViewById(R.id.phoneNo);
         address = findViewById(R.id.address);

        getData();
    }
}
