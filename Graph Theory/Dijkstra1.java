import java.util.*;
//Use this Dijkstra if n^2 > number of edges
import java.io.*;
public class Dijkstra1 {
	//Use this if n^2 is greater than the number of edges
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		List<Edge> adj[] = new ArrayList[n+1];
		List<Integer> path[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
			path[i] = new ArrayList();
		}
		for (int i = 1; i <= m; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new Edge(v,w)); adj[v].add(new Edge(u,w));
		}
		int[] dis = new int[n+1];
		PriorityQueue<Edge> q = new PriorityQueue();
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1] = 0; q.add(new Edge(1,0)); path[1].add(1);
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			if (cur.w > dis[cur.v]) {
				continue;
			}
			for (Edge e: adj[cur.v]) {
				if (dis[e.v] > dis[cur.v] + e.w) {
					dis[e.v] = dis[cur.v] + e.w;
					q.add(new Edge(e.v, dis[e.v]));
					path[e.v].clear();
					for (int i = 0; i < path[cur.v].size(); i++) {
						path[e.v].add(path[cur.v].get(i));
					}
					path[e.v].add(e.v);
				}
			}
		}
	}
	static class Edge implements Comparable<Edge> {
		int v, w;
		Edge(int v0, int w0){
			v=v0;
			w=w0;
		}
		public int compareTo(Edge x) {
			return w-x.w;
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
