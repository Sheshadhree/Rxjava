package com.example.rxjava.aksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.rxjava.R;
import com.google.firebase.FirebaseError;

public class Aksh extends AppCompatActivity {

    EditText e1,e2;
    Button bt;
    Spinner s;

    //Data for populating in Spinner
    String [] dept_array={"CSE","ECE","IT","Mech","Civil"};

    String name,reg,dept;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aksh);





        //Referring the Views
        e1= (EditText) findViewById(R.id.editText);
        e2= (EditText) findViewById(R.id.laksh);

        bt= (Button) findViewById(R.id.aksh);

        s= (Spinner) findViewById(R.id.spinner);

        //Creating Adapter for Spinner for adapting the data from array to Spinner
        ArrayAdapter adapter= new
                ArrayAdapter(Aksh.this,android.R.layout.simple_spinner_item, dept_array);
        s.setAdapter(adapter);

        //Creating Listener for Button
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Getting the Values from Views(Edittext & Spinner)
                 name=e1.getText().toString();
                 reg=e2.getText().toString();
                 dept=s.getSelectedItem().toString();

                //Intent For Navigating to Second Activity
                Intent i = new Intent(Aksh.this,Aksh2.class);

                //For Passing the Values to Second Activity
                i.putExtra("aksh", name);
                i.putExtra("reg_key",reg);
                i.putExtra("dept_key", dept);
                startActivity(i);

            }
        });





    }
}