package DMOJ;
import java.util.*;
import java.io.*;
public class SecondShortestPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		List<Edge> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 1; i <= m; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new Edge(v,w)); adj[v].add(new Edge(u,w));
		}
		int[][] dis = new int[n+1][2];
		PriorityQueue<Edge> q = new PriorityQueue();
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dis[i], Integer.MAX_VALUE);
		}
		dis[1][0] = 0; q.add(new Edge(1,0));
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (cur.w > dis[cur.v][1]) {
				continue;
			}
			for (Edge e: adj[cur.v]) {
				int temp1 = dis[cur.v][0] + e.w, temp2 = dis[cur.v][1] + e.w;
				if (temp1 < dis[e.v][0]) {
					dis[e.v][1] = dis[e.v][0];
					dis[e.v][0] = temp1;
					q.add(new Edge(e.v,temp1));
				} else if (temp1 < dis[e.v][1] && temp1 != dis[e.v][0]) {
					dis[e.v][1] = temp1;
					q.add(new Edge(e.v,temp1));
				} else if (temp2 < dis[e.v][1] && temp2 != dis[e.v][0]) {
					dis[e.v][1] = temp2;
					q.add(new Edge(e.v,temp2));
				}
			}
		}
		System.out.println(dis[n][1]);
	}
	static class Edge implements Comparable<Edge> {
		int v, w;
		Edge(int v0, int w0){
			v=v0;
			w=w0;
		}
		public int compareTo(Edge x) {
			return Integer.compare(w, x.w);
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
