package com.example.practice.Activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    View toolbar;
    ImageView imageView;
    TextView tvHeading;
    @BindView(R.id.llEmail)
    TextInputLayout llEmail;
    @BindView(R.id.llPassword)
    TextInputLayout llPassword;
    @BindView(R.id.etEmail)
    TextInputEditText etEmail;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.btnClick)
    Button btnClick;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        btnClick.setOnClickListener(this);
        setToolBar();

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }


    public void setToolBar()
    {
        tvHeading=toolbar.findViewById(R.id.tvHeading);
        tvHeading.setText("Create New Account");
        imageView=toolbar.findViewById(R.id.ivBackToolBar);
        imageView.setImageResource(R.drawable.icon_back);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnClick:
                if(validation()){
                    mAuth.createUserWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Log.d("SIGNUP", "createUserWithEmail:success");
                                        Toast.makeText(getApplicationContext(), "Welcome",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                                    /*FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                     */
                                    } else {
                                        Log.w("SIGNUP", "createUserWithEmail:failure", task.getException());
                                        llEmail.setError("Invalid Email");
                                        llPassword.setError("Invalid Password");
                                        llEmail.requestFocus();
                                        llPassword.requestFocus();
                                        //updateUI(null);
                                    }
                                }
                            });
                }
                break;
            case R.id.ivBackToolBar:
                finish();
                break;
            default:
                break;
        }
    }


    public boolean validation(){
        if(TextUtils.isEmpty(etEmail.getText())){
            llEmail.setError("Required Field");
            llEmail.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etPassword.getText())){
            llPassword.setError("Required Field");
            llPassword.requestFocus();
            return false;
        }
        return true;
    }

}
