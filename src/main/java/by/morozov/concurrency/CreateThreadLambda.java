package by.morozov.concurrency;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateThreadLambda {

    public static void main(String[] args) {

        Runnable r = () ->
                System.out.println("Runnable from lambda");


        List<Thread> threads = Stream.generate(() -> new Thread(r))
                .limit(10)
                .peek(Thread::start)
                .collect(Collectors.toList());


        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

}
