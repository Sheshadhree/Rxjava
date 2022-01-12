package com.example.rxjava.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rxjava.R;
import com.example.rxjava.retrofit.model.GetDataService;
import com.example.rxjava.retrofit.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Retrofit extends AppCompatActivity {

    private RecyclerviewAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);


        progressDoalog = new ProgressDialog(Retrofit.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<Posts>> call = service.getAllPost();
        call.enqueue(new Callback<List<Posts>>() {

            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(Retrofit.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void generateDataList(List<Posts> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new RecyclerviewAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Retrofit.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}