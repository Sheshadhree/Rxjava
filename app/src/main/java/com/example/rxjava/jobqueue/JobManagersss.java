package com.example.rxjava.jobqueue;

import android.app.Application;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration;
import com.birbit.android.jobqueue.log.CustomLogger;
import com.birbit.android.jobqueue.scheduling.FrameworkJobSchedulerService;
import com.example.rxjava.retrofit.Retrofit;

public class JobManagersss extends Application {

    private static JobManagersss instance;
    private JobManager jobManager;


    public JobManagersss()
    {
        instance = this;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        getJobManager();


    }

    private void configureJobManager()
    {
        Configuration.Builder builder  = new Configuration.Builder(instance)
                .customLogger(new CustomLogger() {
                    @Override
                    public boolean isDebugEnabled() {
                        return true;
                    }

                    @Override
                    public void d(String text, Object... args) {

                    }

                    @Override
                    public void e(Throwable t, String text, Object... args) {

                    }

                    @Override
                    public void e(String text, Object... args) {

                    }

                    @Override
                    public void v(String text, Object... args) {

                    }
                })
                .minConsumerCount(1)
                .maxConsumerCount(100)
                .loadFactor(3)
                .consumerKeepAlive(300)
                .scheduler(FrameworkJobSchedulerService.createSchedulerFor(this, MyJobService.class),true);
        jobManager = new JobManager(builder.build());

    }

    public synchronized JobManager getJobManager() {

        if (jobManager == null) {
            configureJobManager();
        }
        return jobManager;
    }

    public static JobManagersss getInstance() {
        return instance;
    }
}
