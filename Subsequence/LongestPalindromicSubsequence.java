package DMOJ;
import java.util.*;
import java.io.*;
public class LongestPalindromicSubsequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String str = next();
		//in o(n) space rather than o(n^2)
		int[] dp = new int[n];
		for (int i = n-1; i >= 0; i--) {
			int backup = 0;
			for (int j = i; j < n; j++) {
				if (i == j) {
					dp[j] = 1;
				} else if (str.charAt(i) == str.charAt(j)) {
					int temp = dp[j];
					dp[j] = backup + 2;
					backup = temp;
				} else {
					backup = dp[j];
					dp[j] = Math.max(dp[j-1],dp[j]);
				}
			}
		}
		System.out.println(dp[n-1]);
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
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
