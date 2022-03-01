package com.example.effill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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
    }
}