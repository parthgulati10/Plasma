package com.parthgulati.plasma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.BloodGroupTypes;

import java.util.ArrayList;

import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ABNegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ABPlus;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ANegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.APlus;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.BNegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.BPlus;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.ONegative;
import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.OPlus;

public class BloodGroupActivity extends AppCompatActivity {
    ArrayList<String> bloodGroups;
    static BloodGroupTypes chosenBloodGroup;
    public void addData(){
        bloodGroups.add("A+");
        bloodGroups.add("A-");
        bloodGroups.add("B+");
        bloodGroups.add("B-");
        bloodGroups.add("AB+");
        bloodGroups.add("AB-");
        bloodGroups.add("O+");
        bloodGroups.add("O-");
    }
    public BloodGroupTypes getBloodTypes(String bloodGroupHelper) {
        BloodGroupTypes Blood = APlus;
        if (bloodGroupHelper.equals("A+")) {
            Blood = APlus;
        } else if (bloodGroupHelper.equals("A-")) {
            Blood = ANegative;
        } else if (bloodGroupHelper.equals("B+")) {
            Blood = BPlus;
        } else if (bloodGroupHelper.equals("B-")) {
            Blood = BNegative;
        } else if (bloodGroupHelper.equals("AB+")) {
            Blood = ABPlus;
        } else if (bloodGroupHelper.equals("AB-")) {
            Blood = ABNegative;
        } else if (bloodGroupHelper.equals("O+")) {
            Blood = OPlus;
        } else if (bloodGroupHelper.equals("O-")) {
            Blood = ONegative;
        }
        return Blood;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_group);


        bloodGroups = new ArrayList<String>();
        addData();
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bloodGroups);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String blood = bloodGroups.get(position);
            chosenBloodGroup = getBloodTypes(blood);
            Intent intent = new Intent(getApplicationContext(), DonorsActivity.class);
            startActivity(intent);
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){

            case R.id.logout:
                Amplify.Auth.signOut(
                        () -> Log.i("AuthQuickstart", "Signed out successfully"),
                        error -> Log.e("AuthQuickstart", error.toString())
                );
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.updatePassword:
                Intent intentUpdate = new Intent(getApplicationContext(), UpdateActivity.class);
                startActivity(intentUpdate);

            default:return false;
        }

    }
}
