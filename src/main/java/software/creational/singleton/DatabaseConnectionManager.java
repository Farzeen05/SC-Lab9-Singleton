package software.creational.singleton;

public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private static int constructorCount = 0;

    private DatabaseConnectionManager() {
        constructorCount++;
        System.out.println("[System] Database connection opened. Constructor executions: " + constructorCount);
    }

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public void executeQuery(String moduleName, String sql) {
        System.out.println("[" + moduleName + "] Executing: " + sql);
    }

    public static int getConstructorCount() {
        return constructorCount;
    }
}