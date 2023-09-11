package server;

import java.net.Socket;

public class ClientInfo {
    private String name;
    private long connectionTime;
    private Socket socket;

    public ClientInfo(String name, long connectionTime, Socket socket) {
        this.setName(name);
        this.setConnectionTime(connectionTime);
        this.setSocket(socket);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getConnectionTime() {
		return connectionTime;
	}

	public void setConnectionTime(long connectionTime) {
		this.connectionTime = connectionTime;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
