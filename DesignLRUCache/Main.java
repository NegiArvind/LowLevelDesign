public class Main {

    public static void main(String[] args) {

        LRUCache<String, String> lruCache = new LRUCache<>(3);

        lruCache.put("1", "1");
        lruCache.printAllNode();

        lruCache.put("2", "2");
        lruCache.printAllNode();

        lruCache.put("3", "3");
        lruCache.printAllNode();

        System.out.println(lruCache.get("2"));
        lruCache.printAllNode();

        lruCache.put("4", "4");
        lruCache.printAllNode();

        lruCache.put("5", "5");
        lruCache.printAllNode();

        System.out.println(lruCache.get("5"));
        lruCache.printAllNode();

    }

}
