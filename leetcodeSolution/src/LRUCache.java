import java.util.*;

public class LRUCache extends LinkedHashMap {

	private FixedSizeLinkedHashMap<Integer, Integer> lruCache;

	public LRUCache(int capacity) {
		lruCache = new FixedSizeLinkedHashMap<Integer, Integer>(capacity);
	}

	public int get(int key) {
		return lruCache.get(key) != null ? lruCache.get(key) : -1;
	}

	public void set(int key, int value) {
		lruCache.put(key, value);
	}

	public class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
		private int MAX_ENTRIES;

		public FixedSizeLinkedHashMap(int capacity) {
			super(16, 0.75f, true);
			MAX_ENTRIES = capacity;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry eldest) {
			return size() > MAX_ENTRIES;
		}
	}
}
