package com.aryan.backtracking;

import java.util.Arrays;

/**
 * AllPaths
 */
public class AllPaths {

	public static void main(String[] args) {

		boolean[][] board = { { true, true, true }, { true, true, true }, { true, true, true } };
		int[][] path = new int[board.length][board[0].length];
		allPathPrint("", board, 0, 0, path, 1);
		// allPathBackTracking("", board, 0, 0);
		// allPath("", board, 0, 0);
	}

	static void allPathBackTracking(String p, boolean[][] maze, int r, int c) {
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			System.out.println(p);
			return;
		}
		if (maze[r][c] == false) {
			return;
		}
		if (r < maze.length - 1) {
			allPath(p + 'D', maze, r + 1, c);
		}
		if (c < maze[0].length - 1) {
			allPath(p + 'R', maze, r, c + 1);
		}
		if (r > 0) {
			allPath(p + 'U', maze, r - 1, c);
		}
		if (c > 0) {
			allPath(p + 'L', maze, r, c - 1);
		}
	}

	static void allPath(String p, boolean[][] maze, int r, int c) {
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			System.out.println(p);
			return;
		}
		if (maze[r][c] == false) {
			return;
		}
		maze[r][c] = false;
		if (r < maze.length - 1) {
			allPath(p + 'D', maze, r + 1, c);
		}
		if (c < maze[0].length - 1) {
			allPath(p + 'R', maze, r, c + 1);
		}
		if (r > 0) {
			allPath(p + 'U', maze, r - 1, c);
		}
		if (c > 0) {
			allPath(p + 'L', maze, r, c - 1);
		}
		// this line is where function will be over
		// so revert back all the changes made during function
		maze[r][c] = true;
	}

	// thought process of backtracking is made a change and then revert it back.

	static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			for (int[] arr : path) {
				path[r][c] = step;
				System.out.println(Arrays.toString(arr));
			}
			System.out.println(p);
			System.out.println();
			return;
		}
		if (maze[r][c] == false) {
			return;
		}
		maze[r][c] = false;
		path[r][c] = step;
		if (r < maze.length - 1) {
			allPathPrint(p + 'D', maze, r + 1, c, path, step + 1);
		}
		if (c < maze[0].length - 1) {
			allPathPrint(p + 'R', maze, r, c + 1, path, step + 1);
		}
		if (r > 0) {
			allPathPrint(p + 'U', maze, r - 1, c, path, step + 1);
		}
		if (c > 0) {
			allPathPrint(p + 'L', maze, r, c - 1, path, step + 1);
		}
		// this line is where function will be over
		// so revert back all the changes made during function
		maze[r][c] = true;
		path[r][c] = 0;
	}
}
