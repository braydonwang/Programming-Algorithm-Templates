package DMOJ;
import java.util.*;
import java.io.*;
public class LCAUsingBinaryLifting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static int[] h;
	static int maxn = 300000;
	static int logn = 20;
	static int[][] dp = new int[maxn+5][logn+2];
	//binary lifting involves holding the value of an ancestor that is a certain distance away from the node
	//dp[i][j] is the ancestor of node i that is 2^j distance away
	//we use this information to find the ancestors of the two nodes in question that are the same depth
	//once they are the same depth, we can travel up the graph the same distance and find the nodes that are the children of the lowest common ancestor
	public static void main(String[] args) throws IOException {
		int n = readInt();
		adj = new ArrayList[n+1];
		h = new int[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v); adj[v].add(u);
		}
		dfs(1,0);
	}
	static void dfs(int cur, int par){
	    h[cur] = h[par]+1;
	    dp[cur][0] = par;
	    for(int i = 1; i < logn; i++){
	        dp[cur][i] = dp[dp[cur][i-1]][i-1];
	    }
	    for(int i : adj[cur]){
	        if(i != par) {
	        	dfs(i, cur);
	        }
	    }
	}
	static int lca(int a, int b){
	    if(h[a] < h[b]) {
	    	int c = b;
	    	b = a;
	    	a = c;
	    }
	    int dif = h[a]-h[b];
	    for(int i = 0; i < logn; i++){
	        if((dif&(1<<i)) != 0) {
	        	a = dp[a][i];
	        }
	    }
	    if(a == b) {
	    	return a;
	    }
	    for(int i = logn-1; i >= 0; i--){
	        if(dp[a][i] != dp[b][i]){
	            a = dp[a][i]; b = dp[b][i];
	        }
	    }
	    return dp[a][0];
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
