package com.sicheng.ydjw.rx;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Observable.just("helloword").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        });


        Observable.from(new Integer[]{1,2,3}).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.e(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG,"onNext"+integer);
            }
        });

        //创建被观察者
        Observable observable= Observable.create(new OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("helloword");

                subscriber.onCompleted();
            }
        });

        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {


                Log.e(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {

                Log.e(TAG,"onError");
            }

            @Override
            public void onNext(String s) {

                Log.e(TAG,s);
            }
        });*/

        //map转换单个对象
        /*Observable observable1= Observable.just(123).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer+"";
            }
        });
        observable1.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

                Log.e(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {

                Log.e(TAG,"onError");
            }

            @Override
            public void onNext(String o) {

                Log.e(TAG,"onNext"+o);
            }
        });*/

        //map转换多个对象
        /*Observable observable= Observable.create(new OnSubscribe<Integer>(){
            @Override
            public void call(Subscriber<? super Integer> subscriber) {

                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onNext(3);
                subscriber.onCompleted();
            }
        }).flatMap(new Func1<Integer, Observable<? extends String>>() {
            @Override
            public Observable<? extends String> call(Integer integer) {
                return Observable.just(integer+"");
            }
        });
        observable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

                Log.e(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {

                Log.e(TAG,"onError");
            }

            @Override
            public void onNext(String o) {

                Log.e(TAG,"onNext"+o.toString());
            }
        });*/

        /*Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                try {
                    for (int i = 1; i <= 10; i++) {
                        subscriber.onNext(i);
                        try {
                            Thread.currentThread().sleep(i * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }//过滤操纵符 debounce 一段时间内只发送 最后一个值
        }).subscribeOn(Schedulers.newThread()).debounce(2, TimeUnit.SECONDS).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {

                Log.e(TAG, "integer" + integer);
            }
        });*/


       /* //过滤操作符  elementAt 指定字符输出 elementAt(2)  filter过滤 匹配 .ignoreElements() 忽略onnext  skip 跳过前两项
        Observable.just(1,2,2,2,4,3).distinct().filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer%2==0;
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

                Log.e(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {

                Log.e(TAG, "onError");
            }

            @Override
            public void onNext(Integer integer) {

                Log.e(TAG, "onNext:"+integer);
            }
        });*/

       /* Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                try {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.currentThread().sleep(i * 1000);
                            subscriber.onNext(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }//过滤操纵符 sample 一段时间内只发送 最后一个值 的前一个
        }).subscribeOn(Schedulers.newThread()).sample(3,TimeUnit.SECONDS).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {

                Log.e(TAG, "integer" + integer);
            }
        });*/

       //skip  跳过前面两个 skipLast 跳过 后两个
       /*Observable.just(1,2,3,4).skip(2).subscribe(new Subscriber<Integer>() {
           @Override
           public void onCompleted() {

               Log.e(TAG,"onCompleted");
           }

           @Override
           public void onError(Throwable e) {

               Log.e(TAG,"onError");
           }

           @Override
           public void onNext(Integer integer) {

               Log.e(TAG,"onNext:" +integer);
           }
       });*/

       //组合操作符
        Observable<Integer> observable=Observable.just(1,2,3);
        Observable<Integer> observable1=Observable.just(4,5,6,7);
        //zip合并两个数据 一对对
        //merge 单纯合并
        //startWith 有序的合并集合
        //combineLatest 最后一个数据和后面的 集合相加
        observable.startWith(observable1).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

                Log.e(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onNext(Integer integer) {

                Log.e(TAG,"onNext:"+integer);
            }
        });
    }
}


