package specials;

public class LRUCacheMain {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(2,1);
		cache.put(1,1);
		System.out.println(cache.get(2));
		cache.put(4,1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		
		
	}
}
