package DMOJ;
import java.util.*;
import java.io.*;
public class Hashing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[] s = next().toCharArray(), t = next().toCharArray();
		int n = s.length, m = t.length, fs[] = new int[26], ft[] = new int[26];
		for (int i = 0; i < n; i++) {
			fs[s[i]-'a']++;
		}
		long hash[] = new long[m+1], pow[] = new long[m+1], base = 131;
		pow[0] = 1;
		for (int i = 1; i <= m; i++) {
			hash[i] = hash[i-1] * base + t[i-1];
			pow[i] = pow[i-1]*base;
		}
		Set<Long> set = new HashSet();
		for (int i = 1; i <= m; i++) {
			ft[t[i-1]-'a']++;
			if (i < n) {
				continue;
			}
			if (i > n) {
				ft[t[i-n-1]-'a']--;
			}
			if (Arrays.equals(ft, fs)) {
				set.add(getSubstrHash(hash,pow,i-n,i,n));
			}
		}
		System.out.println(set.size());
	}
	static long getSubstrHash(long[] hash, long[] pow, int l, int r, int n) {
		return hash[r] - hash[l]*pow[n];
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
