package com.example.effill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class SupremeCourt extends AppCompatActivity {
    Button btn;
    FirebaseDatabase database;
    DatabaseReference reference;
    DropSpin dropSpin;
    int max_id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_supreme_court);

        Spinner mySpin = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SupremeCourt.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.case_type));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin.setAdapter(arrayAdapter);
        btn = findViewById(R.id.btnProceed);
        dropSpin = new DropSpin();
        reference = FirebaseDatabase.getInstance().getReference().child("case category");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    max_id = (int) snapshot.getChildrenCount();
                }



            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropSpin.setSpinner(mySpin.getSelectedItem().toString());
                Toast.makeText(SupremeCourt.this, "Loading", Toast.LENGTH_SHORT).show();

                reference.child(String.valueOf(max_id+1)).setValue(dropSpin);
                Intent intent = new Intent(SupremeCourt.this,ChangeView.class);
                startActivity(intent);
                finish();


            }
        });


    }

}