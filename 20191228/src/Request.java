import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    String method;
    String path;
    String version;
    Map<String,String> headers = new HashMap<>();


    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                '}';
    }

    public static Request parse(InputStream is) {
        Request request = new Request();

        Scanner sc = new Scanner(is,"UTF-8");
        String line;

        line = sc.nextLine();
        String[] group = line.split(" ");
        request.method = group[0];
        request.path = group[1];
        request.version = group[2];

        while (!(line = sc.nextLine()).isEmpty()) {
            String[] kv = line.split(":");
            String key = kv[0];
            String value = kv[1];
            request.headers.put(key,value);
        }
        return request;
    }
}
