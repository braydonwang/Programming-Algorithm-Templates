package DMOJ;
import java.util.*;
import java.io.*;
public class LazyPropagation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] tree, lazy;
	static int maxn = (int) 6e6;
	//the question is asking you to do two queries:
	//1. increment every value from l to r by v
	//2. print the largest sum subarray length k with its first element between the range of l and r
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt(), q = readInt();
		tree = new long[maxn]; lazy = new long[maxn];
		for (int i = 0; i < q; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			if (a == 0) {
				b++;
				update(1,n,Math.max(1, b-k+1),b,1,c);
				//System.out.println(Arrays.toString(tree));
			} else {
				b++; c++;
				System.out.println(range(1,n,b,Math.min(c, n),1));
			}
		}
	}
	static long range(int l, int r, int lo, int hi, int pos) {
		if (lazy[pos] != 0) {
			tree[pos] += lazy[pos];
			lazy[pos*2] += lazy[pos];
			lazy[pos*2+1] += lazy[pos];
			lazy[pos] = 0;
		}
		if (r < lo || l > hi) {
			return 0;
		} else if (lo <= l && hi >= r) {
			return tree[pos];
		}
		int mid = (l + r) / 2;
		return Math.max(range(l,mid,lo,hi,pos*2), range(mid+1,r,lo,hi,pos*2+1));
	}
	static long update(int l, int r, int lo, int hi, int pos, int val) {
		if (lazy[pos] != 0) {
			tree[pos] += lazy[pos];
			lazy[pos*2] += lazy[pos];
			lazy[pos*2+1] += lazy[pos];
			lazy[pos] = 0;
		}
		if (r < lo || l > hi) {
			return tree[pos];
		} else if (lo <= l && hi >= r) {
			tree[pos] += val;
			lazy[pos*2] += val;
			lazy[pos*2+1] += val;
			return tree[pos];
		}
		int mid = (l + r) / 2;
		return tree[pos] = Math.max(update(l,mid,lo,hi,pos*2,val), (update(mid+1,r,lo,hi,pos*2+1,val)));
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
