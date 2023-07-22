package com.example.riyaltask5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.riyaltask5.databinding.ActivityDetailsBinding;

public class Details extends AppCompatActivity {

    ActivityDetailsBinding detailsBinding;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailsBinding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = detailsBinding.getRoot();
        setContentView(view);
        init();


    }
    private void init(){
        SharedPreferences sharedPreferences = getSharedPreferences("LoginSharedPref", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String email = sharedPreferences.getString("email", "");
        String phone = sharedPreferences.getString("phone", "");
        Log.d("sdsdsd",name);
        detailsBinding.tvView.setText("Name : " + name + "\n Email : " + email + "\n Phone : " + phone);
    }
}