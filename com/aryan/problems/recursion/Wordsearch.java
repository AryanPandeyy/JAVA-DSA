package com.aryan.problems.recursion;

/**
 * Wordsearch
 */
// This problem does not give start position, or direction restriction, so
// Scan board, find starting position with matching word first letter
// From starting position, DFS (4 (up, down, left, right 4 directions) match
// word's rest letters
// For each visited letter, mark it as visited, here use board[i][j] = '*' to
// represent visited.
// If one direction cannot continue, backtracking, mark start position
// unvisited, mark board[i][j] = word[start]
// If found any matching, terminate
// Otherwise, no matching found, return false.
public class Wordsearch {
	public static void main(String[] args) {
	}

	public boolean exist(char[][] board, String word) {
		if (board == null || word == null)
			return false;
		if (word.length() == 0)
			return true;
		if (board.length == 0)
			return false;
		int rows = board.length;
		int cols = board[0].length;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				// scan board, start with word first character
				if (board[r][c] == word.charAt(0)) {
					if (helper(board, word, r, c, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean helper(char[][] board, String word, int r, int c, int start) {
		if (start == word.length()) {
			return true;
		}
		if (!isValid(board, r, c) || board[r][c] != word.charAt(start)) {
			return false;
		}
		board[r][c] = '*';
		boolean res = helper(board, word, r + 1, c, start + 1) || helper(board, word, r - 1, c, start + 1)
				|| helper(board, word, r, c - 1, start + 1) || helper(board, word, r, c + 1, start + 1);
		board[r][c] = word.charAt(0);
		return res;
	}

	private boolean isValid(char[][] board, int r, int c) {
		return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
	}
	// https://github.com/azl397985856/leetcode/blob/master/problems/79.word-search-en.md

}
