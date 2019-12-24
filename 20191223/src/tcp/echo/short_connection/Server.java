package tcp.echo.short_connection;

import sun.nio.ch.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.*;

public class Server {
    private static class Worker implements Runnable {
        private final Socket socket;
        Worker (Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                Scanner sc = new Scanner(is, "UTF-8");
                PrintStream out = new PrintStream(os, false, "UTF-8");

                while (sc.hasNextLine()) {
                    System.out.println(name + ":等待客户端发送消息");
                    String message = sc.nextLine();
                    System.out.println(name + "：收到消息：" + message);
                    String echoMessage = message;
                    out.println(echoMessage);
                }
            } catch (UnsupportedEncodingException e) {
            } catch (IOException e) {
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {}
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        /*BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ExecutorService pool =  new ThreadPoolExecutor(
               10,1000,1, TimeUnit.SECONDS, queue
        );*/
        ExecutorService pool = Executors.newFixedThreadPool(100);

        //int i = 0;

        while (true) {
            System.out.println("main : 等待连接" );
            Socket socket = serverSocket.accept();
            System.out.println("main : 连接建立");
            //Thread thread = new Thread(new Worker(socket),"工作人员("+ i++ +")");
            //thread.start();
            pool.execute(new Worker(socket));
        }


    }

}
