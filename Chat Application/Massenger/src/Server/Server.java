package Server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static final ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        ColorChanger changecolor = new ColorChanger();
        ServerSocket serverSocket;
        Socket socket;
        //Change the font color
        changecolor.CYAN();
        System.out.println("Waiting for clients...");
        try {
            serverSocket = new ServerSocket(8889);
            while (true) {
                socket = serverSocket.accept();
                String clientaddress = socket.getInetAddress().getHostAddress();
                System.out.println(clientaddress+" Connected");
                ClientHandler clientThread = new ClientHandler(socket, clients);
                clients.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
