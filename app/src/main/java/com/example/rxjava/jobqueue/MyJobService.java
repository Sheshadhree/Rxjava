package com.example.rxjava.jobqueue;

import androidx.annotation.NonNull;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.scheduling.FrameworkJobSchedulerService;

public class MyJobService extends FrameworkJobSchedulerService {
    @NonNull
    @Override
    protected JobManager getJobManager() {
        return JobManagersss.getInstance().getJobManager();
    }
}
