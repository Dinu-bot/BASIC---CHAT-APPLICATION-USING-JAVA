package Client;

import Server.ColorChanger;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ColorChanger changecolor = new ColorChanger();
        changecolor.YELLOW();
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        User user = new User(username);
        Room room = new Room(username);
        room.connectSocket();

        Thread userThread = new Thread(() -> {
            while (true) {
                //System.out.print(username+"(type 'BYE' to exit): ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("BYE")) {
                    room.send(message);
                    System.exit(0);
                }
                user.send(message);
                room.send(message);
            }
        });
        Thread roomThread = new Thread(room);
        userThread.start();
        roomThread.start();
    }
}