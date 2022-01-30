import java.util.*;

public class Introduction {

    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        // add
        map.put("daddy", 46);
        map.put("mummy", 45);
        map.put("sister", 24);
        map.put("brother", 17);
        map.put("me", 20);
        System.out.println(map); // {daddy=46, mummy=45, me=20, brother=17, sister=24}

        // update
        map.put("sister", 25);
        System.out.println(map); // {daddy=46, mummy=45, me=20, brother=17, sister=25}

        // get
        int myAge = map.get("me");
        System.out.println(myAge); // 20

        // remove
        map.remove("brother");
        System.out.println(map); // {daddy=46, mummy=45, me=20, sister=25}

        // containsKey
        System.out.println(map.containsKey("brother")); // false
        map.put("brother", 17);
        System.out.println(map.containsKey("brother")); // true

        // keySet
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);// key
            System.out.println(map.get(key));// value
            // daddy
            // 46
            // mummy
            // 45
            // me
            // 20
            // brother
            // 17
            // sister
            // 25
        }
    }

}
