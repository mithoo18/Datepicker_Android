package com.example.datepicker_in_android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    DatePickerDialog datePicker;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar calender = Calendar.getInstance();

        editText = findViewById(R.id.editext);
        final int day = calender.get(Calendar.DAY_OF_MONTH);
        final int year = calender.get(Calendar.YEAR);
        final int month = calender.get(Calendar.MONTH);


        datePicker = new DatePickerDialog(MainActivity.this);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                        editText.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                },year,month,day);

                datePicker.getDatePicker().setMinDate(calender.getTimeInMillis());
                datePicker.show();
            }
        });

    }
}