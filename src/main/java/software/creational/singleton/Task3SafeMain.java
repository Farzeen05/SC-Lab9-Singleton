package software.creational.singleton;

public class Task3SafeMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Lab Task 3: FIXED Singleton (Double-Checked Locking) ===");
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int id = i + 1;
            threads[i] = new Thread(() -> {
                AuditLogger logger = AuditLogger.getInstance();
                System.out.println("Thread-" + id + " HashCode: " + System.identityHashCode(logger));
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
    }
}