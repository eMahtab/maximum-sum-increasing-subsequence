package net.mahtabalam;

public class Test {
	public static void main(String[] args) {
		int[] arr1 = {1};
		System.out.println("Result 1 ->"+MSIS.maxSumIncreasingSubsequence(arr1));
		int[] arr2 = {-1};
		System.out.println("Result 2 ->"+MSIS.maxSumIncreasingSubsequence(arr2));
		int[] arr3 = {-1, 1};
		System.out.println("Result 3 ->"+MSIS.maxSumIncreasingSubsequence(arr3));
		int[] arr4 = {1, -1};
		System.out.println("Result 4 ->"+MSIS.maxSumIncreasingSubsequence(arr4));
		int[] arr5 = {28, 10, 20, 11, 10, 15, -1, 5};
		System.out.println("Result 5 ->"+MSIS.maxSumIncreasingSubsequence(arr5));
		int[] arr6 = {-5, -4, -3, -2, -1, -10};
		System.out.println("Result 6 ->"+MSIS.maxSumIncreasingSubsequence(arr6));
		int[] arr7 = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
		System.out.println("Result 7 ->"+MSIS.maxSumIncreasingSubsequence(arr7));
	}
}
