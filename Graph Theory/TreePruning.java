package DMOJ;
import java.util.*;
import java.io.*;
public class TreePruning {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static boolean[] pho;
	static int far;
	static int max;
	static int n;
	static int og;
	public static void main(String[] args) throws IOException {
		n = readInt(); int m = readInt();
		pho = new boolean[n];
		int first = -1;
		for (int i = 0; i < m; i++) {
			int x = readInt();
			if (first == -1) {
				first = x;
			}
			pho[x] = true;
		}
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		dfs(first,-1);
	}
	static boolean dfs(int v, int par) {
		for (int nxt: adj[v]) {
			if (nxt != par) {
				pho[v] |= dfs(nxt,v);
			}
		}
		if (!pho[v]) {
			n--;
		}
		return pho[v];
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
