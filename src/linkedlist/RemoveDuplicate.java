package linkedlist;

import java.util.*;

public class RemoveDuplicate {

	public static void main(String[] args) {

	}

	public void removeDuplicate(ListNode node){

		Set<Integer> set = new HashSet<>();
		ListNode ptr = node;
		ListNode prev = null;

		while (ptr != null){
			if(set.contains(ptr.data)){
				prev.next = ptr.next;
			} else {
				set.add(ptr.data);
				prev = ptr;
			}
			ptr = ptr.next;
		}
	}
}
