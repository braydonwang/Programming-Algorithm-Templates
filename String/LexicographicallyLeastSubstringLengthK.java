package DMOJ;
import java.util.*;
import java.io.*;
public class LexicographicallyLeastSubstringLengthK {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] hash, pow;
	public static void main(String[] args) throws IOException {
		String str = " " + next();
		int n = str.length();
		int k = readInt();
		hash = new long[n];
		pow = new long[n];
		int seed = 131;
		pow[0] = 1;
		for (int i = 1; i < n; i++) {
			hash[i] = hash[i-1] * seed + str.charAt(i);
			pow[i] = pow[i-1] * seed;
		}
		int ans = 1;
		for (int i = 2; i + k <= n; i++) {
			int lo = 0, hi = k-1, first = hi; //first = first point of difference
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (getSubHash(ans,ans+mid) == getSubHash(i,i+mid)) {
					lo = mid + 1;
				} else {
					first = mid;
					hi = mid - 1;
				}
			}
			if (str.charAt(ans+first) > str.charAt(i+first)) {
				ans = i;
			}
		}
		System.out.println(str.substring(ans,ans+k));
	}
	static long getSubHash(int l, int r) {
		return hash[r] - hash[l-1] * pow[r-l+1];
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
