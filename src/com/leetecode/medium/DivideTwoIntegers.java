package com.leetecode.medium;

/*
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 */

public class DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(division(-214748364, 2));
	}

	public static int division(int dividend, int divisor) {
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		 ;
		 
		 
		return divide(dividend, divisor, 0) * sign;
	}

	private static int divide(long dividend, int divisor, int quotient) {
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		if (dividend > divisor) {
			dividend = dividend - divisor;
			quotient = quotient + 1;
			return divide(dividend, divisor, quotient);
		} else {
			return quotient;
		}
	}

}
