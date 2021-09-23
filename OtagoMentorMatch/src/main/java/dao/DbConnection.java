package dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.mariadb.jdbc.MariaDbPoolDataSource;

/*
 * Class to connect to the MySQL database server.
 * Add the following lines inside the "dependencies" section 

 */
public class DbConnection {

   private static final String USERNAME = "admin";
   // private static final String PASSWORD = "admin";

   private static final Integer DB_PORT = 3306;
   private static final String DEFAULT_URI = "jdbc:mariadb://localhost:" + DB_PORT + "/omm?user=" + USERNAME;

   private static MariaDbPoolDataSource pool;

   public static Connection getConnection(String uri) {

      if (pool == null) {
         pool = new MariaDbPoolDataSource(DEFAULT_URI);
      }

      try {
         return pool.getConnection();
      } catch (SQLException ex) {
         throw new DAOException(ex.getMessage(), ex);
      }
   }

   public static String getDefaultConnectionUri() {
      return DEFAULT_URI;
   }
}
