import java.io.*;
import java.net.Socket;

public class Task implements Runnable{
    private final Socket socket;
    public Task(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            Request request = Request.parse(is);
            System.out.println(request);

            if (request.path.equals("/hello")) {
                String body = "<h1>你好</h1>";
                byte[] bodyBytes = body.getBytes("Utf-8");

                StringBuilder respondSB = new StringBuilder();
                respondSB.append("HTTP/1.0 200 OK\r\n");
                respondSB.append("Content-Type: text/plain;charset=UTF-8\r\n");
                respondSB.append("Content-Length");
                respondSB.append(bodyBytes.length);
                respondSB.append("\r\n");
                respondSB.append("\r\n");
                respondSB.append(body);
                os.write(respondSB.toString().getBytes("UTF-8"));
                os.flush();
            } else if (request.path.equals("/run")) {
                String body = "<script src='/joke.js'></script>";
                byte[] bodyBytes = body.getBytes("Utf-8");

                StringBuilder respondSB = new StringBuilder();
                respondSB.append("HTTP/1.0 200 OK\r\n");
                respondSB.append("Content-Type: text/html;charset=UTF-8\r\n");
                respondSB.append("Content-Length");
                respondSB.append(bodyBytes.length);
                respondSB.append("\r\n");
                respondSB.append("\r\n");
                respondSB.append(body);

                os.write(respondSB.toString().getBytes("UTF-8"));
                os.flush();

            } else if (request.path.equals("/joke.js")) {
                String body = "alert('不给糖果就捣乱');";
                byte[] bodyBytes = body.getBytes("Utf-8");

                StringBuilder respondSB = new StringBuilder();
                respondSB.append("HTTP/1.0 200 OK\r\n");
                respondSB.append("Content-Type: text/html;charset=UTF-8\r\n");
                respondSB.append("Content-Length");
                respondSB.append(bodyBytes.length);
                respondSB.append("\r\n");
                respondSB.append("\r\n");
                respondSB.append(body);

                os.write(respondSB.toString().getBytes("UTF-8"));
                os.flush();


            } else if (request.path.equals("/move")){
                StringBuilder respondSB = new StringBuilder();
                respondSB.append("HTTP/1.0 307 Temporary Redirect\r\n");
                respondSB.append("Location: https://www.baidu.com/\r\n");

                respondSB.append("\r\n");
                os.write(respondSB.toString().getBytes("UTF-8"));
                os.flush();

            } else if (request.path.equals("/set-cookie")) {
                StringBuilder respondSB = new StringBuilder();
                respondSB.append("HTTP/1.0 200 OK\r\n");
                respondSB.append("Set-Cookie: name = zhangsan\r\n");
                respondSB.append("Set-Cookie: age = 18\r\n");

                respondSB.append("\r\n");
                os.write(respondSB.toString().getBytes("UTF-8"));
                os.flush();
            } else if (request.path.contains("/login")) {
                String username = request.path.split("=")[1];
                User currentUser = null;
                for (User user : SimpleHTTPServer.users) {
                    if (user.username.equals(username)) {
                        currentUser = user;
                    }
                }
                if (currentUser == null) {
                    //登陆失败
                    StringBuilder responseSB = new StringBuilder();
                    responseSB.append("HTTP/1.0 401 Unauthorized\r\n");
                    responseSB.append("\r\n");
                    // 发送响应
                    os.write(responseSB.toString().getBytes("UTF-8"));
                    os.flush();
                } else {
                    String filename = String.format("sessions/%s.session", currentUser.id);
                    OutputStream fileOS = new FileOutputStream(filename);
                    ObjectOutputStream oos = new ObjectOutputStream(fileOS);
                    oos.writeObject(currentUser);
                    fileOS.close();

                    String body = "<h1>恭喜登录成功</h1>";

                    StringBuilder responseSB = new StringBuilder();
                    responseSB.append("HTTP/1.0 200 OK\r\n");
                    responseSB.append("Content-Type: text/html;charset=UTF-8\r\n");
                    responseSB.append("Content-Length: ");
                    responseSB.append(body.getBytes("UTF-8").length);
                    responseSB.append("\r\n");
                    responseSB.append("Set-Cookie: session_id=");
                    responseSB.append(currentUser.id);
                    responseSB.append("\r\n");
                    responseSB.append("\r\n");
                    responseSB.append(body);
                    // 发送响应
                    os.write(responseSB.toString().getBytes("UTF-8"));
                    os.flush();
                }
            } else if (request.path.equals("/profile")) {
                // 获取 cookie 中的 sessionId
                String cookie = request.headers.get("Cookie");
                if (cookie == null) {
                    // response 401
                    StringBuilder respondSb = new StringBuilder();
                    respondSb.append("HTTP/1.0 401 Unauthorized\r\n");
                    respondSb.append("\r\n");
                    os.write(respondSb.toString().getBytes("UTF-8"));
                    os.flush();
                } else {

                    String sessionId = cookie.split("=")[1];

                    // 根据 session-id 获取用户信息
                    String filename = String.format("sessions/%s.session", sessionId);
                    File file = new File(filename);
                    if (file.exists()) {
                        System.out.println(filename);
                        InputStream fileOS = new FileInputStream(filename);
                        ObjectInputStream ois = new ObjectInputStream(fileOS);
                        User currentUser = (User) ois.readObject();
                        fileOS.close();


                        // 返回 response 个人信息 并且种 cookie
                        String body = String.format("<h1>%s</h1><img height='40' width='30' src='%s'><p>%s</p>",
                                currentUser.username,
                                currentUser.avatarUrl,
                                currentUser.show
                        );

                        StringBuilder responseSB = new StringBuilder();
                        responseSB.append("HTTP/1.0 200 OK\r\n");
                        responseSB.append("Content-Type: text/html;charset=UTF-8\r\n");
                        responseSB.append("Content-Length: ");
                        responseSB.append(body.getBytes("UTF-8").length);
                        responseSB.append("\r\n");
                        responseSB.append("Set-Cookie: session_id=");
                        responseSB.append(currentUser.id);
                        responseSB.append("\r\n");
                        responseSB.append("\r\n");
                        responseSB.append(body);
                        // 发送响应
                        os.write(responseSB.toString().getBytes("UTF-8"));
                        os.flush();
                    } else {
                        StringBuilder responseSB = new StringBuilder();
                        responseSB.append("HTTP/1.0 401 Unauthorized\r\n");
                        responseSB.append("\r\n");
                        // 发送响应
                        os.write(responseSB.toString().getBytes("UTF-8"));
                        os.flush();
                    }
                }
            } else {
                StringBuilder respondSB = new StringBuilder();
                respondSB.append("HTTP/1.0 404 NOT FOUND\r\n");
                respondSB.append("\r\n");
                os.write(respondSB.toString().getBytes("UTF-8"));
                os.flush();
            }
            socket.close();
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
