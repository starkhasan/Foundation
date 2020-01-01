package com.example.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.toolbar)
    View toolbar;
    ImageView back;
    TextView tvHeading;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        settoolbar();
    }

    public void settoolbar(){
        back=toolbar.findViewById(R.id.ivBack);
        back.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        back.setOnClickListener(SecondActivity.this);
        tvHeading=toolbar.findViewById(R.id.tvHeading);
        tvHeading.setText("Second Activity");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivBack:
                finish();
                break;
            default:
                break;
        }
    }
}

