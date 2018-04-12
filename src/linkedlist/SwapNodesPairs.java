package linkedlist;

/*
24. Swap Nodes in Pairs


For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, 
only nodes itself can be changed.

 */
public class SwapNodesPairs {

	public static void main(String[] args){

		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
	
		head.next = l1;
		l1.next = l2;
		l2.next = l3;


		System.out.println();

		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
	}
	
}
