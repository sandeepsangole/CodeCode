package linkedlist;

import java.util.Stack;

public class PalindromeLinkedList {

	/*
		1->2->3->2-1
		      s     f

	 */
	public static void main(String[] args) {


	}

	public boolean isPalindrome(ListNode head){

		ListNode fast = head;
		ListNode slow = head;
		Stack<Integer> stack = new Stack<>();
		while (fast != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if(fast != null){
			slow = slow.next;
		}

		while (slow != null){
			if(stack.pop() != slow.data){
				return false;
			}
			slow = slow.next;
		}

		return true;
	}


}
