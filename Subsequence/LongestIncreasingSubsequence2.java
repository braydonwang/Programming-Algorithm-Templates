package DMOJ;
import java.util.*;
import java.io.*;
public class LongestIncreasingSubsequence2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n];
		int[] end = new int[n+1];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		int len = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] < end[1]) {
				end[1] = array[i];
			} else if (array[i] > end[len]) {
				len++;
				end[len] = array[i];
			} else {
				int temp = find(array[i],1,len+1,end);
				end[temp] = array[i];
			}
		}
		System.out.println(len);
	}
	static int find(int num, int l, int r, int[] end) {
		while (r-l > 1) {
			int mid = (l + r) / 2;
			if (num <= end[mid]) {
				r = mid;
			} else {
				l = mid;
			}
		}
		return r;
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
