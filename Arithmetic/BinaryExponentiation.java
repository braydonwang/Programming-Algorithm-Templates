package DMOJ;
import java.util.*;
import java.io.*;
public class BinaryExponentiation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
	}
	static long power(long x, long y) {
		long ans = 1, mod = (long) (1e9+7);
		while (y > 0) {
			if (y % 2 != 0) {
				ans = multiply(ans,x,mod);
			}
			x = multiply(x,x,mod);
			y = y/2;
		}
		return ans;
	}
	static long multiply(long a, long b, long k) {
		return ((a % k) * (b % k)) % k;
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
