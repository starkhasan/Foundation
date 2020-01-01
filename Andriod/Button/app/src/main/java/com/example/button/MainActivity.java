package com.example.button;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.toolbar)
    View toolbar;
    ImageView ivBack;
    TextView tvHeading;

    @BindView(R.id.rlDatePicker)
    RelativeLayout rlDatePicker;
    @BindView(R.id.lltimePicker)
    RelativeLayout lltimePicker;
    @BindView(R.id.rlSpinnerPicker)
    RelativeLayout rlSpinnerPicker;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.spinnerText)
    Spinner spinnerText;
    public String name[]={"India","Australia","South Africa","West Indies","New Zealand","Sri Lanka","Bangladesh"};
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rlDatePicker.setOnClickListener(this);
        lltimePicker.setOnClickListener(this);
        settoolbar();

        list=new ArrayList<String>();
        for(int i=0;i<name.length;i++){
            list.add(name[i]);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);
        spinnerText.setAdapter(adapter);


    }

    public void settoolbar()
    {
        ivBack=toolbar.findViewById(R.id.ivBack);
        tvHeading=toolbar.findViewById(R.id.tvHeading);
        tvHeading.setText("Demo Pratice");

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.rlDatePicker:
                openDatePicker();
                break;
            case R.id.lltimePicker:
                openTimePicker();
                break;
            default:
                break;
        }
    }

    public void openDatePicker()
    {
        Calendar mcurrentDate=Calendar.getInstance();
        int year=mcurrentDate.get(Calendar.YEAR);
        int month=mcurrentDate.get(Calendar.MONTH);
        int day=mcurrentDate.get(Calendar.DAY_OF_MONTH);
        Date time=mcurrentDate.getTime();

        final DatePickerDialog   mDatePicker =new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday)
            {
                tvDate.setText(new StringBuilder().append(selectedday).append("/").append(selectedmonth+1).append("/").append(selectedyear));
                Toast.makeText(getApplicationContext(),String.valueOf(time),Toast.LENGTH_SHORT).show();
            }
        },year, month, day);
        mDatePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
        mDatePicker.show();
    }

    public void openTimePicker(){

        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        TimePickerDialog timePicker=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
                tvTime.setText(String.valueOf(hour)+":"+String.valueOf(minutes));
            }
        },hour,minute,true);
        timePicker.show();
    }

}
