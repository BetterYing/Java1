import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BaiDuClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("61.135.169.121",80);
        String request = "GET/HTTP/1.1\r\n" +
                "Host:www.baidu.com\r\n" +
                "\r\n";
        socket.getOutputStream().write(request.getBytes("UTF-8"));

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        socket.close();
    }
}
