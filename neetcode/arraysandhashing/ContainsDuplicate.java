package datastructures.src.com.neetcode.arraysandhashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = { 3, 6, 4, 2, 9, 6 };
		boolean res = checkDuplicate(nums);
		System.out.println(res);

	}

	static boolean checkDuplicate(int[] nums) {

		// bruteforce O(n^2)
		/*
		 * boolean check = false;
		 * 
		 * for (int i = 0; i < nums.length; i++)
		 * { for (int j = i + 1; j < nums.length; j++)
		 *  {
		 * if (nums[i] == nums[j]) {
		 * check = true; }
		 *  } }
		 * 
		 * return check; }
		 */

//		//O(nlogn)
		boolean check = false;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-1; i++) {

            if (nums[i] == nums[i + 1]) {
                check = true;
                break;
            }
		}

		return check;

/*		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			if (set.contains(num))
				return true;
			set.add(num);
		}
		return false;*/

	}
}
