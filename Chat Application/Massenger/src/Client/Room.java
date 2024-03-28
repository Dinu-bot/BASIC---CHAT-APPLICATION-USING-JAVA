package Client;

import Server.ColorChanger;

import java.io.*;
import java.net.Socket;

import static Client.User.getWriter;

public class Room extends Thread {
    private BufferedReader reader;
    private PrintWriter writer;
    private Socket socket;
    private String username;
    private String SERVER_IP = "localhost";

    ColorChanger changecolor = new ColorChanger();


    public Room(String username) {this.username = username;}

    //public Room(char serverip){this.SERVER_IP = String.valueOf(serverip); }

    public void connectSocket() {
        try {
            socket = new Socket(SERVER_IP, 8889);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.println(username+" Connected");
            changecolor.PURPLE();
            System.out.println("Socket is connected with server!");
            changecolor.WHITE();
            System.out.println("To leave type BYE and Enter");
            changecolor.PURPLE();
            System.out.println("....Chat with your friends.....");
            changecolor.GREEN();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = reader.readLine();
                String[] tokens = msg.split(" ");
                String cmd = tokens[0];
                StringBuilder fullMsg = new StringBuilder();
                for (int i = 1; i < tokens.length; i++) {
                    fullMsg.append(tokens[i]).append(" ");
                }

                if (cmd.equalsIgnoreCase(username + ":")) {
                    continue;
                } else if (fullMsg.toString().equalsIgnoreCase("bye")) {
                    send("BYE");
                    break;
                }
                System.out.println(msg);
            }
            reader.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void send(String message) {
        writer.println(username + ": " + message);
    }
}
