package com.aryan.problems.recursion;

import java.util.ArrayList;
import java.util.List;

// if the sum of the number becomes greater than target itself then move to the
// next element
// pick- if the sum is less than target
// not pick - sum is more than target, move the index
/**
 * combinationSum
 */
public class combinationSum {
	public static void main(String[] args) {
		int[] candidates = { 2, 3, 5, 7 };
		System.out.println(combinationSum(candidates, 7));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		backTrack(ans, candidates, 7, list, 0);
		return ans;
	}

	public static void backTrack(List<List<Integer>> ans, int[] candidates, int target, List<Integer> list, int index) {
		if (index == candidates.length) {
			if (target == 0) {
				List<Integer> p = new ArrayList<Integer>();
				p.addAll(list);
				ans.add(p);
			}
			return;
		}
		// pick
		if (candidates[index] <= target) {
			list.add(candidates[index]);
			backTrack(ans, candidates, target - candidates[index], list, index);
			list.remove(list.size() - 1);
		}
		// not pick
		backTrack(ans, candidates, target, list, index + 1);
	}
}
