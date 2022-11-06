package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

public class E2ChefLoggedInScreen extends MainActivity {
    FirebaseAuth fAuth;
    FirebaseDatabase database;
    DatabaseReference dataRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e2_chef_logged_in_screen);

        Button logOff = (Button) findViewById(R.id.logOffButton);
        TextView chefSuspensed = findViewById(R.id.chefSuspensedText);
        TextView chefSuspensedLength = findViewById(R.id.chefSuspensedLengthText);

        fAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Chef");
        reference.child("WcrE5plVLGSxEiIC6yt6ubrEUvr1");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot){
                // Get Post object and use the values to update the UI
                // ..

                Log.d("Getting Data",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
            }
        });


        //check to see if the chef is suspensed in the database
        if(true) {
            chefSuspensed.setVisibility(View.VISIBLE);
        }

        //Get Info from DB and set data
        if (true) {
            chefSuspensedLength.setText("You are suspensed permanently");
        }

        if (true) {
            chefSuspensedLength.setText("You are suspensed for " + "inset var here" + " days");
        }


        logOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);            }
        });

    }
}
