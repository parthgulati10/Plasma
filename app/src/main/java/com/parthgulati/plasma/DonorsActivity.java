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
import android.widget.Toast;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.BloodGroupTypes;
import com.amplifyframework.datastore.generated.model.Donor;
import com.amplifyframework.datastore.generated.model.Todo;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import static com.amplifyframework.datastore.generated.model.BloodGroupTypes.APlus;
import static com.parthgulati.plasma.BloodGroupActivity.chosenBloodGroup;

public class DonorsActivity extends AppCompatActivity {
    static String username1;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> donors;


    public void retrieveData(BloodGroupTypes BloodType){




        Amplify.API.query(
                ModelQuery.list(Donor.class, Donor.BLOOD_GROUP.eq(BloodType)),
                response -> {
                    donors = new ArrayList<String>();
                    Log.i("INFO", response.toString());
                    if(response!=null) {
                        for (Donor donor : response.getData()) {

                        if( donor.getName()!=null ) {
                            donors.add(donor.getName());
                        }
                        }
                   }
                   // runOnUiThread(() -> Toast.makeText(this, "No record found", Toast.LENGTH_SHORT).show());

                    if(donors.size()==0){
                        runOnUiThread(() -> Toast.makeText(this, "No record found", Toast.LENGTH_SHORT).show());
                       runOnUiThread(()->super.onBackPressed());
                    }
                    else{
                    //Log.i("INFO", donors.toString());

                    arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, donors);
                    //Log.i("INFO", donors.toString());
                        Intent intent = new Intent(getApplicationContext(), profileActivity.class);
                   runOnUiThread(() ->  listView.setAdapter(arrayAdapter));
                        runOnUiThread(()->  listView.setOnItemClickListener((parent, view, position, id) -> {
                            username1 = donors.get(position);
                            startActivity(intent);
                        }));
                   }
//

                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
       // Log.i("INFO", donors.toString());



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donors);
        listView = (ListView) findViewById(R.id.listView);
        retrieveData(chosenBloodGroup);
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
