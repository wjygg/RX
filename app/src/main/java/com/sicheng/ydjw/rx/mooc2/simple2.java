package com.sicheng.ydjw.rx.mooc2;



import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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
                System.out.print(integer+"");
            }
        });

        //转换型操作符
        //map
        Observable.just("helloword").map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return 1;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

                System.out.print("map"+integer);
            }
        });
        //flatmap 转换多个对象
        Observable.just(new Integer[]{1,2,3},new Integer[]{4,5}).flatMap(new Function<Integer[], Observable<Integer>>() {
            @Override
            public Observable<Integer> apply(Integer[] integers) throws Exception {
                return Observable.fromArray(integers);
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

                System.out.print("flatMap:"+integer);
            }
        });
        //
        Observable.just(new Integer[]{1,2,3,3},new Integer[]{4,5}).flatMap(new Function<Integer[], ObservableSource<Integer>>() {
            @Override
            public Observable<Integer> apply(Integer[] integers) throws Exception {
                return  Observable.fromArray(integers).distinct();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("flatMap"+integer);
            }
        });

        //组合操作符
        //mergeWith 合并多个Observable发射的数据，可能会让Observable发射的数据交错。
        Integer[] integer=new Integer[]{5,6,7,8,9};
        Observable.just(1,2,3,4).mergeWith(Observable.fromArray(integer)).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.print("mergeWith"+integer);
            }
        });

        //concatWith用以合并多个Observable发射的数据，但是concatWith不会让Observable发射的数据交错。
        Integer[] integers=new Integer[]{6,7,8,9,10};
        Observable.just(1,2,3,4,5).concatWith(Observable.fromArray(integers)).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.print("concatWith:"+integer);
            }
        });

        //聚合操作符 zipWith
        Observable.just(1,2,3).zipWith(Observable.fromArray(new String[]{"小猫", "小狗","小猪"}), new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer+""+s;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.print("zipWith:"+s);
            }
        });
     }
}
