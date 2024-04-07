package com.example.bloodbank.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bloodbank.R;

public class dashboard extends AppCompatActivity {

    LinearLayout ll,requestBlood;
    CardView DonateBlood;
    TextView Username;
    String NameLogin,NameRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ll = findViewById(R.id.llprofile);
        Username = findViewById(R.id.textView10);
        DonateBlood = findViewById(R.id.DonateBloodcardView);
        requestBlood = findViewById(R.id.LLrequestBlood);

        NameLogin = getIntent().getStringExtra("username");

        Username.setText("Hi "+NameLogin);

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dashboard.this,profile.class);
                startActivity(intent);
            }
        });

        DonateBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dashboard.this, com.example.bloodbank.Activities.DonateBlood.class);
                startActivity(intent);
            }
        });

        requestBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dashboard.this,SpecificRequirements.class);
                startActivity(intent);
            }
        });
    }
}