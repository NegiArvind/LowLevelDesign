public class Client {
    public static void main(String[] args) {
        DbConnectionPoolManager dbConnectionPoolManager = DbConnectionPoolManager.getInstance();
        DbConnection dbConnection1 = dbConnectionPoolManager.getDbConnection();
        DbConnection dbConnection2 = dbConnectionPoolManager.getDbConnection();
        DbConnection dbConnection3 = dbConnectionPoolManager.getDbConnection();
        DbConnection dbConnection4 = dbConnectionPoolManager.getDbConnection();
        DbConnection dbConnection5 = dbConnectionPoolManager.getDbConnection();
        DbConnection dbConnection6 = dbConnectionPoolManager.getDbConnection();
        DbConnection dbConnection7 = dbConnectionPoolManager.getDbConnection();
        DbConnection dbConnection8 = dbConnectionPoolManager.getDbConnection();
        dbConnectionPoolManager.releaseDbConnection(dbConnection6);
    }
}
