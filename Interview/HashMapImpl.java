/**
 * Created dgayash on 3/15/17.
 */
public class HashMapImpl {
    private static final int MAX_SIZE_MAP = 1000;  // Hard coded this for now...

    static class HashMap<K, V> {
        EntrySet[] container;

        HashMap() {
            container = new EntrySet[MAX_SIZE_MAP];
        }


        public EntrySet get(K key) {
            return container[key.hashCode() % MAX_SIZE_MAP];
        }

        public void put(K key, V value) {
            EntrySet<K, V> entrySet = container[key.hashCode() % MAX_SIZE_MAP];
            if (entrySet != null) {
                entrySet.next = new EntrySet(key, value);
            } else {
                container[key.hashCode() % MAX_SIZE_MAP] = new EntrySet(key, value);
            }
        }
    }

    static class EntrySet<K, V> {
        K key;
        V value;
        EntrySet next;

        EntrySet(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Hi", "World");
        hashMap.put("Hi", "Dhawan");
        EntrySet entrySet = hashMap.get("Hi");
        while(entrySet != null) {
            System.out.println(entrySet.value);
            entrySet = entrySet.next;
        }
    }
}
