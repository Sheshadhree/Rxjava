package com.example.rxjava.operators;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.util.Log;

import com.example.rxjava.R;
import com.jakewharton.rxbinding3.view.RxView;


import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Unit;

public class Buffer extends AppCompatActivity {

    CompositeDisposable disposables = new CompositeDisposable();
    private static final String TAG="Mainactivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffer);


//        RxView.clicks(findViewById(R.id.button))
//                .map(new Function<Unit, Integer>() {
//                    @Override
//                    public Integer apply(@NonNull Unit unit) throws Exception {
//                        return 1;
//                    }
//                })
//                .buffer(4, TimeUnit.SECONDS) // capture all the clicks during a 4 second interval
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<Integer>>() {
//                    @Override
//                    public void onSubscribe(Disposable dis) {
//                        disposables.add(dis);// add to disposables to you can clear in onDestroy
//                    }
//                    @Override
//                    public void onNext(List<Integer> integers) {
//                        Log.d(TAG, "onNext: You clicked " + integers.size() + " times in 4 seconds!");
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }
}