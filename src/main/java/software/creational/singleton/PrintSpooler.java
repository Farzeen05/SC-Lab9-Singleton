package software.creational.singleton;

import java.util.LinkedList;
import java.util.Queue;

public class PrintSpooler {
    private static PrintSpooler instance;
    private final Queue<String> jobQueue = new LinkedList<>();

    private PrintSpooler() {
        System.out.println("[System] PrintSpooler initialized once.");
    }

    public static synchronized PrintSpooler getInstance() {
        if (instance == null) {
            instance = new PrintSpooler();
        }
        return instance;
    }

    public synchronized void addPrintJob(String labName, String documentName) {
        jobQueue.add(labName + " -> " + documentName);
        System.out.println("[Queued] " + labName + " -> " + documentName);
    }

    public synchronized void processNextJob() {
        String job = jobQueue.poll();
        if (job == null) {
            System.out.println("[Spooler] No pending jobs.");
        } else {
            System.out.println("[Printing] " + job);
        }
    }

    public synchronized int getPendingJobCount() {
        return jobQueue.size();
    }
}