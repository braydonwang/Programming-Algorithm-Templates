package DMOJ;
import java.util.*;
import java.io.*;
public class SegTreeMaxSubarraySumInRange {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] array;
	static Tree[] tree;
	static int maxn = (int) 3e5;
	static int min = (int) -1e9;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		array = new long[n+1]; tree = new Tree[maxn];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		Arrays.fill(tree, new Tree(0,min,min,min));
		construct(1,n,1);
		for (int i = 0; i < q; i++) {
			char ch = readCharacter();
			int l = readInt(), r = readInt();
			if (ch == 'S') {
				update(1,n,l,r,1);
			} else {
				//System.out.println(tree[5].maxSum);
				System.out.println(range(l,r,1,n,1).maxSum);
			}
		}
    }
	static Tree range(int lo, int hi, int l, int r, int pos) {
		Tree result = new Tree(0,min,min,min);
		if (l >= lo && r <= hi) {
			return tree[pos];
		} else if (r < lo || l > hi) {
			return result;
		}
		int mid = (l + r) / 2;
		if (lo > mid) {
			return range(lo,hi,mid+1,r,pos*2+1);
		} 
		if (r <= mid){
			return range(lo,hi,l,mid,pos*2);
		}
		Tree left = range(lo,hi,l,mid,pos*2);
		Tree right = range(lo,hi,mid+1,r,pos*2+1);
		long a = left.sum + right.sum;
		long b = Math.max(left.preSum, left.sum + right.preSum);
		long c = Math.max(right.sufSum, right.sum + left.sufSum);
		long d = Math.max(result.preSum,Math.max(result.sufSum, Math.max(left.maxSum, Math.max(right.maxSum, left.sufSum + right.preSum))));
		result = new Tree(a,b,c,d);
		return result;
	}
	static void update(int l, int r, int x, int v, int pos) {
		if (l == r) {
			tree[pos] = new Tree(v,v,v,v);
			return;
		} 
		int mid = (l + r) / 2;
		if (x <= mid) {
			update(l,mid,x,v,pos*2);
		} else {
			update(mid+1,r,x,v,pos*2+1);
		}
		//System.out.println("HI");
		build(pos);
	}
	static void build(int pos) {
		long a = tree[pos*2].sum + tree[pos*2+1].sum;
		long b = Math.max(tree[pos*2].preSum, tree[pos*2].sum + tree[pos*2+1].preSum);
		long c = Math.max(tree[pos*2+1].sufSum, tree[pos*2+1].sum + tree[pos*2].sufSum);
		long d = Math.max(b,Math.max(c, Math.max(tree[pos*2].maxSum, Math.max(tree[pos*2+1].maxSum, tree[pos*2].sufSum + tree[pos*2+1].preSum))));
		tree[pos] = new Tree(a,b,c,d);
		//System.out.println(pos + " " + tree[pos].sum + " " + tree[pos].preSum + " " + tree[pos].sufSum + " " + tree[pos].maxSum + " " + tree[pos*2].sufSum + " " + tree[pos*2+1].preSum);
	}
	static void construct(int l, int r, int pos) {
		//System.out.println(l + " " + r);
		if (l == r) {
			tree[pos] = new Tree(array[l],array[l],array[l],array[l]);
			return;
		} 
		int mid = (l + r) / 2;
		construct(l,mid,pos*2); construct(mid+1,r,pos*2+1);
		build(pos);
	}
	static class Tree{
		long sum, preSum, sufSum, maxSum;
		Tree(long sum, long preSum, long sufSum, long maxSum){
			this.sum = sum;
			this.preSum = preSum;
			this.sufSum = sufSum;
			this.maxSum = maxSum;
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
