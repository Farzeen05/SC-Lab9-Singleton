package software.creational.singleton;

public class AuditLogger {
    private static volatile AuditLogger instance;

    private AuditLogger() {
        System.out.println("[Safe] AuditLogger constructor executed");
    }

    public static AuditLogger getInstance() {
        if (instance == null) {                    // 1st check (no lock)
            synchronized (AuditLogger.class) {
                if (instance == null) {            // 2nd check (with lock)
                    try {
                        Thread.sleep(50);          // simulate initialization latency
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    instance = new AuditLogger();
                }
            }
        }
        return instance;
    }
}