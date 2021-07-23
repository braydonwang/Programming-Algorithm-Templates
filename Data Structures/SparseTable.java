import java.util.*;
import java.io.*;
public class SparseTable {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][][] s;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		s = new int[n+1][17][2];
		for (int i = 1; i <= n; i++) {
			s[i][0][0] = s[i][0][1] = readInt();
		}
		for (int i = 1; 1 << i <= n; i++) {
			for (int j = 1; j + (1 << i) - 1 <= n; j++) {
				s[j][i][0] = Math.max(s[j][i-1][0], s[j+(1 << (i-1))][i-1][0]);
				s[j][i][1] = Math.min(s[j][i-1][1], s[j+(1 << (i-1))][i-1][1]);
			}
		}
		for (int i = 0; i < q; i++) {
			int l = readInt(), r = readInt();
			System.out.println(get(l,r,0) - get(l,r,1));
		}
	}
	static int get(int l, int r, int ind) {
		int size = (int)(Math.log(r-l+1) / Math.log(2));
		if (ind == 0) {
			return Math.max(s[l][size][0], s[r-(1 << size)+1][size][0]);
		} else {
			return Math.min(s[l][size][1], s[r-(1 << size)+1][size][1]);
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
