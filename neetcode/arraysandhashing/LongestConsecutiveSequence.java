package datastructures.src.com.neetcode.arraysandhashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {

    /*    if(nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int count = 1;
        int longest = 1;
        for(int i = 1 ; i < nums.length; i++){
            if((nums[i] - nums[i-1]) == 1){
                count++;
                longest = Math.max(count, longest);
            } else if (nums[i] != nums[i-1]){
                count = 1;
            }
        }
        return longest;*/

        if(nums == null || nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();

        for (int num: nums)
            set.add(num);

        int longest = 0;

        for (int num : set){
            if (!set.contains(num - 1)){
                int currentNum = num;
                int currLength = 1;

                while (set.contains(currentNum + 1)){
                    currentNum++;
                    currLength++;
                }
                longest = Math.max(longest,currLength);
            }
        }
        return longest;
    }
}



