import java.io.*;
import java.net.*;

public class TcpServer {
    public static void main(String[] args) {
        int port = 12345; // Server port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            
            while (true) {
                // Accept the client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                String request = in.readLine();
                System.out.println("Received request: " + request);
                String response = processRequest(request);
                out.println(response);
                System.out.println("Sent response: " + response);
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    
    private static String processRequest(String request) {
        return request.toUpperCase();
}
}
