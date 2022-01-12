package com.example.rxjava.jobqueue;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowToastJob extends Job {



   
    protected ShowToastJob(String text) {
        super(new Params(1));
    }

    @Override
    public void onAdded() {

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://rxjava-4f884-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("image");

        myRef.setValue("Hello, World!");

    }

    @Override
    public void onRun() throws Throwable {
        Thread.sleep(5000);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://rxjava-4f884-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("image");

        myRef.setValue("Hello, eam!");



    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}
