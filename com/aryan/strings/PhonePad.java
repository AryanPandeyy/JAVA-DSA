package com.aryan.strings;

/**
 * PhonePad
 */
public class PhonePad {

	public static void main(String[] args) {
		pad("", "12");
	}

	// 2abc 3def 4ghi 5jkl 6mno 7pqrs 8tuv 9wxyz
	static void pad(String p, String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		int digit = up.charAt(0) - '0'; // convert string number into digit number
		for (int i = (digit - 1) * 3; i < digit * 3; i++) {
			char ch = (char) ('a' + i);
			pad(p + ch, up.substring(1));
		}
	}
}
