package software.creational.singleton;

public class Task1Main {
    public static void main(String[] args) {
        System.out.println("=== Lab Task 1: Database Connection Manager ===");

        DatabaseConnectionManager studentPortal = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager feeBillingService = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager attendanceTracker = DatabaseConnectionManager.getInstance();

        System.out.println("StudentPortal HashCode:     " + System.identityHashCode(studentPortal));
        System.out.println("FeeBillingService HashCode: " + System.identityHashCode(feeBillingService));
        System.out.println("AttendanceTracker HashCode: " + System.identityHashCode(attendanceTracker));

        studentPortal.executeQuery("StudentPortal", "SELECT * FROM students");
        feeBillingService.executeQuery("FeeBillingService", "SELECT * FROM fee_vouchers");
        attendanceTracker.executeQuery("AttendanceTracker", "SELECT * FROM attendance");

        System.out.println("studentPortal == feeBillingService: " + (studentPortal == feeBillingService));
        System.out.println("feeBillingService == attendanceTracker: " + (feeBillingService == attendanceTracker));
        System.out.println("studentPortal == attendanceTracker: " + (studentPortal == attendanceTracker));
        System.out.println("Total connection objects created: " + DatabaseConnectionManager.getConstructorCount());
    }
}