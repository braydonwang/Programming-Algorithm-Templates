package DMOJ;
import java.util.*;
import java.io.*;
public class CheckIfDirectedGraphIsAcyclic {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean flag;
	static int[] vis;
	static int n;
	static int[][] array;
	public static void main(String[] args) throws IOException {
		n = readInt();
		flag = false;
		array = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = readInt();
			}
		}
		vis = new int[n];
		for (int i = 0; i < n; i++) {
			if (vis[i] == 0) {
				dfs(i);
				if (flag) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
	}
	static void dfs(int v) {
		vis[v] = 1;
		for (int i = 0; i < n; i++) {
			if (vis[i] != 2 && array[v][i] == 1) {
				if (vis[i] == 1) {
					flag = true;
					return;
				} else {
					dfs(i);
				}
			}
		}
		vis[v] = 2;
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
