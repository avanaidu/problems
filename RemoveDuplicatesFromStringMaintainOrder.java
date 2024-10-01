import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromStringMaintainOrder {


    //print 1-100 //Executor 20

    public static void main(String[] args) {

            String str = "helloworld";

        Map<String, Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        String output = map.keySet().stream().collect(Collectors.joining());

        System.out.println(output);


        new RemoveDuplicatesFromStringMaintainOrder().executorframework();

    }

    private void executorframework() {

        Runnable printTask = new Runnable() {
            int number = 1;

            @Override
            public synchronized void run() {
                while (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + " - " + number++);
                    /*try {
                        Thread.sleep(10); // Adding a small delay to make thread interleaving more visible
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0; i<5; i++){
            /*executorService.submit(() -> {
                int number = 1;
                synchronized (this) {
                    while (number <= 100) {
                        System.out.println("current thread :: " + Thread.currentThread() + " Number :: " + number++);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });*/

            executorService.submit(printTask);
        }

        executorService.shutdown();
    }
}
