package datastructures.src.com.neetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LSWRC {
    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length of the longest substring: " + lengthOfLongestSubstring(input));
    }

   /* public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        // Iterate through all possible starting points
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    // Helper function to check if all characters in the substring are unique
    private static boolean allUnique(String s, int start, int end) {
        boolean[] charSet = new boolean[128]; // Assuming ASCII
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (charSet[c]) {
                return false; // Character already exists
            }
            charSet[c] = true;
        }
        return true;
    }*/


    //optimised

    public static int lengthOfLongestSubstring(String s) {


        Set<Character> set = new HashSet<>();

        int left = 0;
        int ans = 0;

        for(int right = 0; right < s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, right-left + 1);
        }

        return ans;

    }
}
