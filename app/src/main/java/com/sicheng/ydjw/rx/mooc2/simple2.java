package com.sicheng.ydjw.rx.mooc2;



import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class simple2 {

    public static void main(String args[]) {

        //创建型操作符
       // create:基础创建操作符
          Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

                e.onNext("create");
            }
        }).subscribe(new Consumer<String>() {
              @Override
              public void accept(String s) throws Exception {
                  System.out.println(s);
              }
          });
        //just:创建一个Observable，可接受一个或多个参数，将每个参数逐一发送
        Observable.just("helloword").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("just");
            }
        });
        //fromArray:创建一个Observable，接受一个数组，并将数组中的数据逐一发送
        Observable.fromArray(new String[]{"fromArray"}).subscribe(new Consumer<String>() {
            @Override
            public void accept(String String) throws Exception {
                System.out.println(String);
            }
        });
        //fromIterable：创建一个Observable接受一个可迭代对象，并将可迭代对象中的数据逐一发送
        List<String> list=new ArrayList<>();
        list.add("fromIterable");
        Observable.fromIterable(list).subscribe(new Consumer<String>() {
            @Override
            public void accept(String String) throws Exception {
                System.out.println(String);
            }
        });

        //过滤型操作符
       // filter：
        //filter使用Predicate 函数接口传入条件值，来判断Observable发射的每一个值是否满足这个条件，如果满足，则继续向下传递，如果不满足，则过滤掉。

        Observable.just("filter").filter(new Predicate<String>() {
            @Override
            public boolean test(String string) throws Exception {

                if("filter".equals(string)){

                    return true;
                }
                return false;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });

        //distinct:过滤掉重复的数据项，过滤规则为：只允许还没有发射过的数据项通过

        Observable.just(1,2,3,4,4,5).distinct().subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer+"");
            }
        });
     }
}
