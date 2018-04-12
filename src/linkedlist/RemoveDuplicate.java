package linkedlist;

import java.util.*;

public class RemoveDuplicate {
	public static ListNode revHead = null;
	public static void main(String[] args){

		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);

		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;


		
		
		System.out.println();
		RemoveDuplicate obj = new RemoveDuplicate();
		obj.reverseList(head);

		while(revHead != null){
			System.out.print(revHead.data +" ");
			revHead = revHead.next;
		}
	}
	
	public ListNode reverseList(ListNode head) {

		if(head != null && head.next != null)
		{
			ListNode node = reverseList(head.next);
			node.next = head;
			head.next = null;
			
			System.out.println("Head "+ head.data +" Node " +node.data);
		} else {
			revHead = head;
		}

		return head;


		// node.next = head;

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

	public void removeDups(ListNode node){

		Set<Integer> set = new HashSet<>();
		ListNode ptr = node;
		ListNode prev = null;

		while(ptr != null){

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
