package DMOJ;
import java.util.*;
import java.io.*;
public class DifferenceArray {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		int[] d = new int[n+2];
		for (int i = 1; i <= n; i++) {
			d[i] = array[i] - array[i-1];
		}
		int q = readInt();
		for (int i = 0; i < q; i++) {
			int l = readInt(), r = readInt(), x = readInt();
			d[l] += x;
			d[r+1] -= x;
		}
		for (int i = 1; i <= n; i++) {
			array[i] = d[i] + array[i-1];
			System.out.print(array[i] + " ");
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
