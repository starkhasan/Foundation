package com.example.button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar=getSupportActionBar();//THAT CREATE AN INSTANCE OF THE ACTION BAR
        actionBar.setTitle("Button Tutorial");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#058373")));
    }

    public void mymethod1(View view)
    {
       switch(view.getId())
       {
           case R.id.button1:
               Toast.makeText(getApplicationContext(),"Buttton 1",Toast.LENGTH_SHORT).show();
               break;
           case R.id.button2:
               Toast.makeText(getApplicationContext(),"Button 2",Toast.LENGTH_SHORT).show();
               break;
           case R.id.button3:
               Toast.makeText(getApplicationContext(),"Button 3",Toast.LENGTH_SHORT).show();
               break;
           case R.id.button4:
               Toast.makeText(getApplicationContext(),"Button 4",Toast.LENGTH_SHORT).show();
               break;
           case R.id.button5:
               Toast.makeText(getApplicationContext(),"Button 5",Toast.LENGTH_SHORT).show();
               break;
           case R.id.button6:
               Toast.makeText(getApplicationContext(),"Button 6",Toast.LENGTH_SHORT).show();
               break;
           case R.id.button7:
               Toast.makeText(getApplicationContext(),"Button 7",Toast.LENGTH_SHORT).show();
               break;

       }
    }
}
