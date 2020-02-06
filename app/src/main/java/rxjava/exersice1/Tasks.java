package rxjava.exersice1;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class Tasks {

    public static void task1() {
        //Utilizando from y filter, imprimir los números mayores a 4
        Integer[] numbers = {0, 9, 1, 2, 3, 4, 5, 6, 8, 7};
        Observable.fromArray(numbers)
                .filter(number -> number > 4)
                .toList()
                .subscribe(list -> System.out.println("Números mayores que 4: " + list));
    }

    public static void task2() {
        //convertir los números en string en el formato {1}{2}{4}{7}{1}{0}
        List<Integer> numeros = Arrays.asList(1, 4, 3, 6, 7, 8, 9, 0, 2, 3);
        Observable.fromArray(numeros)
                .map(numero -> "{" + numero + "} ")
                .subscribe(string -> System.out.print(string));
    }

    public static void task3() {
        //filtrar por números pares
        Integer[] numeros = {0, 9, 1, 2, 3, 4, 5, 6, 8, 7};
        Observable.fromArray(numeros)
                .filter(numero -> numero % 2 == 0)
                .subscribe(numero -> System.out.print("{" + numero + "}"));
    }

    public static void flatMapMethod() {
        Integer[][] numeros = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {0, 9, 8, 7, 6, 5, 4, 3, 2, 1}
        };

        Observable.fromArray(numeros)
                .flatMap(array -> Observable.fromArray(array))
                .map(number -> "[" + number + "]")
                .subscribe(string -> System.out.print(string));
    }

    public static Observable operatorCreate() {
        return Observable.create(emitter -> {
            for (int i = 0; i <= 10; i++) {
                emitter.onNext(i);
            }
            emitter.onComplete();
        });
    }

    public static Single<Integer> getSingleObserver() {
        Single<Integer> myObserver = Single.create(emitter -> {
            for (int i = 0; i <= 10; i++) {
                emitter.onSuccess(i);
            }
        });
        return myObserver;
    }

    public static Completable getCompletableObserver() {
        Completable completable = Completable.create(emitter -> {
            for (int i = 0; i <= 10; i++) {
                emitter.onComplete();
            }
        });
        return completable;
    }

    public static void doSomeWork() {
        Flowable<Integer> flowable = Flowable.just(1, 2, 3, 4);
        flowable.reduce(50, (t1, t2) -> t1 + t2).subscribe(getObserver());
    }

    private static SingleObserver<Integer> getObserver() {
        return new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(Integer integer) {
                System.out.println("onSuccess: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        };
    }

    public static void groupBy() {
        /***
         *      Agrupar de la siguiente manera
         *      Grupo1 -> {one,two,bye}
         *      Grupo2 -> {open,next}
         *      .
         *      .
         *      .
         *
         */
        String[] array = {"one", "open", "close", "new", "next", "start", "end", "bye", "brain", "mouse"};
        Observable.fromArray(array)
                .groupBy(string -> {
                    if (string.length() == 3) {
                        return 1;
                    } else if (string.length() == 4) {
                        return 2;
                    } else
                        return 3;
                })
                .subscribe(groupBy -> {
                    System.out.println("groupKey: " + groupBy.getKey());
                    groupBy.toList().subscribe(element -> System.out.println(element + " "));
                });
    }

}
