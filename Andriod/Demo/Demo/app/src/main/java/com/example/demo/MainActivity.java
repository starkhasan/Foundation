package com.example.demo;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActionBarDrawerToggle toggle;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @BindView(R.id.textview)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        textView.setOnClickListener(this);
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


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.textview:
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                break;
            default:
                break;
        }
    }
}
