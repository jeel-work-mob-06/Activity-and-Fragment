package com.activityandfragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeActivity2 extends AppCompatActivity {


        EditText dateEdit,timeEdit;
        Calendar calendar;
        int iHour = 0,iMinute = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_date_time2);

        calendar = Calendar.getInstance();
        dateEdit = findViewById(R.id.date_picker);
        timeEdit = findViewById(R.id.time_picker);

        DatePickerDialog.OnDateSetListener dateClick = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(calendar.YEAR,year);
                calendar.set(calendar.MONTH,month);
                calendar.set(calendar.DAY_OF_MONTH,dayOfMonth);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateEdit.setText(dateFormat.format(calendar.getTime()));
            }
        };

        TimePickerDialog.OnTimeSetListener timeClick = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                iHour = hourOfDay;
                iMinute = minute;

                String sAmPm;
                if (iHour>12) {
                    iHour-=12;
                    sAmPm = "PM";
                } 
                else if (iHour==12) {
                    sAmPm = "PM";    
                }
                else if (iHour==0) {
                    sAmPm = "AM";
                }
                else {
                    sAmPm = "AM";
                }

                String sMinute;
                if (iMinute < 10) {
                    sMinute = "0" + iMinute;
                }
                else {
                    sMinute = String.valueOf(iMinute);
                }

                timeEdit.setText(iHour+":"+sMinute+" "+sAmPm);
            }
        };

        dateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DatePickerDialog dialog = new DatePickerDialog(DateTimeActivity2.this,dateClick,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
               dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
               dialog.show();

            }
        });
        timeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog picker = new TimePickerDialog(DateTimeActivity2.this,timeClick,iHour,iMinute,true);
                picker.show();
            }
        });
    }
}