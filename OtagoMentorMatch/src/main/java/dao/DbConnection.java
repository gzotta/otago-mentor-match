package dao;


import java.sql.Connection;
import java.sql.SQLException;


/*
 * Class to connect to the MySQL database server.
 * Add the following lines inside the "dependencies" section 
 * in the build.grade file: 
 * 
 * // Get MariaDB Java Driver.
 * implementation 'org.mariadb.jdbc:mariadb-java-client:2.1.2'
 *
 */
public class DbConnection {

   private static final String USERNAME = "admin";
   private static final String PASSWORD = "admin";

   private static final Integer DB_PORT = 3306;
   private static final String DEFAULT_URI = "jdbc:mariadb://localhost:" + DB_PORT + "/";

   private static Connection  pool;

   public static Connection getConnection(String uri) {

      if (pool == null) {
	  pool = DriveManager.getConnection((uri, USERNAME, PASSWORD);
      }

      try {
         return pool.getConnection();
      } catch (SQLException ex) {
         throw new DAOException(ex.getMessage(),ex);
      }
   }

   public static String getDefaultConnectionUri() {
      return DEFAULT_URI;
   }
}
