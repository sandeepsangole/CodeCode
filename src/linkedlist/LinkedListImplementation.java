package linkedlist;

import java.util.List;

public class LinkedListImplementation {

	ListNode head = null;

	/*

		null->1->2->3->4->5->6->7->null
		 p  <-h<-n  t

	 */

	/*
     Implement algoritham to find the kth to last element of singly linked list
  */
	public ListNode nthToLast(ListNode head, int k) {

		ListNode ptr1 = head;
		ListNode ptr2 = head;

		for (int i =0;i<k;i++){
			if(ptr1 == null){
				return null;
			}
			ptr1 = ptr1.next;
		}


		while (ptr1 != null){
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		return ptr2;
		
	}

	public ListNode reverseLinkedList(ListNode head) {

		ListNode prev = null;
		ListNode next = head.next;

		while(next != null) {

			ListNode tmp = next.next;
			head.next = prev;
			next.next = head;

			prev = head;
			head = next;
			next = tmp;

		}

		return head;
	}


	public void addNode(int n){

		if(head == null){
			head = new ListNode(n);
		} else {
			ListNode ptr = head;

			ListNode prev = null;

			while (ptr != null){
				ptr = ptr.next;
				prev = ptr;
			}

			prev.next = new ListNode(n);

		}
	}

	public void printList(){
		ListNode ptr = head;
		while (ptr != null){
			System.out.print(ptr.data +" ");
			ptr = ptr.next;
		}
	}
}
