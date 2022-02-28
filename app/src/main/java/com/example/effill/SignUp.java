package com.example.effill;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;


public class SignUp extends AppCompatActivity {

    Button sign;
    TextInputLayout full_name,email,identity,phone,nationality,address, password;
    //TextInputEditText full_name,email,identity,phone,nationality,address, password;
   // FirebaseDatabase firebaseDatabase;
    //DatabaseReference databaseReference;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://effill-83adb-default-rtdb.firebaseio.com/");

    RegisterFireBase registerFireBase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        full_name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        identity = findViewById(R.id.identity);
        phone = findViewById(R.id.phone);
        nationality = findViewById(R.id.nationality);
        address = findViewById(R.id.address);
        password = findViewById(R.id.password);

        sign = findViewById(R.id.signup);

       // firebaseDatabase = FirebaseDatabase.getInstance();
       // databaseReference = firebaseDatabase.getReference().child("users");
       // registerFireBase = new RegisterFireBase();

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtFull_name = full_name.getEditText().getText().toString();
                String txtEmail = email.getEditText().getText().toString();
                String txtIdentity = identity.getEditText().getText().toString();
                String txtPhone = phone.getEditText().getText().toString();
                String txtNation = nationality.getEditText().getText().toString();
                String txtAddress = address.getEditText().getText().toString();
                String txtPass = password.getEditText().getText().toString();

                if (TextUtils.isEmpty(txtFull_name) || TextUtils.isEmpty(txtEmail)|| TextUtils.isEmpty(txtIdentity)||TextUtils.isEmpty(txtPhone)||TextUtils.isEmpty(txtNation)
                ||TextUtils.isEmpty(txtAddress)||TextUtils.isEmpty(txtPass)){
                    Toast.makeText(SignUp.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }else {
                    //RegisterNewUser(textFull_name,txtEmail,txtIdentity,txtPhone,txtNation,txtAddress,txtPass);
                    //addDataFirebase();
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(txtPhone)){
                                Toast.makeText(SignUp.this, "Phone is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("users").child(txtPhone).child("full_name").setValue(txtFull_name);
                                databaseReference.child("users").child(txtPhone).child("email").setValue(txtEmail);
                                databaseReference.child("users").child(txtPhone).child("identity").setValue(txtIdentity);
                                databaseReference.child("users").child(txtPhone).child("nationality").setValue(txtNation);
                                databaseReference.child("users").child(txtPhone).child("address").setValue(txtAddress);
                                databaseReference.child("users").child(txtPhone).child("password").setValue(txtPass);

                                Toast.makeText(SignUp.this, "User registered successfully.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });










                }


            }
        });




    }
  /* private void addDataFirebase(){
       /* registerFireBase.setFull_name(full_name);
        registerFireBase.setEmail(email);
        registerFireBase.setIdentity(identity);
        registerFireBase.setPhone(phone);
        registerFireBase.setNationality(nationality);
        registerFireBase.setAddress(address);
        registerFireBase.setPassword(password);
        String name = full_name.getEditText().getText().toString();
        String mail = email.getEditText().getText().toString();
        String ID = identity.getEditText().getText().toString();
        String number = phone.getEditText().getText().toString();
        String nation = nationality.getEditText().getText().toString();
        String add = address.getEditText().getText().toString();
        String pass = password.getEditText().getText().toString();

        RegisterFireBase registerFireBase = new RegisterFireBase(name,mail,ID,number,nation,add,pass);
        databaseReference.push().setValue(registerFireBase);
        Toast.makeText(SignUp.this, "You have successfully registered!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
        finish();

      /*  databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                databaseReference.setValue(registerFireBase);
                Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(SignUp.this, "Failed to add" +error, Toast.LENGTH_SHORT).show();

            }
        });*/





    /*private void RegisterNewUser(String full_name,String email,String identity,String phone,String nationality, String address,String password){
        ProgressDialog progressDialog = new ProgressDialog(SignUp.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Registering User");
        progressDialog.show();
        String URL = "http://10.109.1.156/RegisterLogin/register.php";

        RequestQueue queue = Volley.newRequestQueue(SignUp.this);

        StringRequest request = new StringRequest(Request.Method.POST, URL, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Successfully register")){
                    progressDialog.dismiss();
                    Toast.makeText(SignUp.this, response, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUp.this,Login.class));
                    finish();
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(SignUp.this, response, Toast.LENGTH_SHORT).show();
                }

            }
        }, (VolleyError error) -> {
            progressDialog.dismiss();
            Toast.makeText(SignUp.this, "failed to respond"+error, Toast.LENGTH_SHORT).show();
        }){

            @Override
            protected Map<String, String> getParams() {
                HashMap<String,String> param = new HashMap<>();
                param.put("full_name",full_name);
                param.put("email",email);
                param.put("identity",identity);
                param.put("phone",phone);
                param.put("nationality",nationality);
                param.put("address",address);
                param.put("password",password);

                return param;
            }
        };
        //request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //MySingleton.getmInstance(SignUp.this).addToRequestQueue(request);
        queue.add(request);

    }*/

   /* private Boolean validateFull_name(){
        String full = full_name.getEditText().getText().toString();
        if (full.isEmpty()){
            full_name.setError("Full Name cannot be empty");
            return false;
        }
        else{
            full_name.setError(null);
            return true;
        }
    }

    private Boolean validateMail(){
        String Mail = email.getEditText().getText().toString();
        if (Mail.isEmpty()){
            email.setError("Email cannot be empty");
            return false;
        }
        else {
            email.setError(null);
            return true;
        }
    }

    private  Boolean validateID(){
        String id = identity.getEditText().getText().toString();
        if (id.isEmpty()){
            identity.setError("Please provide your Identity Card");
            return false;
        }else {
            identity.setError(null);
            return true;
        }
    }

    private Boolean validateNumber(){
        String num = phone.getEditText().getText().toString();
        if (num.isEmpty()){
            phone.setError("Provide your Phone number");
            return false;
        }
        else {
            phone.setError(null);
            return true;
        }
    }

    private Boolean validateOrigin(){
        String origin = nationality.getEditText().getText().toString();
        if (origin.isEmpty()){
            nationality.setError("Please provide your Country");
            return false;
        }else {
            nationality.setError(null);
            return true;
        }
    }

    private  Boolean validateAdd(){
        String ad = address.getEditText().getText().toString();
        if (ad.isEmpty()){
            address.setError("Please provide your address");
            return false;
        }else {
            address.setError(null);
            return true;
        }
    }


    public void registerUser(View view) {

        if (!validateFull_name() | !validateMail() | !validateID() | !validateNumber() | !validateOrigin() | !validateAdd() |!validatePass()){

            return;
        }
        String name = full_name.getEditText().getText().toString();
        String mail = email.getEditText().getText().toString();
        String ID = identity.getEditText().getText().toString();
        String number = phone.getEditText().getText().toString();
        String nation = nationality.getEditText().getText().toString();
        String add = address.getEditText().getText().toString();
        String pass = password.getEditText().getText().toString();


    }*/
}