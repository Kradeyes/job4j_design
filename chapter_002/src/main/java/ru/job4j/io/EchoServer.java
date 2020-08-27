package ru.job4j.io;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        boolean isWork = true;

        try (ServerSocket server = new ServerSocket(9000)) {
            while (isWork) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!(str.isEmpty())) {
                        System.out.println(str);
                        if (str.contains("Bye")) {
                            isWork = false;
                            break;
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                }
            }
        }
    }
}