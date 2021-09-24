package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Class to connect to the MySQL database server.
 * Add the following lines inside the "dependencies" section 

 */
public class DbConnection {

   private static final String USERNAME = "admin";
   private static final String PASSWORD = "admin";

   private static final Integer DB_PORT = 3306;
   private static final String DEFAULT_URI = "jdbc:mariadb://localhost:" + DB_PORT + "/omm?user=" + USERNAME
         + "&password=" + PASSWORD;

   public static Connection getConnection(String uri) {
      try {
         return DriverManager.getConnection(uri);
      } catch (SQLException ex) {
         throw new DAOException(ex.getMessage(), ex);
      }
   }

   public static String getDefaultConnectionUri() {
      return DEFAULT_URI;
   }
}
