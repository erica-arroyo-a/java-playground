import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

class MultiThreads {

    private static class MyThread extends Thread {
        public void run() {
            System.out.println("Thread is running...");
        }
    }

    private static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Runnable thread is running...");
        }
    }

    private static class SharedResource {
        synchronized void printNumbers() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                try { Thread.sleep(100); } catch (InterruptedException e) {
                    System.out.println("Exception occurred in SharedResource: " + e.getMessage());
                }
            }
        }
    }

    private static class SharedResourceWithReentrantLock {
        private final ReentrantLock lock = new ReentrantLock();

        void printNumbersWithLock() {
            lock.lock();
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("Exception occurred in SharedResourceWithReentrantLock: " + e.getMessage());
                //e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        // 1. using Thread class
        MyThread t1 = new MyThread();
        t1.start(); // Starts the new thread

        // 2. using Runnable interface
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // 3. using Executor Framework
        try (ExecutorService executor1 = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 5; i++) {
                executor1.execute(() -> System.out.println("Thread " + Thread.currentThread().getName() + " is running"));
            }
            executor1.shutdown(); // Shuts down the executor after execution
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // 4. using Callable and Future
        try (ExecutorService executor2 = Executors.newFixedThreadPool(2)) {
            Callable<Integer> task = () -> {
                return 42; // Example computation
            };
            Future<Integer> future = executor2.submit(task);
            System.out.println("Result: " + future.get()); // Blocks until result is available

            executor2.shutdown();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // 5. using Synchronization for Thread Safety
        SharedResource resource1 = new SharedResource();
        Thread t3 = new Thread(() -> resource1.printNumbers());
        Thread t4 = new Thread(() -> resource1.printNumbers());
        t3.start();
        t4.start();

        // 6. using ReentrantLock
        SharedResourceWithReentrantLock resource2 = new SharedResourceWithReentrantLock();
        Thread t5 = new Thread(() -> resource2.printNumbersWithLock());
        Thread t6 = new Thread(() -> resource2.printNumbersWithLock());
        t5.start();
        t6.start();

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();
        t5.interrupt();
        t6.interrupt();
    }
}
