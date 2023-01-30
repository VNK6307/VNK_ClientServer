import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws IOException {
        out.println("Сервер запущен!");
        int port = 8090;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.printf("Новое соединение разрешено на порту № %d%n", clientSocket.getPort());
                    final String name = in.readLine();
                    out.println(String.format("Привет %s! Твой порт %d.", name, clientSocket.getPort()));
                }
            }
        }
    }// main
}