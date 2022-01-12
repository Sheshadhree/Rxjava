package com.example.rxjava.operators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.rxjava.R;
import com.example.rxjava.data.DataSource;
import com.example.rxjava.model.Task;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class Map extends AppCompatActivity {

    private static final String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Observable
                .fromIterable(DataSource.createTasksList())
                .map(new Function<Task, String>() {
                    @Override
                    public String apply(Task task) throws Throwable {
                        return task.getDescription();
                    }
                })
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String string) {
                        Log.d(TAG , "OnNext:" + string);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    Function<Task , String> extractDescriptionFunction = new Function<Task, String>() {
        @Override
        public String apply(Task task) throws Throwable {
            return task.getDescription();
        }
    };
}