import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelRun implements Callable {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10000);


        for (int i=0; i<10000; i++) {
            executorService.submit(() -> System.out.println("Thread " + Thread.currentThread()));
        }
        executorService.shutdown();
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
