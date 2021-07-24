package DMOJ;
import java.util.*;
import java.io.*;
public class NumberOfSubarraysWithMedianGreaterThanK {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] bit;
	static int maxn = (int)1e5+10;
	public static void main(String[] args) throws IOException {
		int n = readInt(), l = readInt();
		bit = new int[maxn];
		Pair[] pre = new Pair[n+1];
		pre[0] = new Pair(0,0);
		for (int i = 1; i <= n; i++) {
			int x = readInt();
			pre[i] = new Pair(0,i);
			if (x >= l) {
				pre[i].val++;
			} else {
				pre[i].val--;
			}
			pre[i].val += pre[i-1].val;
		}
		Arrays.sort(pre);
		long ans = 0;
		for (int i = 0; i <= n; i++) {
			ans += query(pre[i].ind);
			update(pre[i].ind,1);
		}
		System.out.println(ans);
	}
	static void update(int x, int v) {
		x += 5;
		for (int i = x; i <= maxn; i+=i&-i) {
			bit[i] += v;
		}
	}
	static int query(int x) {
		x += 5;
		int total = 0;
		for (int i = x; i > 0; i -= i&-i) {
			total += bit[i];
		}
		return total;
	}
	static class Pair implements Comparable<Pair>{
		int val, ind;
		Pair(int val, int ind){
			this.val = val;
			this.ind = ind;
		}
		public int compareTo(Pair p) {
			return this.val - p.val;
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
