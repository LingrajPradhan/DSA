package datastructures.src.com.neetcode.twopointer;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {1, -1, -1, 0};


        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }



    public static List<List<Integer>> threeSum(int[] nums) {

        //bruteforce
/*        Set<List<Integer>> triplets = new HashSet<>(); // Use a set to store unique triplets
        int n = nums.length;

        // Triple nested loops to find all triplets
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        // Create a sorted triplet to ensure uniqueness
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(triplets); // Convert the set to a list*/


        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            // avoid duplicate for first number
            if(i >0 && nums[i] == nums[i-1])
                continue;

            int target = -nums[i];
            int front = i + 1;
            int back = nums.length - 1;

            while(front < back){
                int sum = nums[front] + nums[back];

                if(sum < target){
                    front++;
                }else if(sum > target){
                    back--;
                }else {
                    // found triplet
                    res.add(Arrays.asList(nums[i],nums[front], nums[back]));
                    // avoid duplicate for second number
                    while (front < back && nums[front] == nums[back - 1]){
                        front++;
                    }
                    //avoid duplicate for third number
                    while (front < back && nums[back] == nums[back - 1]){
                        back--;
                    }

                    front++;
                    back--;
                }
            }
        }
        return res;
    }
}

