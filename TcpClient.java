import java.io.*;
import java.net.*;

public class TcpClient {
    public static void main(String[] args) {
        String host = "127.0.0.1"; // Server address
        int port = 12345; // Server port
        try (Socket socket = new Socket(host, port)) {

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a request to the server
            String request = "hello, world!";
            out.println(request);
            System.out.println("Sent request: " + request);

            // Receive the response
            String response = in.readLine();
            System.out.println("Received response: " + response);
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
}
}
}

