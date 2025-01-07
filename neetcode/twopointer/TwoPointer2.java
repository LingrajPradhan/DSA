package datastructures.src.com.neetcode.twopointer;

public class TwoPointer2 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15}; // Example input array
        int target = 9;             // Example target value

        try {
            int[] result = twoSumTwo(nums, target); // Call the twoSum method
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int[] twoSumTwo(int[] nums, int target) {

                int low = 0;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[low] + nums[high];

                    if (sum == target) {
                        return new int[]{low + 1, high + 1};
                    } else if (sum < target) {
                        ++low;
                    } else {
                        --high;
                    }
                }
                // In case there is no solution, return {-1, -1}.
                return new int[]{-1, -1};
            }


}
