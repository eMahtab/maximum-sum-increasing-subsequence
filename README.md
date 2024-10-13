# Maximum Sum Increasing Subsequence
## https://www.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
Given an non-empty array of integers, write a function that returns an array of length 2. The first element in the output array should be an integer value representing the greatest sum that can be generated from a strictly-increasing subsequence in the array. The second element should be an array of the numbers in that subsequence. 

A subsequence is defined as a set of numbers that are not necessarily adjacent but that are in the same order as they appear in the array. Assume that there will only be one increasing subsequence with the greatest sum.

e.g.

Input: [10, 70, 20, 30, 50, 11, 30]

Output: [[110], [10, 20, 30, 50]]


```java
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

```
