package com.example.effill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    Button new_case,existing_case,search_invoice,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        new_case  = findViewById(R.id.btnNewCase);
        existing_case = findViewById(R.id.btnMapExistingCase);
        search_invoice = findViewById(R.id.btnSearchCases);
        contact = findViewById(R.id.btnContact);

        new_case.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FileNewCase.class);
                startActivity(intent);
            }
        });
    }
}