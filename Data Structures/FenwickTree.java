import java.util.*;
import java.io.*;
public class FenwickTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] tree;
	static long[] tree2;
	static int n;
	static int maxn;
	public static void main(String[] args) throws IOException {
		n = readInt();
		int m = readInt();
		maxn = (int) (1e5 + 5);
		tree = new long[n+1];
		tree2 = new long[maxn];
		int[] array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int x = readInt();
			array[i] = x;
			add(i,x);
			add2(x,1);
		}
		for (int i = 0; i < m; i++) {
			char ch = readCharacter();
			if (ch == 'C') {
				int x = readInt(), v = readInt();
				int diff = v - array[x];
				add2(array[x],-1);
				add2(v,1);
				add(x,diff);
				array[x] = v;
			} else if (ch == 'S') {
				int l = readInt(), r = readInt();
				System.out.println(sub(r) - sub(l-1));
			} else {
				int v = readInt();
				System.out.println(sub2(v));
			}
		}
	}
	static void add(int i, int x) {
		for (int j = i; j <= n; j += j & (~j+1)) {
			tree[j] += x;
		}
	}
	static void add2(int i, int x) {
		for (int j = i; j <= maxn; j += j & (~j+1)) {
			tree2[j] += x;
		}
	}
	static long sub(int i) {
		long total = 0;
		for (int j = i; j > 0; j -= j & (~j+1)) {
			total += tree[j];
		}
		return total;
	}
	static long sub2(int i) {
		long total = 0;
		for (int j = i; j > 0; j -= j & (~j+1)) {
			total += tree2[j];
		}
		return total;
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
