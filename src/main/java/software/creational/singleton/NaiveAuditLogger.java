package software.creational.singleton;

public class NaiveAuditLogger {
    private static NaiveAuditLogger instance;

    private NaiveAuditLogger() {
        System.out.println("[Naive] AuditLogger constructor executed");
    }

    public static NaiveAuditLogger getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(50); // simulate initialization latency
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            instance = new NaiveAuditLogger();
        }
        return instance;
    }
}