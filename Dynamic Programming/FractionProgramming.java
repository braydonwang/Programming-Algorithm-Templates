package DMOJ;
import java.util.*;
import java.io.*;
public class FractionProgramming {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] w, t;
	static int n, b;
	public static void main(String[] args) throws IOException {
		n = readInt(); b = readInt();
		w = new int[n]; t = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = readInt(); t[i] = readInt() * 1000;
		}
		int lo = 1, hi = (int)1e6, ans = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (solve(mid)) {
				lo = mid + 1;
				ans = mid;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static boolean solve(int mid) {
		long[] v = new long[n];
		for (int i = 0; i < n; i++) {
			v[i] = t[i] - 1L * mid * w[i];
		}
		long[] dp = new long[b+1];
		Arrays.fill(dp, (long) -1e9);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = b; j >= 0; j--) {
				int k = Math.min(b, j+w[i]);
				dp[k] = Math.max(dp[k], dp[j] + v[i]);
			}
		}
		if (dp[b] >= 0) {
			return true;
		}
		return false;
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
