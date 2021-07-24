package DMOJ;
import java.util.*;
import java.io.*;
public class TwoDifferenceArray {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n+2];
		int[] diff = new int[n+2], diff2 = new int[n+2];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		int q = readInt();
		for (int i = 0; i < q; i++) {
			int l = readInt(), r = readInt(), val = readInt();
			diff2[l+1]++; diff2[r+1]--;
			diff[l] += val; diff[r+1] -= (val + (r-l));
		}
		for (int i = 1; i <= n; i++) {
			diff2[i] += diff2[i-1];
		}
		for (int i = 1; i <= n; i++) {
			diff[i] += diff[i-1] + diff2[i];
			System.out.print(diff[i] + " ");
		}
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
