package com.example.effill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

public class FileNewCase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_file_new_case);

        Spinner mySpin = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(FileNewCase.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.courts));

        myArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin.setAdapter(myArrayAdapter);
        mySpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              String itemSelected = mySpin.getSelectedItem().toString();
                Toast.makeText(FileNewCase.this, "You have selected "  + itemSelected, Toast.LENGTH_SHORT).show();
                 if (i == 1){
                    String itemSelected1 = mySpin.getSelectedItem().toString();
                    ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(FileNewCase.this,android.R.layout.simple_list_item_1,
                            getResources().getStringArray(R.array.supreme_court));
                    myArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    mySpin.setAdapter(myArrayAdapter);
                    Toast.makeText(FileNewCase.this, "You have selected " + itemSelected1,  Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}