package Backup;

public class ServerFtp {
String serverAdress;
String username;
String password;
public ServerFtp(String serverAdress, String username, String password) {
	this.serverAdress = serverAdress;
	this.username = username;
	this.password = password;
}
public String getServerAdress() {
	return serverAdress;
}
public void setServerAdress(String serverAdress) {
	this.serverAdress = serverAdress;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
