import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHTTPServer {
    static List<User> users = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        registerUsers();

        //建立监听
        ServerSocket serverSocket = new ServerSocket(8888);
        //建立线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //循环  读取请求--发送响应

        while (true) {
            Socket socket = serverSocket.accept();
            pool.execute(new Task(socket));
        }
    }

    private static void registerUsers() {
        users.add(new User("zhangsan","http://img3.imgtn.bdimg.com/it/u=1107263072,1224997471&fm=26&gp=0.jpg","不想写"));
        users.add(new User("lisi","https://c-ssl.duitang.com/uploads/item/201511/13/20151113110434_kyReJ.thumb.700_0.jpeg","不想写"));
        users.add(new User("wangwu","http://pic3.zhimg.com/50/v2-280218dcc9db1a9108b867bd81b29745_hd.jpg","不想写"));

    }
}
