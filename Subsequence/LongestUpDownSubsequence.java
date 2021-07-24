package DMOJ;
import java.util.*;
import java.io.*;
public class LongestUpDownSubsequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		int lastSign = 0, len = 1, sign = 0;
		for (int i = 1; i < n; i++) {
			if (array[i] > array[i-1]) {
				sign = 1;
			} else if (array[i] < array[i-1]) {
				sign = -1;
			} else {
				sign = 0;
			}
			if (sign != 0 && sign != lastSign) {
				lastSign = sign;
				len++;
			}
		}
		System.out.println(len);
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
