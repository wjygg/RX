package com.sicheng.ydjw.rx.mooc2;

import android.util.Log;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * 简化版 Observable  rxjava2  回调接口
 */
public class simple5 {
   // Single、Completable、Maybe——简化版的Observable

    public static void main(String args[]) {


        //简易版 观察者模式
        PublishSubject<String> publishSubject=PublishSubject.create();


        publishSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
               System.out.print(s);
            }
        });


        publishSubject.onNext("123456");
    }
}
