package DMOJ;
import java.util.*;
import java.io.*;
public class NChooseK {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = (int)1e9+7;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		long[][] c = new long[n][k+1]; //c[i][j] = i choose j
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i) {
					c[i][j] = 1;
				} else {
					c[i][j] = (c[i-1][j-1] + c[i-1][j]) % mod;
				}
			}
		}
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		Arrays.sort(a);
		long ans = 0;
		for (int i = k-1; i < n; i++) {
			ans = (ans + (a[i] * c[i][k-1]) % mod) % mod;
		}
		System.out.println(ans);
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
