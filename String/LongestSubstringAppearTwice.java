package DMOJ;
import java.util.*;
import java.io.*;
public class LongestSubstringAppearTwice {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] hash, pow, hash2, pow2;
	static int mod = (int) (1e9 +7);
	//uses prefix hash array, double hashing technique and binary search for length
	public static void main(String[] args) throws IOException {
		int n = readInt() + 1;
		String str = " " + next();
		hash = new long[n];
		pow = new long[n];
		hash2 = new long[n];
		pow2 = new long[n];
		int seed = 131, seed2 = 71;
		pow[0] = 1; pow2[0] = 1;
		for (int i = 1; i < n; i++) {
			hash[i] = (hash[i-1] * seed + str.charAt(i) - 'a') % mod;
			pow[i] = (pow[i-1] * seed) % mod;
			hash2[i] = (hash2[i-1] * seed2 + str.charAt(i) - 'a') % mod;
			pow2[i] = (pow2[i-1] * seed2) % mod;
		}
		int lo = 0, hi = n-2, ans = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (solve(mid,str,n)) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static boolean solve(int len, String str, int n) {
		if (len == 0) {
			return true;
		}
		HashSet<Long> set = new HashSet<Long>();
		for (int i = 1; i + len <= n; i++) {
			long temp = (hash[i+len-1] - (hash[i-1] * pow[len]) % mod + mod) % mod;
			long temp2 = (hash2[i+len-1] - (hash2[i-1] * pow2[len]) % mod + mod) % mod;
			//combines the two hashed values into one (could also use a pair)
			long combine = temp << 32 | temp2;
			if (set.contains(combine)) {
				return true;
			}
			set.add(combine);
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
