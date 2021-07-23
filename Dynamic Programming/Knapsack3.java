import java.util.*;
import java.io.*;
public class Knapsack3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//Time complexity: O(N + W^2logW)
	static int MM = (int)3e4+4;
	static int n, d;
	static int[] w = new int[MM], v = new int[MM];
	static TreeSet<Pair> card[] = new TreeSet[51];
	public static void main(String[] args) throws IOException {
		int f = readInt(); n = readInt(); d = readInt();
		for (int i = 0; i <= 50; i++) {
			card[i] = new TreeSet();
		}
		for (int i = 1; i <= n; i++) {
			w[i] = readInt(); v[i] = readInt();
			card[w[i]].add(new Pair(v[i],i));
		}
		for (int i = 1, a, b, x, y; i <= d; i++) {
			a = readInt(); b = readInt(); x = readInt(); y = readInt();
			card[w[a]].remove(new Pair(v[a],a)); w[a] = b;
			card[w[a]].add(new Pair(v[a],a));
			int[] dp = new int[f+1];
			for (int j = 1; j <= f; j++) {
				int cnt = 0;
				Iterator<Pair> iterator = card[j].descendingIterator(); 
				while (iterator.hasNext() && cnt < f/j) {
					Pair p = iterator.next();
					if (p.s >= x && p.s <= y) {
						cnt++;
						for (int k = f; k >= j; k--) {
							dp[k] = Math.max(dp[k], dp[k-j] + p.f);
						}
					}
				}
			}
			System.out.println(dp[f]);
		}
	}
	static class Pair implements Comparable<Pair> {
		int f, s;
		Pair(int f, int s){
			this.f = f;
			this.s = s;
		}
		public int compareTo(Pair p) {
			return this.f - p.f;
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
