package collection;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 1);

        map.merge("1", 1, (count, incr) -> count + incr);
        print(map, "1");

        map.merge("3",1, Integer::sum);
        print(map, "3");
    }

    private static void print(Map<String, Integer> map, String key) {
        System.out.println(MessageFormat.format("Key = {0}, Value = {1}", key, map.get(key)));
    }
}
