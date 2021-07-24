package DMOJ;
import java.util.*;
import java.io.*;
public class LongestPalindromicSubstring {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String str = next();
		boolean[][] dp = new boolean[n+1][n+1];
		int max = 1;
		for (int i = 1; i <= n-1; i++) {
			dp[i][i] = true;
			if (str.charAt(i-1) == str.charAt(i)) {
				dp[i][i+1] = true;
				max = 2;
			}
		}
		for (int l = 3; l <= n; l++) {
			for (int i = 1; i <= n-l+1; i++) {
				int j = i + l - 1;
				if (dp[i+1][j-1] && str.charAt(i-1) == str.charAt(j-1)) {
					dp[i][j] = true;
					max = l;
				}
			}
		}
		System.out.println(max);
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
