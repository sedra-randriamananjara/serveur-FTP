package Backup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TimeZone;

public class ConnexionDb {
	 public Connection connexionDb() {
	        Connection conn = null;
	        try {
	            TimeZone timeZone = TimeZone.getTimeZone("Asia/Baghdad");
	            TimeZone.setDefault(timeZone);
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@26.245.54.120:1521:orcl", "serverftp", "serverftp");
	            Connection connection2 = conn;
	            return connection2;
	        } catch (Exception ne) {
	            System.out.println("UtilDB Erreur Naming : ".concat(String.valueOf(String.valueOf(ne.getMessage()))));
	        }
	        return conn;
	    }
	 
	  public ServerFtp getServer() {
		     ConnexionDb connexionDb = new ConnexionDb();
		        Connection connection = connexionDb.connexionDb();
		        if (connection != null) {
		            try {
		                Statement statement = connection.createStatement();
		                String query = "SELECT * FROM server WHERE id='SERV001'";
		                ResultSet resultSet = statement.executeQuery(query);
		                	resultSet.next();
		                    String serverAdress = resultSet.getString("serverAdress");
		                    String username = resultSet.getString("username");
		                    String password = resultSet.getString("password");

		                    System.out.println("serverAdress: " + serverAdress);
		                    System.out.println("Username: " + username);
		                    System.out.println("Password: " + password);
		                    System.out.println("----------------------------");
		                resultSet.close();
		                statement.close();
		                ServerFtp serverFtp = new ServerFtp(serverAdress,username,password);
		                return(serverFtp);
		            }
		            catch (Exception e) {
		                e.printStackTrace();
		                return null;
		            } finally {
		                try {
		                    connection.close();
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        } else {
		            System.out.println("Connexion à la base de données échouée.");
		            return null;
		        }
				
	  }
	 
}
