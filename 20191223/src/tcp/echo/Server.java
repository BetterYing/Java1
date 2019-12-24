package tcp.echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//telnet 127.0.0.1 8888
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            System.out.println("等待client连接");
            Socket socket = serverSocket.accept();
            System.out.println("有client连接");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(
                    os, "UTF-8"),
                    false
            );

            Scanner sc = new Scanner(is, "UTF-8");
            while (sc.hasNext()) {
                String message = sc.nextLine();
                System.out.println("收到对方的消息 : " + message);
                String respondMessage = message;
                System.out.println("发给对方的消息 : " + respondMessage);
                printWriter.println(respondMessage);
                printWriter.flush();
            }
            socket.close();
        }

    }

}
