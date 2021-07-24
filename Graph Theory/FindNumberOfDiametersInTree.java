package DMOJ;
import java.util.*;
import java.io.*;
public class FindNumberOfDiametersInTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static int[] dis, cnt;
	static int dia, num;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		//dis array holds the farthest path that ends at node i
		//cnt array holds the number of different paths that end at i and is the farthest
		dia = 0; num = 0; dis = new int[n+1]; cnt = new int[n+1];
		//there is always one way to get to the node i (just the node itself)
		Arrays.fill(cnt, 1);
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b); adj[b].add(a);
		}
		dfs(1,-1);
		//not sure why diameter needs to increase by 1
		System.out.println(dia+1 + " " + num);
	}
	static void dfs(int cur, int pre) {
		for (int nxt: adj[cur]) {
			if (nxt != pre) {
				dfs(nxt,cur);
				//update diameter if you find a larger path
				if (dia < dis[cur] + dis[nxt] + 1) {
					dia = dis[cur] + dis[nxt] + 1;
					num = cnt[cur] * cnt[nxt];
				//update number of diameters if its the same
				} else if (dia == dis[cur] + dis[nxt] + 1) {
					num += cnt[cur] * cnt[nxt];
				}
				//update the farthest path that ends at node cur
				if (dis[cur] < dis[nxt] + 1) {
					dis[cur] = dis[nxt] + 1;
					cnt[cur] = cnt[nxt];
				//update the number of farthest paths that end at node cur
				} else if (dis[cur] == dis[nxt] + 1) {
					cnt[cur] += cnt[nxt];
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
