package com.example.practice.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

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
    @BindView(R.id.btnCreateAccount)
    Button btnCreateAccount;
    @BindView(R.id.cbRememberMe)
    CheckBox cbRememberMe;
    @BindView(R.id.toolbar)
    View toolbar;

    private final String TAG="LOGINACTIVITY";
    private FirebaseAuth mAuth;

    TextView tvHeading;
    ImageView ivTool;
    private final String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public final String MYPREFERENCES="MyPreferences";
    public final String EMAIL="email";
    public final String PASSWORD="password";
    public final String CHECKBOX="checkbox";
    public final String REMOVE="remove";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        btnClick.setOnClickListener(this);
        btnCreateAccount.setOnClickListener(this);
        tvHeading=toolbar.findViewById(R.id.tvHeading);
        tvHeading.setText("Login");
        ivTool=toolbar.findViewById(R.id.ivBackToolBar);
        ivTool.setVisibility(View.GONE);

        mAuth=FirebaseAuth.getInstance();
        sharedPreferences=getSharedPreferences(MYPREFERENCES,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

        if(sharedPreferences.getBoolean(CHECKBOX,false)){
            mAuth.signInWithEmailAndPassword(sharedPreferences.getString(EMAIL,"ali"),sharedPreferences.getString(PASSWORD,"tony"))
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                cbRememberMe.setChecked(true);
                            } else {

                            }
                        }
                    });
        }else{
            etEmail.setText("");
            etPassword.setText("");
            cbRememberMe.setChecked(false);
        }


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnClick:
                if(validation()){
                    mAuth.signInWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Log.d(TAG, "signInWithEmail:Success");
                                        if(cbRememberMe.isChecked()){
                                            editor.putBoolean(CHECKBOX,true);
                                            editor.putString(EMAIL,etEmail.getText().toString());
                                            editor.putString(PASSWORD,etPassword.getText().toString());
                                            editor.commit();
                                        }
                                        else{
                                            editor.remove(REMOVE);
                                            editor.commit();
                                        }
                                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                        /*FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);*/
                                    } else {
                                        llEmail.setError("Invalid Email");
                                        llPassword.setError("Invalid Password");
                                        Toast.makeText(getApplicationContext(),"Authentication Failed",Toast.LENGTH_SHORT).show();
                                        Log.w(TAG, "signInWithEmail:Failure", task.getException());
                                        //updateUI(null);
                                    }
                                }
                            });

                }
                break;
            case R.id.btnCreateAccount:
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
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
        }else if(!etEmail.getText().toString().matches(emailPattern)){
            llEmail.setError("Invalid Email");
            llEmail.requestFocus();
            return false;
        }
        else if(TextUtils.isEmpty(etPassword.getText())){
            llPassword.setError("Required Field");
            llPassword.requestFocus();
            return false;
        }
        return true;
    }
}
