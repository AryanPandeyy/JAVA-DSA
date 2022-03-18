package com.aryan.strings;

import java.util.ArrayList;

/**
 * SubSeq
 */
public class SubSeq {

	public static void main(String[] args) {
		// subseq("", "abc");
		// System.out.println(subseqRet("", "abc"));
		// subseqAscii("", "abc");
		System.out.println(subseqAsciiRet("", "abc"));
	}

	static void subseq(String p, String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch = up.charAt(0);
		subseq(p + ch, up.substring(1));
		subseq(p, up.substring(1));
	}

	static ArrayList<String> subseqRet(String p, String up) {
		if (up.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		char ch = up.charAt(0);
		ArrayList<String> left = subseqRet(p + ch, up.substring(1));
		ArrayList<String> right = subseqRet(p, up.substring(1));
		left.addAll(right);
		return left;
	}

	static void subseqAscii(String p, String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch = up.charAt(0);
		subseqAscii(p + ch, up.substring(1));
		subseqAscii(p, up.substring(1));
		subseqAscii(p + (ch + 0), up.substring(1)); // ch+0 to get ascii value of char
	}

	static ArrayList<String> subseqAsciiRet(String p, String up) {
		if (up.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		char ch = up.charAt(0);
		ArrayList<String> first = subseqAsciiRet(p + ch, up.substring(1));
		ArrayList<String> second = subseqAsciiRet(p, up.substring(1));
		ArrayList<String> third = subseqAsciiRet(p + (ch + 0), up.substring(1));
		first.addAll(second);
		first.addAll(third);
		return first;
	}

	// 2abc 3def 4ghi 5jkl 6mno 7pqrs 8tuv 9wxyz
}
// Subset != permutation
// str = "abc"
// ans = ['a', 'b', 'c', 'ab', 'ac', 'bc', 'abc']
// here 'ca' wont make sense,it will be under permutation not in subset
// subset is for array & subsequence is for strings
// pattern :- taking few elements and ignoring few elments
// take one element in one function and ignore in another function
// take two string/array one is unprocessed and other is processed
