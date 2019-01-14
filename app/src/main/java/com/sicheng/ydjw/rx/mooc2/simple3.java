package com.sicheng.ydjw.rx.mooc2;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * rxjava2 线程调度  https://www.jianshu.com/p/12638513424f
 */
public class simple3 {

    /*subscribeOn来指定对数据的处理运行在特定的线程调度器Scheduler上，
    直到遇到observeOn改变线程调度器若多次设定，则只有一次起作用。
    observeOn指定下游操作运行在特定的线程调度器Scheduler上。
    若多次设定，每次均起作用。*/

    public static void main(String args[]) {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                for(int i=0;i<5;i++){

                }
            }
        }).observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

  //  Schedulers.trampoline()的作用在当前线程立即执行任务，如果当前线程有任务在执行，
    // 则会将其暂停，等插入进来的任务执行完之后，再将未完成的任务接着执行。
    //任务阻塞执行完


    //Schedulers.single()将数据的发射，处理，接收在Schedulers.single()的线程单例中排队执行
    // ，当此线程中有任务执行时，其他任务将会按照先进先出的顺序依次执行。
}
