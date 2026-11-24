package software.creational.singleton;

public class NetworkingLab2 {
    private final PrintSpooler spooler = PrintSpooler.getInstance();

    public PrintSpooler getSpooler() { return spooler; }

    public void submitJobs() {
        spooler.addPrintJob("NetworkingLab2", "Network_Topology.pdf");
    }
}