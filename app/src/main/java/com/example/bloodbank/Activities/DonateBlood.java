package com.example.bloodbank.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.bloodbank.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class DonateBlood extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    EditText Name,GenderMale,GenderFemale,ContactNumber,Email,localAddress,City,State,BloodType,Weight,medicalCondition,FreqOfDonation,emergencyContactNumber,additionalComment;
    Button Submit,DOB;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("Blood");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_blood);
        iniDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

        Name = findViewById(R.id.EditTextName);
        DOB = findViewById(R.id.datePickerButton);
//        GenderMale = findViewById(R.id.CheckBoxMale);
//        GenderFemale = findViewById(R.id.CheckBoxFemale);
        ContactNumber = findViewById(R.id.EditTextContactNumber);
        Email = findViewById(R.id.EditTextEmail);
        localAddress = findViewById(R.id.EditTextLocalAddress);
        City = findViewById(R.id.EditTextCity);
        State = findViewById(R.id.EditTextState);
        BloodType = findViewById(R.id.EditTextBloodType);
        Weight = findViewById(R.id.EditTextWeight);
        medicalCondition = findViewById(R.id.EditTextMedicalCondition);
        FreqOfDonation = findViewById(R.id.EditTextFreqOfDonation);
        emergencyContactNumber = findViewById(R.id.EditTextEmergencyContactNumber);
        additionalComment = findViewById(R.id.AdditionalComments);
        Submit = findViewById(R.id.ButtonSubmit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = Name.getText().toString();
                String userdob = DOB.getText().toString();
                String usercontactnumber = ContactNumber.getText().toString();
                String useremail = Email.getText().toString();
                String userlocaladdress = localAddress.getText().toString();
                String usercity = City.getText().toString();
                String userstate = State.getText().toString();
                String userbloodtype = BloodType.getText().toString();
                String userweight = Weight.getText().toString();
                String usermedicalcondition = medicalCondition.getText().toString();
                String userfrequencydonation = FreqOfDonation.getText().toString();
                String useremergencycontactnumber = emergencyContactNumber.getText().toString();
                String useradditionalcomment = additionalComment.getText().toString();

                reference.child(username).child("Name").setValue(username);
                reference.child(username).child("Date of Birth").setValue(userdob);
                reference.child(username).child("ContactNumber").setValue(usercontactnumber);
                reference.child(username).child("Email").setValue(useremail);
                reference.child(username).child("Local Address").setValue(userlocaladdress);
                reference.child(username).child("BloodType").setValue(userbloodtype);
                reference.child(username).child("City").setValue(usercity);
                reference.child(username).child("State").setValue(userstate);
                reference.child(username).child("Weight").setValue(userweight);
                reference.child(username).child("Medical Condition").setValue(usermedicalcondition);
                reference.child(username).child("Frequency of Donation").setValue(userfrequencydonation);
                reference.child(username).child("Emergency Contact Number").setValue(useremergencycontactnumber);
                reference.child(username).child("Additional Comment").setValue(useradditionalcomment);

                Name.setText("");
                DOB.setText("");
                ContactNumber.setText("");
                Email.setText("");
                localAddress.setText("");
                City.setText("");
                State.setText("");
                BloodType.setText("");
                Weight.setText("");
                medicalCondition.setText("");
                FreqOfDonation.setText("");
                emergencyContactNumber.setText("");
                additionalComment.setText("");

            }
        });





    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);
    }

    private void iniDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day,month,year);
                dateButton.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this,dateSetListener,year,month,day);

    }

    private String makeDateString(int day, int month, int year) {
        return day + " "+ month + " "+ year;
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}