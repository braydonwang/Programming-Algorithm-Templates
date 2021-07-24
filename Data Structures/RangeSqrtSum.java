package DMOJ;
import java.util.*;
import java.io.*;
public class RangeSqrtSum {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] a;
	static Node[] tree;
	public static void main(String[] args) throws IOException {
		//the key idea is that numbers reach 1 very quickly after a few number of square roots
		//when the number is 1, you do not have to consider updating it anymore
		//because sqrt(1) = 1
		//the list pretty much stores all indexes of elements that have a value greater than 1
		//algorithms: segment tree, binary search
		int n = readInt();
		tree = new Node[(int)2e6];
		a = new int[n+1];
		ArrayList<Integer> list = new ArrayList();
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
			if (a[i] > 1) {
				list.add(i);
			}
		}
		Collections.sort(list);
		build(1,1,n);
		int m = readInt();
		for (int i = 0; i < m; i++) {
			int x = readInt(), l = readInt(), r = readInt();
			if (x == 1) {
				System.out.println(query(1,l,r));
			} else {
				int left = l;
				while (true) {
					int lo = 0, hi = list.size()-1, ans = -1, idx = -1;
					while (lo <= hi) {
						int mid = (lo + hi) / 2;
						int temp = list.get(mid);
						if (temp >= left) {
							ans = temp; idx = mid;
							hi = mid - 1;
						} else {
							lo = mid + 1;
						}
					}
					if (ans > r || ans == -1) {
						break;
					}
					update(1,ans,(int)Math.sqrt(a[ans])-a[ans]);
					a[ans] = (int)Math.sqrt(a[ans]);
					
					if (a[ans] == 1) {
						list.remove(idx);
					}
					left = ans + 1;
				}
			}
		}
	}
	static int build(int pos, int l, int r) {
		tree[pos] = new Node(l,r,0);
		if (l == r) {
			tree[pos].val = a[l];
			return tree[pos].val;
		}
		int mid = (l + r) / 2;
		return tree[pos].val = build(pos*2,l,mid) + build(pos*2+1,mid+1,r);
	}
	static int update(int pos, int ind, int x) {
		int l = tree[pos].l, r = tree[pos].r;
		if (l > ind || r < ind) {
			return tree[pos].val;
		} else if (l == ind && r == ind) {
			tree[pos].val += x;
			return tree[pos].val;
		} else if (l <= ind && r >= ind) {
			tree[pos].val -= x;
		}
		return tree[pos].val = update(pos*2,ind,x) + update(pos*2+1,ind,x);
	}
	static int query(int pos, int ll, int rr) {
		int l = tree[pos].l, r = tree[pos].r;
		if (l > rr || r < ll) {
			return 0;
		} else if (l >= ll && r <= rr) {
			return tree[pos].val;
		}
		return query(pos*2,ll,rr) + query(pos*2+1,ll,rr);
	}
	static class Node{
		int l, r, val;
		Node(int l, int r, int val){
			this.l = l;
			this.r = r;
			this.val = val;
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
