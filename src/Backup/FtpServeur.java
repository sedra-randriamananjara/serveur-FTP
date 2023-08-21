package Backup;
public class FtpServeur {
    public static void main(String[] args) {
    	Server server= new Server();
    	DownloadBackup down = new DownloadBackup();
    	down.FindFiles(server.CreateServer());
   }
}
