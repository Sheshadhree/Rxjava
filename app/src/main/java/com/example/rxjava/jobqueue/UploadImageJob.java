package com.example.rxjava.jobqueue;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.example.rxjava.jobqueue.model.ImageModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class UploadImageJob extends Job {

    String likes ;
    protected UploadImageJob(String params) {
        super(new Params(1));
    }

    @Override
    public void onAdded() {


        FirebaseDatabase database = FirebaseDatabase.getInstance("https://rxjava-4f884-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("image");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                likes = snapshot.getValue(String.class);

                Log.i("kaam" , likes);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onRun() throws Throwable {


        FirebaseDatabase database = FirebaseDatabase.getInstance("https://rxjava-4f884-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("images");

        myRef.setValue(likes.toUpperCase(Locale.ROOT));


    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}
