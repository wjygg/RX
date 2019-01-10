package com.sicheng.ydjw.rx.mooc2;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * rxjava2 基本使用
 */
public class simple1 {

    public static void main(String args[]) {
        List<String> list= new ArrayList<>();
        list.add("测试");
        list.add("测试1");
        list.add("测试2");
        Observable.fromIterable(list).map(new Function<String, Bitmap>() {
            @Override
            public Bitmap apply(String s) throws Exception {

                return null;
            }
        }).subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bitmap>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bitmap value) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }



}
