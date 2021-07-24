package DMOJ;
import java.util.*;
import java.io.*;
public class FibonacciSequenceUsingMatrix {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = (int)1e9+7;
	static int logn = 64;
	static long[][][] exponents = new long[logn][2][2];
	public static void main(String[] args) throws IOException {
		long n = Long.parseUnsignedLong(next());
		exponents[0] = new long[][]{{1,1},{1,0}};
		for (int i = 1; i < logn; i++) {
			exponents[i] = multiply(exponents[i-1],exponents[i-1]);
		}
		System.out.println(solve(n-1));
	}
	static long[][] binaryExponentiation(long n){
		long[][] ret = new long[][] {{1,1},{1,0}};
		for (long i = logn-1; i >= 0; i--) {
			if (((n >> i) & 1) == 1) {
				//System.out.println(i + " " + n);
				ret = multiply(ret, exponents[(int)i]);
			}
		}
		return ret;
	}
	static long[][] multiply(long[][] a, long[][] b){
		long[][] ret = new long[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[i].length; k++) {
					ret[i][j] = (ret[i][j] + (a[i][k] * b[k][j]) % mod) % mod;
				}
			}
		}
		return ret;
	}
	static long solve(long n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			long[][] ans = binaryExponentiation(n-1);
			return (ans[0][0]) % mod;
		}
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
