package tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",8888);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        Scanner stdinScanner = new Scanner(System.in);//读本地用户准备发送的Scanner
        while (true) {
            System.out.print("请提交命令");
            String message = stdinScanner.nextLine();
            byte[] sendBuffer = message.getBytes("UTF-8");
            os.write(sendBuffer);
            os.write('\r');
            os.write('\n');
            Scanner sc = new Scanner(is, "UTF-8");//读server发送的Scanner
            System.out.println(sc.nextLine());
            socket.close();
        }
    }
}
