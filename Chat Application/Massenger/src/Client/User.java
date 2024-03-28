package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
public class User {
    // Map to associate PrintWriter with usernames
    private static final Map<String, PrintWriter> userWriters = new HashMap<>();
    private String username;
    // Constructor to set the username
    public User(String username) {
        this.username = username;
    }
    // Method to get the PrintWriter associated with the username
    public static PrintWriter getWriter(String username) {
        return userWriters.get(username);
    }
    // Method to send messages
    public void send(String message) {
        PrintWriter writer = getWriter(username);
        if (writer != null) {
            writer.println(username + ": " + message);
        }
    }
}
