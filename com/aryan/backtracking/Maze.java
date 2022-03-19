package com.aryan.backtracking;

import java.util.ArrayList;

/**
 * Maze
 */
public class Maze {

	public static void main(String[] args) {
		// System.out.println(count(3, 3));
		// path("", 3, 3);
		// System.out.println(pathRet("", 3, 3));
		boolean[][] board = { { true, true, true }, { true, false, true }, { true, true, true } };
		pathRestrictions("", board, 0, 0);
	}

	static int count(int r, int c) {
		if (r == 1 || c == 1) {
			return 1;
		}
		int left = count(r - 1, c);
		int right = count(r, c - 1);
		return left + right;
	}

	static void path(String p, int r, int c) {
		if (r == 1 && c == 1) {
			System.out.println(p);
			return;
		}
		if (r > 1) {
			path(p + 'D', r - 1, c);
		}
		if (c > 1) {
			path(p + 'R', r, c - 1);
		}
	}

	static ArrayList<String> pathRet(String p, int r, int c) {
		if (r == 1 && c == 1) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		ArrayList<String> list = new ArrayList<>();
		if (r > 1) {
			list.addAll(pathRet(p + 'D', r - 1, c));
		}
		if (c > 1) {
			list.addAll(pathRet(p + 'R', r, c - 1));
		}
		return list;
	}

	static ArrayList<String> pathRetDiagonal(String p, int r, int c) {
		if (r == 1 && c == 1) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		ArrayList<String> list = new ArrayList<>();
		if (r > 1) {
			list.addAll(pathRetDiagonal(p + 'D', r - 1, c));
		}
		if (c > 1) {
			list.addAll(pathRetDiagonal(p + 'R', r, c - 1));
		}
		return list;
	}

	static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			System.out.println(p);
			return;
		}
		if (maze[r][c] == false) {
			return;
		}
		if (r < maze.length - 1) {
			System.out.println(maze.length);
			System.out.println(maze[0].length);
			pathRestrictions(p + 'D', maze, r + 1, c);
		}
		if (c < maze[0].length - 1) {
			pathRestrictions(p + 'R', maze, r, c + 1);
		}
	}
}
