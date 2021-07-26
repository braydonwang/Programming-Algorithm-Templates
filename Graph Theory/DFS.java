import java.util.*;
import java.io.*;
public class Main {
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
    dfs(1,-1);
	}
  static void dfs(int v, int pre) {
    for (int nxt: adj[v]){
      if (nxt != pre) {
        dfs(nxt,v);
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
