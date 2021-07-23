import java.util.*;
import java.io.*;
public class KnapsackPowerOf2Bins {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		int[] p = new int[n];
		long[] s = new long[n];
		for (int i = 0; i < n; i++) {
			p[i] = readInt(); s[i] = readInt();
		}
		long[] dp = new long[k+1];
		for (int i = 0; i < n; i++) {
			for (int j = p[i]; j <= k; j++) {
				dp[j] = Math.max(dp[j], dp[j-p[i]] + s[i]);
			}
		}
		for (int i = 0; i < m; i++) {
			int q = readInt(), t = readInt()-1, d = readInt(), a = readInt();
			for (int x = 1; x <= a; x <<= 1){
				for (int j = k; j >= d * x; j--) {
					dp[j] = Math.max(dp[j], dp[j - d * x] + s[t] * x * q);
				}
				a -= x;
			}
			if (a == 0) continue;
			for (int j = k; j >= d * a; j--) {
				dp[j] = Math.max(dp[j], dp[j - d * a] + s[t] * a * q);
			}
		}
		System.out.println(dp[k]);
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
