import java.util.ArrayList;
import java.util.List;

public class DbConnectionPoolManager {

    private static DbConnectionPoolManager dbConnectionPoolManager;
    private List<DbConnection> freeConnectionInPool;
    private List<DbConnection> usedConnectionInPool;
    private final int INITIAL_POOL_SIZE = 3;
    private final int MAX_POOL_SIZE = 6;

    private DbConnectionPoolManager() {
        freeConnectionInPool = new ArrayList<>();
        usedConnectionInPool = new ArrayList<>();
        for(int i=0; i< INITIAL_POOL_SIZE; i++) {
            freeConnectionInPool.add(new DbConnection());
        }
    }

    public static DbConnectionPoolManager getInstance() {
        if(dbConnectionPoolManager == null) {
            synchronized (DbConnectionPoolManager.class) {
                if(dbConnectionPoolManager == null) {
                    dbConnectionPoolManager = new DbConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManager;
    }

    synchronized public DbConnection getDbConnection() {
        if(freeConnectionInPool.isEmpty() && usedConnectionInPool.size() < MAX_POOL_SIZE) {
            freeConnectionInPool.add(new DbConnection());
            System.out.println("Adding a new connection when free connection is not available");
        } else if(freeConnectionInPool.isEmpty() && usedConnectionInPool.size() >= MAX_POOL_SIZE) {
            System.out.println("Can not create new connection as max limit reached");
            return null;
        }
        DbConnection dbConnection = freeConnectionInPool.remove(freeConnectionInPool.size()-1);
        usedConnectionInPool.add(dbConnection);
        System.out.println("Adding connection in used pool, size: " + usedConnectionInPool.size());
        return dbConnection;
    }

    synchronized public void releaseDbConnection(DbConnection dbConnection) {
        if(dbConnection != null) {
            usedConnectionInPool.remove(dbConnection);
            System.out.println("Releasing one db connection from used pool");
            freeConnectionInPool.add(dbConnection);
            System.out.println("Adding one db connection in free pool");
            System.out.println("Connection available in free pool " + freeConnectionInPool.size());
            System.out.println("Connection used in Object pool " + usedConnectionInPool.size());
        }
    }
}
