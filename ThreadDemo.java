public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i< 1000 ; i++){
                    System.out.println("Thread "+Thread.currentThread().getName());
                }
            }
        };
        Thread t2 = new Thread(() -> {
            for (int i = 0; i< 1000 ; i++){
                System.out.println("Thread "+Thread.currentThread().getName());
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
