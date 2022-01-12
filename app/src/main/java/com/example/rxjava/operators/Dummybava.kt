package com.example.rxjava.operators

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.birbit.android.jobqueue.JobManager
import com.example.rxjava.R
import com.example.rxjava.data.DataSource
import com.example.rxjava.model.Task
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class Dummybava  {

//    protected fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_create)
//
////       1 final Task task = new Task("Hell",true,1);
//        val tasks = DataSource.createTasksList()
//        val observable =
//            Observable.create<Task> { emitter -> //                       1 if(!emitter.isDisposed())
//                //                        {
//                //                            emitter.onNext(task);
//                //                            emitter.onComplete();
//                //                        }
//                for (task in tasks) {
//                    if (!emitter.isDisposed) {
//                        emitter.onNext(task)
//                    }
//                }
//                if (!emitter.isDisposed) {
//                    emitter.onComplete()
//                }
//            }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//        observable.subscribe(object : Observer<Task> {
//            override fun onSubscribe(d: Disposable) {}
//            override fun onNext(task: Task) {
//                Log.d(Create.TAG, "onNext:" + task.description)
//            }
//
//            override fun onError(e: Throwable) {}
//            override fun onComplete() {}
//        })
//    }
//
//
//    @Synchronized
//    fun getJobManager(): JobManager? {
//        if (jobManager == null) {
//            configureJobManager()
//        }
//        return jobManager
//    }
//
//
//
//    new Observer() {
//        @Override
//        public void onSubscribe(Disposable d) {
//            System.out.println("onSubscribe");
//        }
//
//        @Override
//        public void onNext(Object o) {
//            System.out.println("onNext: " + o);
//        }
//
//        @Override
//        public void onError(Throwable e) {
//            System.out.println("onError: " + e.getMessage());
//        }
//
//        @Override
//        public void onComplete() {
//            System.out.println("onComplete");
//        }
//    };

}