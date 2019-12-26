import com.sun.xml.internal.bind.v2.runtime.output.Encoded;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "https://www.so.com/s?src=lm&ls=sm2297808&lm_extend=ctype:31&q=C%2B%2B";
//        int i;
//        i = url.indexOf("://");
//        String hostAndPort = url.substring(0,i);
//        System.out.println(hostAndPort);
//
//        i = url.indexOf("?");
//        url = url.substring(i + 3);
//        System.out.println(url);
//
//        url = url.substring(i);
//        i = url.indexOf(":");
//        System.out.println(url);
//
//
//
//
//
//

        String[] arr = url.split("://");
        System.out.println(arr[0]);

        url = arr[1];
        arr = url.split("/");
        System.out.println(arr[0]);

        url = arr[1];
        String s = "";
        s = URLEncoder.encode(s,"UTF-8");
        arr = url.split(s);
        System.out.println(arr[0]);



    }
}
