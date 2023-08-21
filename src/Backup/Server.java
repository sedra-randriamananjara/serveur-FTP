package Backup;

import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class Server {
	public FTPClient CreateServer() {
	   FTPClient ftpClient = new FTPClient();
	   ConnexionDb connexiondb = new ConnexionDb();
	   connectToServerFtp(ftpClient,connexiondb.getServer());
	   return ftpClient;
}
  public void connectToServerFtp(FTPClient ftpClient,ServerFtp serverFTP) {
	  try {
	       	 System.out.println("Connecting to "+serverFTP.getServerAdress());
	           ftpClient.connect(serverFTP.getServerAdress());
	           System.out.println("using user  "+serverFTP.getUsername());
	           ftpClient.login(serverFTP.getUsername(), serverFTP.getPassword());
	           ftpClient.enterLocalPassiveMode();
	           ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	           System.out.println("succes.... connected as  "+serverFTP.getUsername());
	           System.out.println("currentDirectory is  "+ftpClient.printWorkingDirectory());           
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
		
  }
  public ServerFtp test() {
	   String hostname = "26.245.54.120";
	   String username = "DBA";
	   String password = "bici1234";	  
	  ServerFtp serveurFtp = new ServerFtp(hostname,username,password);
      return(serveurFtp);
  }
  

}
