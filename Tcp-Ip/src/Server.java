import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(9876);
        System.out.println("LISTENING");
        sc.nextLine();
        System.out.println("等待有客户端连接");
        Socket socket = serverSocket.accept();
        System.out.println("ESTABLISHED");
        System.out.println("等客户端先关闭: close");
        System.out.println("CLOSE_WAIT");
        sc.nextLine();

        socket.close();//关闭连接

        System.out.println("真正关闭");
        //socket.shutdownOutput();//只关闭写端
        //socket.shutdownInput();//只关闭读端

    }
}
