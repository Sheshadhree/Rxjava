package com.example.rxjava.operators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.rxjava.R;
import com.example.rxjava.data.DataSource;
import com.example.rxjava.model.Task;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class Create extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        textView = findViewById(R.id.text);

//       1 final Task task = new Task("Hell",true,1);

        final List<Task> tasks = DataSource.createTasksList();

        Observable<Task> observable = Observable.
                create(new ObservableOnSubscribe<Task>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Task> emitter) throws Throwable {
//                       1 if(!emitter.isDisposed())
//                        {
//                            emitter.onNext(task);
//                            emitter.onComplete();
//                        }

                        for(Task task : tasks)
                        {
                            if(!emitter.isDisposed())
                            {
                                emitter.onNext(task);
                            }

                        }

                        if(!emitter.isDisposed())
                        {
                            emitter.onComplete();
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


        observable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Task task) {
                Log.d(TAG,"onNext:"+task.getDescription());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}