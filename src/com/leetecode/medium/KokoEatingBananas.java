package com.leetecode.medium;

import java.util.Arrays;

public class KokoEatingBananas {

	public static void main(String[] args) {
		System.out.println(minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
	}

	public static int minEatingSpeed(int[] piles, int h) {

		if (piles.length == h) {
			Arrays.sort(piles);
			return piles[piles.length - 1];
		}

		// minimum one banana
		int left = 1;
		// Maximum banana in an hour
		int right = Arrays.stream(piles).max().getAsInt();

		while (left < right) {
			int mid = (left + right) / 2;
			int total = 0;
			for (int i = 0; i < piles.length; i++) {
				total += (piles[i] + mid - 1) / mid;
				System.out.println(total);
				if (total > h) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}

		}

		return right;
	}

	public static int minEatingSpeed2(int[] piles, int h) {

		if (piles.length == h) {
			Arrays.sort(piles);
			return piles[piles.length - 1];
		}

		// minimum one banana
		int left = 1;
		// Maximum banana in an hour
		int right = Arrays.stream(piles).max().getAsInt();

		while (left < right) {
			int mid = left + (right - left ) / 2;
			for (int i = 0; i < piles.length; i++) {
				if (checkSpeed(piles, mid, h)) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

		}

		return right;
	}
	
	private static boolean checkSpeed(int piles[], int mid, int h) {
		int time = 0;
		for (int i = 0; i < piles.length; i++) {
			if (piles[i] % mid != 0) {
				time += ((piles[i] / mid) + 1);
			} else {
				time += piles[i] / mid;
			}
		}

		if (time <= h) {
			return true;
		} else {
			return false;
		}
	}
}