package com.example.demo;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActionBarDrawerToggle toggle;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @BindView(R.id.rvMusicLibrary)
    RecyclerView rvMusicLibrary;
    public LinearLayoutManager linearLayoutManager;
    @BindView(R.id.tvSecondPage)
    TextView tvSecondPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        linearLayoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        rvMusicLibrary.setLayoutManager(linearLayoutManager);


        ImageView navigationImage=(ImageView)toolbar.findViewById(R.id.navigatioView);

        navigationImage.setOnClickListener(view -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        tvSecondPage.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        });
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            default:
                break;
        }
    }
}
