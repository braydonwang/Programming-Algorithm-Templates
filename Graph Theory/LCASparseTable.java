package DMOJ;
import java.util.*;
import java.io.*;
public class LCAUsingSparseTable {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Edge> adj[];
	static int[] e;
	static int[] lvl;
	static int[] h;
	static boolean[] vis;
	static long[] dis;
	static int ind = 0;
	static int[][][] s;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		adj = new ArrayList[n];
		e = new int[2*n-1];
		lvl = new int[2*n-1];
		h = new int[n];
		dis = new long[n];
		vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt(), w = readInt();
			adj[a].add(new Edge(b,w));
			adj[b].add(new Edge(a,w));
		}
		dfs(0,0,0);
		s = new int[2*n-1][18][2];
		for (int i = 0; i < 2*n-1; i++) {
			s[i][0][0] = lvl[i];
			s[i][0][1] = i;
		}
		for (int i = 1; 1 << i < 2*n-1; i++) {
			for (int j = 0; j + (1 << i) - 1 < 2*n-1; j++) {
				if (s[j][i-1][0] < s[j+(1 << (i-1))][i-1][0]) {
					s[j][i][0] = s[j][i-1][0];
					s[j][i][1] = s[j][i-1][1];
				} else {
					s[j][i][0] = s[j+(1 << (i-1))][i-1][0];
					s[j][i][1] = s[j+(1 << (i-1))][i-1][1];
				}
			}
		}
		int q = readInt();
		for (int i = 0; i < q; i++) {
			int u = readInt(), v = readInt();
			int par = 0;
			if (h[u] < h[v]) {
				par = get(h[u],h[v]);
			} else {
				par = get(h[v],h[u]);
			}
			System.out.println(dis[u] + dis[v] - 2*dis[e[par]]);
		}
	}
	static int get(int l, int r) {
		int size = (int)(Math.log(r-l+1) / Math.log(2));
		if (s[l][size][0] < s[r-(1 << size)+1][size][0]) {
			return s[l][size][1];
		} else {
			return s[r-(1 << size)+1][size][1];
		}
	}
	static void dfs(int v, int d, long d2) {
		vis[v] = true;
		dis[v] = d2;
		lvl[ind] = d;
		h[v] = ind;
		e[ind++] = v;
		for (Edge nxt: adj[v]) {
			if (!vis[nxt.v]) {
				dfs(nxt.v,d+1,d2+nxt.w);
				lvl[ind] = d;
				e[ind++] = v;
			}
		}
	}
	static class Edge{
		int v, w;
		Edge(int v, int w){
			this.v = v;
			this.w = w;
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
