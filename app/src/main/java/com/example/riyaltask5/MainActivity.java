package com.example.riyaltask5;

import androidx.appcompat.app.AppCompatActivity;

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
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

                SharedPreferences.Editor prefEdit = sharedPreferences.edit();

                prefEdit.putString("name", mainBinding.etName.getText().toString().trim());
                prefEdit.putString("email", mainBinding.etEmail.getText().toString().trim());
                prefEdit.putString("pass", mainBinding.etPhone.getText().toString().trim());

                prefEdit.commit();

            }
        }
    }

    private boolean isValid() {
        if(mainBinding.etName.getText().toString().trim().isEmpty()){
            mainBinding.etName.setError("Can't be empty");
            return false;
        }
        else {
            mainBinding.etName.setError(null);
        }
        if(mainBinding.etEmail.getText().toString().trim().isEmpty()){
            mainBinding.etEmail.setError("Can't be empty");
            return false;
        }
        else {
            mainBinding.etName.setError(null);
        }
        if(mainBinding.etPhone.getText().toString().trim().isEmpty()){
            mainBinding.etPhone.setError("Can't be empty");
            return false;
        }
        else {
            mainBinding.etName.setError(null);
        }
        return true;
    }
    private void init(){
        mainBinding.btnSubmit.setOnClickListener(this);
    }
}