package preparation.lrucache;

import java.util.HashMap;

class Entry {
    int key;
    int val;
    Entry left;
    Entry right;
    public Entry(int key, int val){
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class LruCache {

    HashMap<Integer, Entry> hashMap;
    Entry start, end;
    int LRU_CACHE_SIZE = 4;

    public LruCache() {
        this.hashMap = new HashMap<>();
    }

    public int get(int key) {
        if(hashMap.containsKey(key)) {
            Entry entry = hashMap.get(key);
            removeNode(entry);
            addToTop(entry);
            return entry.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        if(hashMap.containsKey(key)) {
            Entry entry = hashMap.get(key);
            entry.val = val;
            removeNode(entry);
            addToTop(entry);
        } else {
            Entry entry = new Entry(key,val);
            if(hashMap.size() == LRU_CACHE_SIZE) {
                hashMap.remove(end.key);
                removeNode(end);
                addToTop(entry);
            }else  {
                addToTop(entry);
            }

            hashMap.put(key, entry);
        }

    }
    public void addToTop(Entry entry) {
        entry.right = start;
        entry.left = null;
        if(start != null) {
            start.left = entry;
        }
        start = entry;
        if(end == null) {
            end = start;
        }
    }
    public void removeNode(Entry entry) {
            if(entry.left != null) {
                entry.left.right = entry.right;
            }else {
                start = entry.right;
            }

            if(entry.right != null) {
                entry.right.left = entry.left;
            }else {
                end = entry.left;
            }
    }

    public static void main(String[] args) {
        LruCache lrucache = new LruCache();
        lrucache.put(1, 1);
        lrucache.put(10, 15);
        lrucache.put(15, 10);
        lrucache.put(10, 16);
        lrucache.put(12, 15);
        lrucache.put(18, 10);
        //lrucache.put(13, 16);
        lrucache.put(15, 150);

        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(15));
    }
}
