import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleHttpClient {
    public static void main(String[] args) throws IOException {
        StringBuilder request = new StringBuilder();
        request.append("GET / HTTP/1.0\r\n");
        request.append("Host: www.baidu.com\r\n");
        request.append("\r\n");
        System.out.println(request.toString());

        Socket socket = new Socket("www.baidu.com",80);
        socket.getOutputStream().write(request.toString().getBytes("UTF-8"));
        socket.getOutputStream().flush();
        socket.shutdownOutput();

        byte[] buffer = new byte[4096];
        int len = socket.getInputStream().read(buffer);
        socket.close();
        //String respond = new String(buffer,0,len,"UTF-8");
        //System.out.println(respond);

        int index = -1;
        for (int i = 0; i < len - 3; i++) {
            if (buffer[i] == '\r' && buffer[i + 1] == '\n' &&
                    buffer[i + 2] == '\r' && buffer[i + 3] == '\n') {
                index = i;
                break;
            }
        }

        int 已读 = len - index - 4;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer,0,index + 4);
        Scanner sc = new Scanner(byteArrayInputStream,"UTF-8");

        String statusLine = sc.nextLine();
        System.out.println("状态行 ：" + statusLine);

        String line;
        int contentLength = -1;
        while (!(line = sc.nextLine()).isEmpty()) {
            String[] kv = line.split(":");
            String key = kv[0].trim();
        }

    }
}
