import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {

    private final int permitsPerSecond;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final AtomicInteger permits = new AtomicInteger(0);

    public RateLimiter(int permitsPerSecond) {
        this.permitsPerSecond = permitsPerSecond;
        scheduler.scheduleAtFixedRate(() -> permits.set(permitsPerSecond), 0, 1, TimeUnit.SECONDS);
    }

    public void acquire() throws InterruptedException {
        while (true) {
            int availablePermits = permits.get();
            if (availablePermits > 0) {
                if (permits.compareAndSet(availablePermits, availablePermits - 1)) {
                    return; // Permit acquired
                }
            } else {
                Thread.sleep(100); // Wait briefly before checking again
            }
        }
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5); // 5 requests per second

        for (int i = 0; i < 20; i++) {
            rateLimiter.acquire();
            System.out.println("Request " + i + " processed");
        }

        rateLimiter.shutdown();
    }
}