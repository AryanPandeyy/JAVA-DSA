package com.aryan.arrays;

import java.util.ArrayList;

/**
 * Sorted
 */
public class Sorted {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 4, 4, 9 };
		// System.out.println(sorted(arr, 0));
		// System.out.println(find(arr, 4, 0));
		// System.out.println(findIndex(arr, 4, 0));
		// System.out.println(findIndexLast(arr, 4, arr.length - 1));
		// findAllIndex(arr, 4, 0);
		// System.out.println(list);
		// ArrayList<Integer> list = findAllIndex(arr, 4, 0, new ArrayList<>());
		// System.out.println(list);
		System.out.println(findAllInder2(arr, 4, 0));
	}

	static boolean sorted(int[] arr, int index) {
		if (index == arr.length - 1) {
			return true;
		}
		return arr[index] < arr[index + 1] && sorted(arr, index + 1);
	}

	static boolean find(int[] arr, int target, int index) {
		if (index == arr.length) {
			return false;
		}
		return arr[index] == target || find(arr, target, index + 1);
	}

	static int findIndex(int[] arr, int target, int index) {
		if (index == arr.length) {
			return -1;
		}
		if (arr[index] == target) {
			return target;
		} else {
			return findIndex(arr, target, index + 1);
		}
	}

	static int findIndexLast(int[] arr, int target, int index) {
		if (index == -1) {
			return -1;
		}
		if (arr[index] == target) {
			return target;
		} else {
			return findIndexLast(arr, target, index - 1);
		}
	}

	static ArrayList<Integer> list = new ArrayList<>();

	static void findAllIndex(int[] arr, int target, int index) {
		if (index == arr.length) {
			return;
		}
		if (arr[index] == target) {
			list.add(index);
		}
		findAllIndex(arr, target, index + 1);
	}

	// returning arraylist and passing it through argument
	static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
		if (index == arr.length) {
			return list;
		}
		if (arr[index] == target) {
			list.add(index);
		}
		return findAllIndex(arr, target, index + 1, list);
	}

	static ArrayList<Integer> findAllInder2(int[] arr, int target, int index) {
		ArrayList<Integer> list = new ArrayList<>();
		if (index == arr.length) {
			return list;
		}
		// this will contain ans for that function call only
		if (arr[index] == target) {
			list.add(index);
		}
		ArrayList<Integer> ansFromBelowCalls = findAllInder2(arr, target, index + 1);
		// answer that im getting from belows will get add
		list.addAll(ansFromBelowCalls);
		return list;
	}
}
