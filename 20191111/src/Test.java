import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        System.out.println(map.size());
        map.put("abc","xiaoming");
        map.put("bcd","xiaohong");
        map.put("cde","xiaozhang");
        map.put("eft","huahua");
        map.put("huy","xiaofang");

        String str = map.get("abc");
        System.out.println(str);

        str = map.getOrDefault("xyr","mingming");
        System.out.println(str);

        System.out.println(map.containsKey("abc"));
        System.out.println(map.containsValue("mingming"));

        System.out.println(map.isEmpty());
        System.out.println(map);

        

    }


    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        collection.add("d");
        collection.add("e");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println(collection);

        collection.remove("a");
        System.out.println(collection.size());
        System.out.println(collection);

        for (String s:collection) {
            System.out.println(s);
        }

        collection.clear();
        System.out.println(collection.size());
    }
}
