package com.example.bloodbank.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;


import com.example.bloodbank.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnFailureListener;
import androidx.annotation.NonNull;


public class login_activity2 extends AppCompatActivity {

    Button loginbtn;
    TextView register;

    EditText email,password,Name;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Name = findViewById(R.id.Name);
        loginbtn = findViewById(R.id.login2);
        register = findViewById(R.id.btnregister);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        auth = FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                String txt_name = Name.getText().toString();
                loginUser(txt_email,txt_password,txt_name);
            }

            private void loginUser(String Email, String Password,String Name) {
                if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password)) {
                    Toast.makeText(login_activity2.this, "Email and password cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(Email, Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(login_activity2.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login_activity2.this, dashboard.class);
                        intent.putExtra("username", Name);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(login_activity2.this, "Login Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }



        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_activity2.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}