package com.leetecode.easy;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
 */

public class LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] { "a" }));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 1 || strs[0].length() == 0) {
			return strs[0];
		}
		StringBuilder commonPrefix = new StringBuilder(strs[0]);
		for (int i = 0; i < strs.length; i++) {
			if (i < strs.length - 1) {
				commonPrefix = compareTwoString(commonPrefix.toString(), strs[i+1]);
			}

		}
		return commonPrefix.toString();
	}

	private static StringBuilder compareTwoString(String s1, String s2) {
		StringBuilder commonPrefix = new StringBuilder();
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		int len = ch1.length < ch2.length ? ch1.length : ch2.length;
		for (int i = 0; i < len; i++) {
			if (ch1[i] == ch2[i]) {
				commonPrefix.append(ch1[i]);
			} else {
				break;
			}

		}
		return commonPrefix;
	}
}
