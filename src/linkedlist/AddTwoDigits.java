package linkedlist;

public class AddTwoDigits {

	public static void main(String[] args) {


	}
	/*

		h
		2-4-3
		h
		5-6-4

		c
	 */

	public ListNode add(ListNode node1 , ListNode node2){

		ListNode newHead = new ListNode(0);
		ListNode ptr = newHead;

		int carry = 0;

		while(node1 != null && node2 != null){

			if(node1 != null){
				carry += node1.data;
				node1 = node1.next;
			}

			if(node2 != null){
				carry += node2.data;
				node2 = node2.next;
			}

			ptr.next = new ListNode(carry%10);
			carry = carry / 10;
			ptr = ptr.next;
		}

		if (carry == 1){
			ptr.next = new ListNode(carry);
		}

		return newHead.next;
	}
}
