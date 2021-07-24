package DMOJ;
import java.util.*;
import java.io.*;
public class MatrixMultiplication {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = (int)1e9+7;
	static int logn = 64;
	static long[][][] exponents;
	static int n;
	public static void main(String[] args) throws IOException {
		//read input
		
		for (int i = 1; i < logn; i++) {
			exponents[i] = multiply(exponents[i-1],exponents[i-1]);
		}
		
		//do binary exponentiation or quick power?
	}
	static long[][] multiply(long[][] a, long[][] b){
		long[][] ret = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					ret[i][j] = (ret[i][j] + (a[i][k]*b[k][j]) % mod) % mod;
				}
			}
		}
		return ret;
	}
	static long[][] binaryExponentiation(long k){
		long[][] ret = exponents[0];
		for (int i = logn-1; i >= 0; i--) {
			if (((k >> i) & 1) == 1) {
				ret = multiply(ret,exponents[i]);
			}
		} 
		return ret;
	}
	static long[][] quick_pow(long[][] a, long exp){
		if (exp == 1) {
			return a;
		}
		long[][] temp = quick_pow(a,exp/2);
		temp = multiply(temp,temp);
		if (exp % 2 == 0) {
			return temp;
		}
		return multiply(temp,a);
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
