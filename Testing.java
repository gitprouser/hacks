import java.util.*;

public class Testing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i <= lines; i++) {
            sb.append(sc.nextLine() + " ");
        }
        firstThreeOccurances(sb.toString());
    }


    public static String[] firstThreeOccurances(String str) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        CustomComparator<String> comp = new CustomComparator<String>(map);
        TreeMap<String,Integer> revertIdx = new TreeMap<String,Integer>(comp);

        str = str.trim();

        for(String s : str.split(" ")) {
            if (map.containsKey(s)) {
                int val = map.get(s);
                map.put(s, ++val);
            } else
               map.put(s, 1);
        }

        System.out.println("original: " + map);
        revertIdx.putAll(map);
        System.out.println("result: " + revertIdx);
        return null;
    }


    public static class CustomComparator<String> implements Comparator<String> {
        Map<String,Integer> base;

        public CustomComparator(Map<String, Integer> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            // return ((Integer)base.get((String) a) >= (Integer)base.get((String) b))? -1 : 1;
            return (base.get(a) >= base.get(b))? -1 : 1;
        }
    }
}
