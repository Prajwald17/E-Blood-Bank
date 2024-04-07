package com.example.bloodbank.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bloodbank.R;
import com.google.android.material.textfield.TextInputEditText;

public class SpecificRequirements extends AppCompatActivity {

    TextInputEditText BloodGrp,City;

    Button Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_requirements);

        BloodGrp = findViewById(R.id.SpecificBloodGrp);
        City = findViewById(R.id.SpecificCity);
        Search = findViewById(R.id.Searchbtn);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bloodgrp = BloodGrp.getText().toString();
                String city = City.getText().toString();

                Intent intent = new Intent(SpecificRequirements.this, RequestBlood.class);
                intent.putExtra("bloodGroup", bloodgrp);
                intent.putExtra("city", city);
                startActivity(intent);
                BloodGrp.setText("");
                City.setText("");
            }
        });

    }
}