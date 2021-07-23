import java.util.*;
import java.io.*;
public class SegmentTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] tree;
	static int[] array;
	static int maxn = (int)3e5;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		tree = new int[maxn][3];
		array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		construct(1,n,1);
		for (int i = 0; i < m; i++) {
			char ch = readCharacter();
			if (ch == 'C') {
				int x = readInt(), v = readInt();
				update(1,n,1,x,v);
				array[x] = v;
			} else if (ch == 'M') {
				int l = readInt(), r = readInt();
				System.out.println(query(1,n,1,l,r,0,0));
			} else if (ch == 'G') {
				int l = readInt(), r = readInt();
				System.out.println(query(1,n,1,l,r,1,0));
			} else {
				int l = readInt(), r = readInt();
				System.out.println(query(1,n,1,l,r,2,query(1,n,1,l,r,1,0)));
			}
		}
	}
	static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
	static void push(int node) {
		tree[node][0] = Math.min(tree[node*2][0], tree[node*2+1][0]);
		tree[node][1] = gcd(tree[node*2][1],tree[node*2+1][1]);
		tree[node][2] = 0;
		if (tree[node][1] == tree[node*2][1]) {
			tree[node][2] += tree[node*2][2];
		}
		if (tree[node][1] == tree[node*2+1][1]) {
			tree[node][2] += tree[node*2+1][2];
		}
	}
	static void construct(int l, int r, int node) {
		if (l == r) {
			tree[node][0] = tree[node][1] = array[l];
			tree[node][2] = 1;
			return;
		}
		int mid = (l + r) / 2;
		construct(l,mid,node*2); construct(mid+1,r,node*2+1);
		push(node);
	}
	static void update(int l, int r, int node, int ind, int value) {
		if (l > ind || r < ind) {
			return;
		} else if (l == r && l == ind) {
			tree[node][0] = tree[node][1] = value;
			tree[node][2] = 1;
			return;
		}
		int mid = (l + r) / 2;
		update(l,mid,node*2,ind,value); update(mid+1,r,node*2+1,ind,value);
		push(node);
	}
	static int query(int l, int r, int node, int ll, int rr, int num, int temp) {
		if (l > rr || r < ll) {
			if (num == 0) {
				return Integer.MAX_VALUE;
			} else {
				return 0;
			}
		} else if (ll <= l && r <= rr) {
			if (num == 2) {
				if (tree[node][1] == temp) {
					return tree[node][num];
				} else {
					return 0;
				}
			} else {
				return tree[node][num];
			}
		}
		int mid = (l + r) / 2;
		if (num == 0) {
			return Math.min(query(l,mid,node*2,ll,rr,num,temp), query(mid+1,r,node*2+1,ll,rr,num,temp));
		} else if (num == 1) {
			return gcd(query(l,mid,node*2,ll,rr,num,temp), query(mid+1,r,node*2+1,ll,rr,num,temp));
		} else {
			return query(l,mid,node*2,ll,rr,num,temp) + query(mid+1,r,node*2+1,ll,rr,num,temp);
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
