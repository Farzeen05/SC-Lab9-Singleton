package software.creational.singleton;

public class SoftwareLab1 {
    private final PrintSpooler spooler = PrintSpooler.getInstance();

    public PrintSpooler getSpooler() { return spooler; }

    public void submitJobs() {
        spooler.addPrintJob("SoftwareLab1", "Lab9_Report.pdf");
        spooler.addPrintJob("SoftwareLab1", "Singleton_Notes.docx");
    }
}