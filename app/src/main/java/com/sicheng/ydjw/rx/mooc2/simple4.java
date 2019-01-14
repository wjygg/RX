package com.sicheng.ydjw.rx.mooc2;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;


public class simple4 {

    public static void main(String args[]) {

        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                int i = 0;
                while (true) {
                    //e.requested() 代表缓存池中可放入的数量 0的话缓存池中不能放入数据丢失超出根据缓存策略处理

                    if (e.requested() == 0) continue;//此处添加代码，让flowable按需发送数据
                    System.out.println("发射---->" + i);
                    i++;
                    e.onNext(i);
                }
            }
        }, BackpressureStrategy.MISSING)//缓存策略抛异常处理
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Integer>() {
                    private Subscription mSubscription;

                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(1);            //设置初始需求请求数据量为1
                        mSubscription = s;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        try {
                            Thread.sleep(50);
                            System.out.println("接收------>" + integer);
                            mSubscription.request(1);//每接收到一条数据增加一条请求量
                        } catch (InterruptedException ignore) {
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

}
