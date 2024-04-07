package com.example.bloodbank.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bloodbank.R;
import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {

    LinearLayout logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logout = findViewById(R.id.linearLayoutProfileLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(profile.this, "Logged Out!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(profile.this, login_activity2.class));
            }
        });
    }
}