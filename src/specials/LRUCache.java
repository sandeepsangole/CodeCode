package specials;

/*
146. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting
 a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity  );

	cache.put(1, 1);
	cache.put(2, 2);
	cache.get(1);       // returns 1
	cache.put(3, 3);    // evicts key 2
	cache.get(2);       // returns -1 (not found)
	cache.put(4, 4);    // evicts key 1
	cache.get(1);       // returns -1 (not found)
	cache.get(3);       // returns 3
	cache.get(4);       // returns 4
	

*/

import java.util.*;

class LRUCache {

	Map<Integer, LRUNode> map = new HashMap<>();
	int capacity;

	LRUNode head;
	LRUNode tail;

	LRUCache(int c) {
		this.capacity = c;
	}

	public int get(int key) {

		if (map.containsKey(key)) {
			LRUNode node = map.get(key);
			
			remove(node);
			setHead(node);
			return node.value;

		}

		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			LRUNode old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
			map.put(key, old);

		} else {
			LRUNode newNode = new LRUNode(key, value);
			if (map.size() >= capacity) {
				map.remove(tail.key);
				remove(tail);
				setHead(newNode);
				
			}  else {
				setHead(newNode);
			}
			map.put(key, newNode);

		}
	}

	public void setHead(LRUNode node) {
		
		node.next = head;
		node.prev = null;
		
		if(head != null){
			head.prev = node;
		}
		head = node;
		
		if(tail == null){
			tail = head;
		}
	}

	public void remove(LRUNode node) {

		if(node == null){
			return;
		}

		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;


		}

	}
}

class LRUNode {
	int     key;
	int     value;
	LRUNode prev;
	LRUNode next;

	LRUNode(int key, int value) {
		this.value = value;
		this.key = key;
	}

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

