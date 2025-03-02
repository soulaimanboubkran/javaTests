package algos.LeetCode;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;
    //to get the data by O(1)
    private Map<Integer,LinkedListNode> cache;
    // to remove and update in O(1)
    private LinkedList<LinkedListNode> lruList;

    private class LinkedListNode {
        int key;
        int value;
        
        LinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        lruList = new LinkedList<>();
    }
    
    public  int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        // Get the node and move it to the front (most recently used)
        LinkedListNode node = cache.get(key);
        lruList.remove(node);
        lruList.addFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
         // If key exists, update value and move to front
        if(cache.containsKey(key)){
            LinkedListNode node = cache.get(key);
            node.value = value;
            lruList.remove(node);
            lruList.addFirst(node);
            return;
        }
        // If at capacity, remove least recently used
        if(cache.size() == capacity){
            LinkedListNode lruNode = lruList.removeLast();
            cache.remove(lruNode.key);
            
        }

        // Add new node to front
        LinkedListNode newNode  = new LinkedListNode(key, value);
        lruList.addFirst(newNode);
        cache.put(key, newNode);

    }
}
