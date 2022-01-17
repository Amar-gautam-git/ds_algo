package com.leetecode.easy;

public class PlusOne {

	public static void main(String[] args) {
		int[] result = plus2(new int[] { 9,9,9});
		for (int i = 0; i < result.length; i++) {
			int j = result[i];
			System.out.println("index :: " + i + "element ::" + j);
		}
	}

	public static int[] plusOne(int[] digits) {
		StringBuilder sum = new StringBuilder();

		for (int i = 0; i < digits.length; i++) {
			sum.append(digits[i]);
		}
		System.out.println(Integer.MAX_VALUE);
		Integer total = Integer.parseInt(sum.toString()) + 1;

		String newSum = Integer.toString(total);
		System.out.println(newSum);
		char[] arr = newSum.toCharArray();
		int[] plusOne = new int[newSum.toCharArray().length];
		for (int i = 0; i < plusOne.length; i++) {
			plusOne[i] = Character.getNumericValue(arr[i]);
		}

		return plusOne;

	}

	public static int[] plus1(int[] digits) {

		for (int i = digits.length - 1; i >= 0;) {
			if (digits[i] != 9) {
				digits[i] = digits[i] + 1;
				return digits;
			} else {
				int carry = 0;
				int z = digits.length ;
				while (z != 0) {
					System.out.println(z);
					if(digits[z-1] == 9) {
						digits[z-1] = 0;
						carry = 1;
					} else if(carry == 1) {
						digits[z-1] = digits[z-1] + 1;
						carry = 0;
					} else {
						
					}
					z--;
				}
				return digits;
			}

		}

		return digits;

	}
	
	public static int[] plus2(int[] digits) {
        
	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++; return digits;
	        }
	        digits[i] = 0;
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    return newNumber;
	}
}
