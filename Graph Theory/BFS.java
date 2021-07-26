package DMOJ;
import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
    ArrayList<Integer> adj[] = new ArrayList[n+1];
    for (int i = 0; i <= n; i++){
      adj[i] = new ArrayList();
    }
    for (int i = 0; i < m; i++){
      int a = readInt(), b = readInt();
      adj[a].add(b); adj[b].add(a);
    }
    Queue<Integer> q = new LinkedList();
    boolean[] vis = new boolean[n+1];
    int[] dis = new int[n+1];
    vis[1] = true; dis[1] = 0; q.add(1);
    while (!q.isEmpty()){
      int cur = q.poll();
      for (int nxt: adj[cur]){
        if (!vis[nxt]){
          q.add(nxt); vis[nxt] = true; dis[nxt] = dis[cur] + 1;
        }
      }
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
