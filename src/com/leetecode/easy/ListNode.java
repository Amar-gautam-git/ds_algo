package com.leetecode.easy;

import java.util.Objects;

public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return this.val; 
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public ListNode getNext() {
		return this.next;
	}

	@Override
	public int hashCode() {
		return Objects.hash(next, val);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListNode other = (ListNode) obj;
		return Objects.equals(next, other.next) && val == other.val;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
	
	
}
