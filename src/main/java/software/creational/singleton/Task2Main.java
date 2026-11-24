package software.creational.singleton;

public class Task2Main {
    public static void main(String[] args) {
        System.out.println("=== Lab Task 2: Campus Print Spooler ===");

        SoftwareLab1 lab1 = new SoftwareLab1();
        NetworkingLab2 lab2 = new NetworkingLab2();

        System.out.println("Same spooler instance: " + (lab1.getSpooler() == lab2.getSpooler()));
        System.out.println("Lab1 HashCode: " + System.identityHashCode(lab1.getSpooler()));
        System.out.println("Lab2 HashCode: " + System.identityHashCode(lab2.getSpooler()));

        lab1.submitJobs();
        lab2.submitJobs();
        System.out.println("Pending jobs: " + lab1.getSpooler().getPendingJobCount());

        System.out.println("--- Processing in FIFO order ---");
        PrintSpooler spooler = PrintSpooler.getInstance();
        while (spooler.getPendingJobCount() > 0) {
            spooler.processNextJob();
        }
        System.out.println("Pending jobs after processing: " + spooler.getPendingJobCount());
    }
}