package com.example.demo;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.junit.Test;
import sun.rmi.runtime.Log;

import java.util.concurrent.ConcurrentHashMap;


/**
 * @Date 2020/5/5 11:33
 * @Created by huangfl
 */
public class RxJavaTest {

    @Test
    public void test(){
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        hashMap.put("aa", 11);
        hashMap.put("aa", 11);
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                System.out.println("threadName11;"+Thread.currentThread().getName());
                emitter.onComplete();
            }
        })
//                .observeOn(Schedulers.computation())//回调在主线程
                .subscribeOn(Schedulers.io())//执行在io线程
                .map(item->{return item+"123123";})
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("##D:"+d.toString());
                    }

                    @Override
                    public void onNext(String value) {
                        System.out.println(value);
                        System.out.println("threadName;"+Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }
    @Test
    public void test2() {
        //被观察者
        Observable novel=Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                emitter.onComplete();
            }
        });

        //观察者
        Observer<String> reader=new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                System.out.println(value);
                if ("2".equals(value)){
                    return;
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
//
        novel.subscribe(reader);//一行代码搞定
    }
}
