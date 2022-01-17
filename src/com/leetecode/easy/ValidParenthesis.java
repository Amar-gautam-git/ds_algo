package com.leetecode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {

	public static void main(String[] args) {
		System.out.println(isValid2("()[]{}"));
	}

	public static boolean isValid(String s) {
		int opsCount = 0;
		int opmCount = 0;
		int opbCount = 0;
		char[] p = s.toCharArray();
		for (int j = 0; j < p.length; j++) {

			switch (p[j]) {
			case '{':
				opmCount++;
				break;
			case '}':
				opmCount--;
				break;
			case '[':
				opbCount++;
				break;
			case ']':
				opbCount--;
				break;
			case '(':
				opsCount++;
				break;
			case ')':
				opsCount--;
				break;

			}

		}

		return opsCount == 0 && opmCount == 0 && opbCount == 0 ? true : false;

	}

	public static boolean isValid2(String s) {
		char nextP;
		char[] p = s.toCharArray();
		for (int j = 0; j < p.length;) {
			nextP = getNextParenthesis(p[j]);
			if (nextP == p[j + 1] && j <= p.length - 2) {
				j = j + 2;
			} else {
				return false;
			}
		}

		return true;

	}

	public static boolean isValid3(String expr) {
		// Using ArrayDeque is faster than using Stack class
		Deque<Character> stack = new ArrayDeque<Character>();

		// Traversing the Expression
		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				// Push the element in the stack
				stack.push(x);
				continue;
			}

			// If current character is not opening
			// bracket, then it must be closing. So stack
			// cannot be empty at this point.
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// Check Empty Stack
		return (stack.isEmpty());

	}

	private static char getNextParenthesis(char c) {
		switch (c) {
		case '{':
			return '}';
		case '[':
			return ']';
		case '(':
			return ')';

		}
		return ' ';
	}
}