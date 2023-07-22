package com.example.riyaltask5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.riyaltask5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();

        setContentView(view);
        init();
    }

    public void onClick(View  v){
        if(v.getId()==mainBinding.btnSubmit.getId()){
            if(isValid()){
                SharedPreferences sharedPreferences = getSharedPreferences("LoginSharedPref",MODE_PRIVATE);

                SharedPreferences.Editor prefEdit = sharedPreferences.edit();

                prefEdit.putString("Pname", mainBinding.etPname.getText().toString().trim());
                prefEdit.putString("Pcode", mainBinding.etPCode.getText().toString().trim());
                prefEdit.putString("Pprice", mainBinding.etPPrice.getText().toString().trim());

                prefEdit.apply();

                Intent toDetails = new Intent(this, DetailsActivity.class);
                startActivity(toDetails);

            }
        }
    }

    private boolean isValid() {
        if(mainBinding.etPname.getText().toString().trim().isEmpty()){
            mainBinding.etPname.setError("Can't be empty");
            return false;
        }
        else {
            mainBinding.etPCode.setError(null);
        }
        if(mainBinding.etPCode.getText().toString().trim().isEmpty()){
            mainBinding.etPCode.setError("Can't be empty");
            return false;
        }
        else {
            mainBinding.etPCode.setError(null);
        }
        if(mainBinding.etPPrice.getText().toString().trim().isEmpty()){
            mainBinding.etPPrice.setError("Can't be empty");
            return false;
        }
        else {
            mainBinding.etPPrice.setError(null);
        }
        return true;
    }
    private void init(){
        mainBinding.btnSubmit.setOnClickListener(this);

    }
}