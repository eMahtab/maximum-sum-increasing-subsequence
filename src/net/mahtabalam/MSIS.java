package net.mahtabalam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MSIS {

	public static List<List<Integer>> maxSumIncreasingSubsequence(int[] nums) {
		if(nums == null || nums.length == 0) {
			return new ArrayList<List<Integer>>();
		}
		int length = nums.length;
		int[] dpTable = nums.clone();
		int[] sequence = new int[length];
		Arrays.fill(sequence, Integer.MIN_VALUE);
		int maxSumIndex = 0;
		
		for(int i = 1; i < length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && dpTable[j] + nums[i] > dpTable[i] ) {
					dpTable[i] = dpTable[j] + nums[i];
					sequence[i] = j;
				}
			}
			if(dpTable[i] > dpTable[maxSumIndex]) {
				maxSumIndex = i;
			}
		}
		
		List<List<Integer>> result = buildSequence(nums, sequence, maxSumIndex, dpTable[maxSumIndex]);
		return result;
	}

	public static List<List<Integer>> buildSequence(int[] nums, int[] sequence, int maxSumIndex, int maxSum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());
		List<Integer> subsequence = new ArrayList<Integer>();
		list.add(subsequence);
		list.get(0).add(maxSum);
		while(maxSumIndex != Integer.MIN_VALUE) {
			list.get(1).add(0, nums[maxSumIndex]);
			maxSumIndex = sequence[maxSumIndex];
		}
		return list;
	}
}
