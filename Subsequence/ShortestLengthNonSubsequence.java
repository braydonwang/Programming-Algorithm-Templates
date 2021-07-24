package DMOJ;
import java.util.*;
import java.io.*;
public class ShortestLengthNonSubsequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		//count the number of subarrays that contain every value at least once
		int n = readInt(), m = readInt();
		int[] freq = new int[m+1];
		int total = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int x = readInt();
			freq[x]++;
			if (freq[x] == 1) {
				total++;
			}
			if (total == m) {
				count++;
				total = 0;
				Arrays.fill(freq, 0);
			}
		}
		System.out.println(count+1);
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
