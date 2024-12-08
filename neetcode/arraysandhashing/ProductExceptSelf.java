package datastructures.src.com.neetcode.arraysandhashing;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);

        // Print the result array
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

/*    private static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++){
            int product = 1 ;

            for (int j = 0; j <n ; j++){
                if (i != j)
                    product *= nums[j];
            }
            result[i] = product;
        }

        return result;
    }*/


    // prefix & suffix product

/*    private static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int [] pre = new int[n];
        int [] suff = new int[n];
        pre[0] = 1;
        suff[n-1] = 1;

        // prefix product
        for (int i = 1; i < n; i++){
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        // suffix product
        for (int i = n - 2; i >=0; i--){
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0 ; i < n; i++){
            ans[i] = pre[i] * suff[i];
        }

        return ans;
    }*/

    // optimized space complexity

    private static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int prefix = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }
        return ans;
    }

/*    Explanation:

    We use a single array ans initialized to 1.
    In the first loop, we iterate from left to right:
    prefix stores the product of all elements before the current index.
    For each i, we set ans[i] = ans[i] * prefix (initially ans[i] = 1, so effectively ans[i] = prefix).
    Then we update prefix *= nums[i] to include the current element for the next iteration.
    After the first loop, ans[i] holds the product of all elements to the left of i.
    In the second loop, we do a similar process from right to left using a suffix variable.
    For each i, ans[i] is multiplied by suffix, which is the product of all elements to the right of i.
    Update suffix *= nums[i].
    This way, ans[i] ends up being the product of all elements except nums[i], without using separate prefix/suffix arrays.
    Dry Run Example: nums = [1, 2, 3, 4]

    Initialization:

    ans = [1, 1, 1, 1]
    prefix = 1
    First loop (prefix):

    i = 0:
    ans[0] = ans[0] * prefix = 1 * 1 = 1
    prefix = prefix * nums[0] = 1 * 1 = 1
    i = 1:
    ans[1] = ans[1] * prefix = 1 * 1 = 1
    prefix = prefix * nums[1] = 1 * 2 = 2
    i = 2:
    ans[2] = ans[2] * prefix = 1 * 2 = 2
    prefix = prefix * nums[2] = 2 * 3 = 6
    i = 3:
    ans[3] = ans[3] * prefix = 1 * 6 = 6
    prefix = prefix * nums[3] = 6 * 4 = 24
    Now ans = [1, 1, 2, 6]. This matches the prefix products we had before (each ans[i] is product of elements to the left).

    Second loop (suffix):
    suffix = 1
    i = 3:
    ans[3] = ans[3] * suffix = 6 * 1 = 6
    suffix = suffix * nums[3] = 1 * 4 = 4
    i = 2:
    ans[2] = ans[2] * suffix = 2 * 4 = 8
    suffix = suffix * nums[2] = 4 * 3 = 12
    i = 1:
    ans[1] = ans[1] * suffix = 1 * 12 = 12
    suffix = suffix * nums[1] = 12 * 2 = 24
    i = 0:
    ans[0] = ans[0] * suffix = 1 * 24 = 24
    suffix = suffix * nums[0] = 24 * 1 = 24
    Final ans = [24, 12, 8, 6]

    Time Complexity:

    One pass for prefix products: O(n)
    One pass for suffix products: O(n)
    Total: O(n).
    Space Complexity:

    We only use the ans array (output) and a few variables (prefix, suffix), no additional arrays of size n.
    Extra space: O(1) (if we don’t count the output array).*/


}
