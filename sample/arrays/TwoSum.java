package datastructures.src.com.sample.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] arr = { 1, 6, 4, 2 };
		int k = 8;
		int[] sum = getPairsCount(arr, k);
		System.out.println(Arrays.toString(sum));
	}

	static int[] getPairsCount(int[] arr,  int k) {


//		for (int i = 0; i < nums.length; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if (nums[j] == target - nums[i]) {
//					return new int[] { i, j };
//				}
//			}
//		}
//		// If no valid pair is found, return an empty array instead of null
//		return new int[] {};

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(k - arr[i])) {
				return new int[] {  map.get(k - arr[i]) , i};
			}

			map.put(arr[i], i);
		}

		return new int[0];

	}

}
