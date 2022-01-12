package com.example.rxjava.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rxjava.R;

public class DaggerMain extends AppCompatActivity {

    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_main);


        CarComponent carComponent = DaggerCarComponent.create();

        car = carComponent.getCar();
        car.drive();
    }
}