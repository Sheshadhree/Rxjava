package com.example.rxjava.jobqueue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.Params;
import com.example.rxjava.R;

public class JobQueueActivity extends AppCompatActivity {

    JobManager jobManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_queue);

        jobManager = JobManagersss.getInstance().getJobManager();

        Button constraintLayout= findViewById(R.id.button2);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jobManager.addJobInBackground(new ShowToastJob("this"));
                jobManager.addJobInBackground(new UploadImageJob("this"));
            }
        });

    }
}