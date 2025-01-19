package datastructures.src.com.neetcode.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String input = "AABABBA";
        int k = 1;
        System.out.println("Longest length: " + characterReplacement(input, k));
    }

/*
    public static int characterReplacement(String s, int k) {
        int maxLength = 0;

        // Iterate through all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (canTransform(s, i, j, k)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    private static boolean canTransform(String s, int start, int end, int k) {
        int[] charCounts = new int[26]; // Assuming uppercase English letters
        int maxFreq = 0; // Maximum frequency of a single character in the substring

        // Count the frequency of each character in the substring
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            charCounts[c - 'A']++;
            maxFreq = Math.max(maxFreq, charCounts[c - 'A']);
        }

        // Calculate the number of replacements needed
        int totalChars = end - start + 1;
        int replacements = totalChars - maxFreq;

        return replacements <= k;
    }*/


        //optimized
    public static int characterReplacement(String s, int k) {
        int[] charCounts = new int[26];
        int maxFreq = 0;
        int start = 0;
        int maxLength = 0;

        for(int end = 0; end < s.length(); end++){
            char currentChar = s.charAt(end);
            charCounts[currentChar - 'A']++;
            maxFreq = Math.max(maxFreq, charCounts[currentChar - 'A']);

            int windowSize = end - start + 1;
            if(windowSize - maxFreq > k){
                charCounts[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }



}
