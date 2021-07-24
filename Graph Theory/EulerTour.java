package DMOJ;
import java.util.*;
import java.io.*;
public class EulerTour {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Edge> adj[];
	static int[] e;
	static boolean[] vis;
	static int ind = 0;
	//Euler tour is a way of traversing a grid so that every node is visited at least once
	//the array "e" is set up so that e[i] holds the ith node that was visited
	//eg. e[1] = first node visited
	//e[2] = second node visited, and so on
	//it also implements backtracking so that node 1 visits node 2 and if node 2 cannot go anywhere, it goes back to node 1
	//the e array would look like this for the above example: [1,2,1]
	public static void main(String[] args) throws IOException {
		int n = readInt();
		adj = new ArrayList[n];
		e = new int[2*n-1];
		vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt(), w = readInt();
			adj[a].add(new Edge(b,w));
			adj[b].add(new Edge(a,w));
		}
		dfs(0);
	}
	static void dfs(int v) {
		vis[v] = true;
		e[ind++] = v;
		for (Edge nxt: adj[v]) {
			if (!vis[nxt.v]) {
				dfs(nxt.v);
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
