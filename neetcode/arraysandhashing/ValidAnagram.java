package datastructures.src.com.neetcode.arraysandhashing;



public class ValidAnagram {

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		boolean check = isAnagram(s, t);
		System.out.println(check);
	}


	// Bruteforce

	/*
	public static boolean isAnagram(String s, String t) {
		// If the lengths are different, they can't be anagrams
		if (s.length() != t.length()) {
			return false;
		}

		// Convert strings to character arrays and sort them
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		Arrays.sort(sArray);
		Arrays.sort(tArray);

		// Compare sorted arrays
		return Arrays.equals(sArray, tArray);
	}

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";

		if (isAnagram(s, t)) {
			System.out.println(s + " and " + t + " are anagrams.");
		} else {
			System.out.println(s + " and " + t + " are not anagrams.");
		}
	}*/

	static boolean isAnagram(String s, String t) {

		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++)
			alphabet[s.charAt(i) - 'a']++;
		for (int i = 0; i < t.length(); i++)
			alphabet[t.charAt(i) - 'a']--;

		for (int i : alphabet)
			if (i != 0)
				return false;
		
		return true;
	}

}
