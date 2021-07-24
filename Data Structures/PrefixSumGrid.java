package DMOJ;
import java.util.*;
import java.io.*;
public class PrefixSumGrid {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int w = readInt(), h = readInt(), n = readInt();
		int[][] array = new int[h+1][w+1];
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				array[i][j] = readInt();
			}
		}
		int[][] pre = new int[h+1][w+1];
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				pre[i][j] = array[i][j] + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
			}
		}
		int max = 0;
		for (int j = 1; j <= h; j++) {
			int i = n / j;
			if (i != 0) {
				for (int r = 1; r <= h-j+1; r++) {
					for (int c = 1; c <= w-i+1; c++) {
						max = Math.max(max, pre[r+j-1][c+i-1] - pre[r+j-1][c-1] - pre[r-1][c+i-1] + pre[r-1][c-1]);
					}
					max = Math.max(max, pre[r+j-1][Math.min(w,i)] - pre[r+j-1][0] - pre[r-1][Math.min(w, i)] + pre[r-1][0]);
				}
			}
		}
		System.out.println(max);
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
