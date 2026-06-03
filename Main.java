public class Main {
    public static void main(String[] args) {
        LRUCache<Integer,String> cache = new LRUCache<>(3);
        System.out.println("Adding 1:A");
        cache.put(1,"A");
        System.out.println("Adding 2 : B");
        cache.put(2,"B" );
        System.out.println("Adding 3 : C");
        cache.put(3,"C");
        System.out.println("Cache after adding 3 items:" + "A,B,C");
        System.out.println(cache.get(1));
        System.out.println("Adding 4 : D");
        cache.put(4, "D");
        System.out.println("Cache after adding 4th item(2:B is removed):"+cache.get(2));
        System.out.println("new fix " + cache.get(1));


    }
}