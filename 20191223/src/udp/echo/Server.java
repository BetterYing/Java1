package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建一个服务器socket 同时还绑定了8888端口，默认绑定的ip是所有ip
        DatagramSocket socket = new DatagramSocket(8888);
        while (true) {
            byte[] buffer = new byte[4096];//准备一个接受缓冲区

            //创建了一个接受报文
            DatagramPacket receivePacket = new DatagramPacket(buffer,0,buffer.length);
            socket.receive(receivePacket);

            int len = receivePacket.getLength();
            String message = new String(buffer,0,len,"UTF-8");

            System.out.println("收到了消息  ： " + message);

            String echoMessage = message;
            byte[] sendBuffer = echoMessage.getBytes("UTF-8");

            //创建发送报文
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,//发送缓冲区
                    0,
                    sendBuffer.length,
                    receivePacket.getAddress(),//对方的ip
                    receivePacket.getPort()//对方的port
            );

            socket.send(sendPacket);
        }
    }
}
