package linkedlist;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

	/*
			1->6->9
			h

			5->7->10
	      h
	 */

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(10);
	}

	public ListNode mergeKList(ListNode[] list){

		if(list== null || list.length == 0){
			return null;
		}

		PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode l1 , ListNode l2) -> l1.data - l2.data);

		ListNode head = new ListNode(0);
		ListNode p = head;

		for (ListNode node : list){
			if(node != null)
				pq.offer(node);
		}

		while (!pq.isEmpty()){
			ListNode n = pq.poll();
			p.next = n;
			p = p.next;
			if(n.next != null)
			pq.offer(n.next);
		}

		return head.next;
	}
}
