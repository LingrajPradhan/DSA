package datastructures.src.com.neetcode.twopointer;

public class ValidPalindrome {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";

		System.out.println(isPalindrome(s));

	}

	static boolean isPalindrome(String s) {

//		 StringBuilder content = new StringBuilder();
//	        for(int i = 0; i < s.length(); i++) 
//	            if(Character.isLetterOrDigit(s.charAt(i)))
//	                content.append(s.charAt(i));
//	        content = new StringBuilder(content.toString()
//	        		.replace(" ", "").toLowerCase());
//	        String value = content.toString();
//	        return value.equals(content.reverse().toString());

//		// Clean the input string
//		StringBuilder cleaned = new StringBuilder();
//		for (char c : s.toCharArray()) {
//			if (Character.isLetterOrDigit(c)) {
//				cleaned.append(Character.toLowerCase(c));
//			}
//		}
//
//		// Check if the cleaned string is a palindrome
//		String original = cleaned.toString();
//		String reversed = cleaned.reverse().toString();
//		return original.equals(reversed);

		if (s.isEmpty()) {
			return true;
		}

		int head = 0;
		int tail = s.length() - 1;

		char cHead, cTail;

		while (head <= tail) {
			cHead = s.charAt(head);
			cTail = s.charAt(tail);

			if (!Character.isLetterOrDigit(cHead)) {
				head++;
			} else if (!Character.isLetterOrDigit(cTail)) {
				tail--;
			} else {
				if (Character.toLowerCase(cHead) 
						!= Character.toLowerCase(cTail)) {
					return false;
				}
				head++;
				tail--;
			}
		}
		return true;
	}

}
