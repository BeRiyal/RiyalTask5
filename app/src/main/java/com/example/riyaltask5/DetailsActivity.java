package com.example.riyaltask5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.riyaltask5.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

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
        String PName = sharedPreferences.getString("Pname", "");
        String PCode = sharedPreferences.getString("Pcode", "");
        String PPrice = sharedPreferences.getString("Pprice", "");
        detailsBinding.tvView.setText("Name : " + PName + "\n Code : " + PCode + "\n Price : $ " + PPrice);
    }
}