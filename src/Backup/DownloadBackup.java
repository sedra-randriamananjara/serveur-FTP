package Backup;
import org.apache.commons.net.ftp.FTPClient;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class DownloadBackup {
	public void FindFiles(FTPClient ftpClient) {
		try {
			boolean directoryChanged= ftpClient.changeWorkingDirectory("/backup/");
		   if(directoryChanged){
		   	System.out.println("directory changed to "+ftpClient.printWorkingDirectory());
		   }
		   else {
               System.out.println("Could not change working directory to /backup/");
           }

   String[] files = ftpClient.listNames();
   for (String file : files ) {
   	System.out.println("file :" +file);
   }       
		   if (files != null) {
		       for (String file : files) {
		           String localFilePath = "D:\\testBackup" + "/" + file;
		           try (OutputStream outputStream = new FileOutputStream(localFilePath)) {
		               ftpClient.retrieveFile(file, outputStream);
		       }
		   }
		
		   ftpClient.logout();
		   System.out.println("disconnet...");
		}
	  } catch (IOException e) {
       e.printStackTrace();
   } finally {
       if (ftpClient.isConnected()) {
           try {
               ftpClient.disconnect();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
}
}