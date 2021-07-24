package DMOJ;
import java.io.*;
import java.util.*;
public class FindAllNodesPartOfCycle{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] vis;
    static Set<Integer> set = new HashSet();
    static ArrayList<Integer> adj[];
    public static void main(String[]args) throws IOException{
    	int n = readInt(), k = readInt();
    	vis = new boolean[n+1];
    	adj = new ArrayList[n+1];
    	for (int i = 0; i <= n; i++) {
    		adj[i] = new ArrayList();
    	}
    	for (int i = 0; i < k; i++) {
    		int a = readInt(), b = readInt(), c = readInt(), d = readInt();
    		if (c > d) {
    			adj[a].add(b);
    		} else {
    			adj[b].add(a);
    		}
    	}
    	for (int i = 1; i <= n; i++) {
    		if (!vis[i]) {
    			dfs(vis,i,i,0);
    		}
    	}
    	System.out.println(set.size());
    }
    static boolean dfs(boolean[] vis, int v, int start, int dis) {
    	if (dis != 0 && v == start) {
    		return true;
    	}
    	if (vis[v]) {
    		return false;
    	}
    	vis[v] = true;
    	for (int x: adj[v]) {
    		if (dfs(Arrays.copyOf(vis, vis.length),x,start,dis+1)) {
    			set.add(x);
    			return true;
    		}
    	}
    	return false;
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
    static String readLine () throws IOException {
  	  return br.readLine().trim();
    } 
}
