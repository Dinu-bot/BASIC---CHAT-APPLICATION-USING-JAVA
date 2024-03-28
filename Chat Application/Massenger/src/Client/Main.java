package Client;

import Server.ColorChanger;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Change the color to YELLOW
        ColorChanger changecolor = new ColorChanger();
        changecolor.YELLOW();
        //System.out.print("Enter the IP address of the SERVER Machine: ");
        //String serverip = scanner.nextLine();
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        // Create instances of User and Room
        User user = new User(username);
        Room room = new Room(username);

        // Connect to the server
        room.connectSocket();

        // Run both User and Room
        Thread userThread = new Thread(String.valueOf(user));
        Thread roomThread = new Thread(room);

        userThread.start();
        roomThread.start();

        while (true) {
            // Entering the message block
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("BYE")) {
                System.exit(0);
            }

            // Send messages to both User and Room
            user.send(message);
            room.send(message);
        }
    }
}
