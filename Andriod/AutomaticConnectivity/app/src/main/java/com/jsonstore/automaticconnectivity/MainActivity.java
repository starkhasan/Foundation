package com.jsonstore.automaticconnectivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener{

    private TextView tvConnection;
    private Button btnConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvConnection = findViewById(R.id.tvNetworkCoonection);
        btnConnection = findViewById(R.id.btnConnection);

        if(ConnectivityReceiver.isConnected()){
            tvConnection.setText("Connected");
        }else{
            tvConnection.setText("Not Connected");
        }

        btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ConnectivityReceiver.isConnected()){
                    tvConnection.setText("Connected");
                }else{
                    tvConnection.setText("Not Connected");
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        ConnectivityReceiver connectivityReceiver = new ConnectivityReceiver();
        registerReceiver(connectivityReceiver,intentFilter);

        MyApplication.getInstance().setConnectivityListener(this);
    }


    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if(isConnected){
            tvConnection.setText("Connected");
        }else{
            tvConnection.setText("Not Connected");
        }
    }
}
