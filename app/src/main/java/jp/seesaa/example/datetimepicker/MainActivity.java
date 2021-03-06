package jp.seesaa.example.datetimepicker;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;

import jp.seesaa.android.datetimepicker.date.DatePickerDialog;
import jp.seesaa.android.datetimepicker.time.RadialPickerLayout;
import jp.seesaa.android.datetimepicker.time.TimePickerDialog;


public class MainActivity extends FragmentActivity implements
        DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.newInstance(MainActivity.this, 2006, 1, 2)
                        .show(getSupportFragmentManager(), "datepicker");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.newInstance(MainActivity.this, 12, 34, true)
                        .show(getSupportFragmentManager(), "timepicker");
            }
        });

        if (savedInstanceState != null) {
            final FragmentManager fm = getSupportFragmentManager();

            DatePickerDialog datePicker = (DatePickerDialog) fm.findFragmentByTag("datepicker");
            if (datePicker != null) {
                datePicker.setOnDateSetListener(this);
            }

            TimePickerDialog timePicker = (TimePickerDialog) fm.findFragmentByTag("timepicker");
            if (timePicker != null) {
                timePicker.setOnTimeSetListener(this);
            }
        }

    }

    @Override
    public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(this, String.format("onDateSet: %d/%d/%d", year, monthOfYear, dayOfMonth), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        Toast.makeText(this, String.format("onTimeSet: %d:%d", hourOfDay, minute), Toast.LENGTH_SHORT).show();
    }
}
