package com.example.effill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

public class Contact extends AppCompatActivity {
    EditText Edit_To, Edit_Subject,Edit_Message;
    Button Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Edit_To = findViewById(R.id.editTextTo);
        Edit_Subject = findViewById(R.id.editTextSubject);
        Edit_Message = findViewById(R.id.EditTextMessage);
        Send = findViewById(R.id.buttonSend);

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("mailto:" +Edit_To.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT, Edit_Subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, Edit_Message.getText().toString());
                startActivity(intent);

            }
        });


    }
}


