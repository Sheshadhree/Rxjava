package com.example.rxjava.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.rxjava.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainGsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gson);

        Gson gson = new Gson();
        Address  address = new Address("mumbai" , "india");

        List<FamilyMember> familyMembers = new ArrayList<>();
        familyMembers.add(new FamilyMember("wife","23"));
        familyMembers.add(new FamilyMember("daughter","5"));


//
//        Employee employee = new Employee("hello","hello@mail",1,address,familyMembers );
//        String json = gson.toJson(employee);
//        Toast.makeText(MainGsonActivity.this, json, Toast.LENGTH_SHORT).show();
//        Log.d("json",json);

//        String json = "{\"address\":{\"city\":\"mumbai\",\"country\":\"india\"},\"age\":1,\"familyMember\":[{\"age\":\"23\",\"role\":\"wife\"},{\"age\":\"5\",\"role\":\"daughter\"}],\"firstName\":\"hello\",\"mail\":\"hello@mail\"}";
//        Employee employee = gson.fromJson(json, Employee.class);

        Password employee = new Password("joh",33,"mail" , "nskns");
        String json = gson.toJson(employee);



    }
}