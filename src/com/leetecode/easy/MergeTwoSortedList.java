package com.leetecode.easy;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1, null);
		ListNode l2 = new ListNode(3, null);
		ListNode l3 = new ListNode(4, null);
		l1.setNext(l2);
		l2.setNext(l3);
		ListNode l4 = new ListNode(1, null);
		ListNode l5 = new ListNode(2, null);
		ListNode l6 = new ListNode(4, null);
		l4.setNext(l5);
		l5.setNext(l6);
		// System.out.println(l1);
		// System.out.println(l4);
		ListNode combined = mergeTwoLists(l1, l4);
		System.out.println(combined);

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {


		ListNode mergedHead;

		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}

		if (list1.getVal() >= list2.getVal()) {
			mergedHead = list2;
			list2 = list2.getNext();
		} else {
			mergedHead = list1;
			list1 = list1.getNext();
		}

		ListNode mergedTail = mergedHead;
		System.out.println("mergedTail  s " + mergedTail);

		while (list1 != null && list2 != null) {
			ListNode temp = null;
			if (list1.getVal() <= list2.getVal()) {
				temp = list1;
				list1 = list1.getNext();
			} else {
				temp = list2;
				list2 = list2.getNext();
			}
			mergedTail.setNext(temp);
			mergedTail = temp;
			System.out.println("mergedTail  " + mergedTail);
		}

		if (list1 != null) {
			mergedTail.setNext(list1);
			
		} else if (list2 != null) {
			mergedTail.setNext(list2);
		}
		return mergedHead;
	}
}
