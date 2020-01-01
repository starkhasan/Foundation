package com.example.practice.Activity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.practice.Adapter.CourseAdapter;
import com.example.practice.Adapter.ViewPagerAdapter;
import com.example.practice.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.ViewPagerCourse)
    ViewPager viewPager;
    @BindView(R.id.personal_details)
    RadioGroup radioGroup;
    @BindView(R.id.relativelatout1)
    RelativeLayout relativeLayout1;
    @BindView(R.id.personal_details_layout)
    RelativeLayout relativeLayout;
    @BindView(R.id.rvCourse)
    RecyclerView rvCourse;
    @BindView(R.id.submit_button)
    Button submit_button;

    private LinearLayoutManager linearLayoutManager;
    public View toolbar;
    public ImageView ivBackToolBar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    public String TAG="MAIN ACTIVITY";
    ArrayList<Integer> listIMage;
    ArrayList<String> listName;
    private Integer[] IMAGE={R.drawable.c,R.drawable.cplus,R.drawable.csharp,R.drawable.java,R.drawable.python};
    private String[] NAME={"C","C++","C#","Java","Python"};

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        drawer=findViewById(R.id.drawer_layout);
        relativeLayout1.setOnClickListener(this);
        toolbar=findViewById(R.id.toolbar);
        ivBackToolBar=toolbar.findViewById(R.id.ivBackToolBar);
        submit_button.setOnClickListener(this);

        listIMage=new ArrayList<Integer>();
        listName=new ArrayList<String>();
        for(int i=0;i<IMAGE.length;i++){
            listIMage.add(IMAGE[i]);
        }
        for(int i=0;i<NAME.length;i++){
            listName.add(NAME[i]);
        }

        linearLayoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        rvCourse.setLayoutManager(linearLayoutManager);
        rvCourse.setAdapter(new CourseAdapter(MainActivity.this,listName,listIMage));


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb=findViewById(i);
                if(rb.getText().toString().equals("Interested"))
                {
                    relativeLayout.setVisibility(View.VISIBLE);
                }
                else
                {
                    if(relativeLayout.getVisibility()==View.VISIBLE)
                    {
                        relativeLayout.setVisibility(View.GONE);
                    }
                    Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_LONG).show();
                }
            }
        });


        //Adding Navigation Drawer
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        ivBackToolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        viewPager.setAdapter(new ViewPagerAdapter(MainActivity.this,listIMage));

        Log.d(TAG,"Create Method");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.relativelatout1:
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"alihasanaec@gmail.com"});//we have taken a string array because to add more email or to attach multiple email for send
                intent.putExtra(Intent.EXTRA_SUBJECT,"Information");
                intent.putExtra(Intent.EXTRA_TEXT,"Hi EveryOne");
                startActivity(intent);
                break;
            case R.id.submit_button:
                Toast.makeText(getApplicationContext(),"Working",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Start Method");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Resume Method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Pause Method");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Stop Method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Destroy Method");
    }

}
