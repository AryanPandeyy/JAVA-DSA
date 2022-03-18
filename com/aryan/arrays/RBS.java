package com.aryan.arrays;

/**
 * RBS
 */
public class RBS {

	public static void main(String[] args) {

	}

	static int search(int[] arr, int target, int s, int e) {
		if (s > e) {
			return -1;
		}
		int mid = s + (s - e) / 2;
		if (arr[mid] == target) {
			return mid;
		}
		if (arr[s] <= arr[mid]) {
			if (target >= arr[s] && target <= arr[m]) {
				search(arr, target, s, mid - 1);
			} else {
				return search(arr, target, mid + 1, e);
			}
		}
		if (target >= arr[m] && target <= arr[e]) {
			return search(arr, target, mid + 1, e);
		}
		return search(arr, target, s, mid - 1);
	}
}
