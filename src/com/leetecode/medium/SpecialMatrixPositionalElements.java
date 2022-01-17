package com.leetecode.medium;

public class SpecialMatrixPositionalElements {

	public static void main(String[] args) {
		int a[][] = new int[][] { { 1, 3, 4 }, { 5, 2, 9 }, { 8, 7, 6 } };
		int m = 3, n = 3;
		System.out.println(countPositional(a, m, n));
	}

	public static int countPositional(int[][] arr, int m, int n) {

		int rowMax[] = new int[m];
		int rowMin[] = new int[m];
		int colMax[] = new int[n];
		int colMin[] = new int[n];

		for (int i = 0; i < m; i++) {
			int rMax = Integer.MIN_VALUE;
			int rMin = Integer.MAX_VALUE;

			for (int j = 0; j < n; j++) {
				if (arr[i][j] > rMax) {
					rMax = arr[i][j];
				}

				if (arr[i][j] < rMin) {
					rMin = arr[i][j];
				}
			}
			rowMax[i] = rMax;
			rowMin[i] = rMin;
		}

		for (int j = 0; j < n; j++) {
			int cMin = Integer.MAX_VALUE;
			int cMax = Integer.MIN_VALUE;

			for (int i = 0; i < m; i++) {
				if (arr[i][j] > cMax) {
					cMax = arr[i][j];
				}
				if (arr[i][j] < cMin) {
					cMin = arr[i][j];
				}
			}
			colMax[j] = cMax;
			colMin[j] = cMin;
		}

		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == rowMax[i] || arr[i][j] == rowMin[i] || arr[i][j] == colMax[j]
						|| arr[i][j] == colMin[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
