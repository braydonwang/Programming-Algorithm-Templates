package DMOJ;
import java.util.*;
import java.io.*;
public class KnapsackSegmentTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] tree = new int[(int)1e5][51];
	static int f, n, d;
	static int[] c, v;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		f = readInt(); n = readInt(); d = readInt();
		for (int i = 0; i < 1e5; i++) {
			Arrays.fill(tree[i], -1);
			tree[i][0] = 0;
		}
		c = new int[n+1]; v = new int[n+1];
		for (int i = 1; i <= n; i++) {
			c[i] = readInt(); v[i] = readInt();
		}
		build(1,1,n);
		for (int i = 0; i < d; i++) {
			int a = readInt(), b = readInt(), x = readInt(), y = readInt();
			update(1,1,n,a,b);
			ans = new int[51];
			query(1,1,n,x,y);
			int max = 0;
			for (int j = 1; j <= f; j++) {
				max = Math.max(max,ans[j]);
			}
			//System.out.println(Arrays.toString(ans));
			System.out.println(max);
		}
	}
	static void push2(int[] a1, int[] a2) {
		for (int i = f; i >= 1; i--) {
			for (int j = 0; j <= i; j++) {
				if (a1[i-j] != -1 && a2[j] != -1) {
					a1[i] = Math.max(a1[i], a1[i-j] + a2[j]);
				}
			}
		}
	}
	static void query(int pos, int l, int r, int ll, int rr) {
		if (l > rr || r < ll) {
			return;
		} else if (ll <= l && r <= rr) {
			push2(ans,tree[pos]);
			return;
		}
		int mid = (l + r) / 2;
		query(pos*2,l,mid,ll,rr); query(pos*2+1,mid+1,r,ll,rr);
	}
	static void update(int pos, int l, int r, int x, int v) {
		if (r < x || l > x) {
			return;
		} else if (l == x && r == x) {
			int num = tree[pos][c[l]];
			tree[pos][c[l]] = 0;
			tree[pos][v] = num;
			c[l] = v;
			return;
		}
		int mid = (l + r) / 2;
		update(pos*2,l,mid,x,v); update(pos*2+1,mid+1,r,x,v);
		push(pos);
	}
	static void push(int pos) {
		for (int i = f; i >= 1; i--) {
			tree[pos][i] = -1;
			for (int j = 0; j <= i; j++) {
				if (tree[pos*2][i-j] != -1 && tree[pos*2+1][j] != -1) {
					tree[pos][i] = Math.max(tree[pos][i], tree[pos*2][i-j] + tree[pos*2+1][j]);
				}
			}
		}
	}
	static void build(int pos, int l, int r) {
		if (l == r) {
			tree[pos][c[l]] = v[l];
			return;
		}
		int mid = (l + r) / 2;
		build(pos*2,l,mid); build(pos*2+1,mid+1,r);
		push(pos);
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
