package DMOJ;
import java.util.*;
import java.io.*;
public class TreeDiameterAndRadius {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Edge> adj[];
    static int max1 = 0, far1 = 0, max2 = 0, far2 = 0;
    static Edge[] pre;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
        	adj[i] = new ArrayList();
        }
        for (int i = 0; i < n-1; i++) {
        	int a = readInt(), b = readInt(), c = readInt();
        	adj[a].add(new Edge(b,c)); adj[b].add(new Edge(a,c));
        }
        pre = new Edge[n+1];
        dfs(1,0,0);
        pre[far1] = new Edge(-1,0);
        dfs2(far1,0,0);
        System.out.println(max2);
        int count = 0, rad = Integer.MAX_VALUE;
        while (pre[far2].v != -1) {
        	count += pre[far2].w;
        	rad = Math.min(rad, Math.max(count, max2-count));
        	far2 = pre[far2].v;
        }
        System.out.println(rad);
    }
    static void dfs2(int v, int par, int dis) {
    	if (dis > max2) {
    		max2 = dis; far2 = v;
    	}
    	for (Edge nxt: adj[v]) {
    		if (nxt.v != par) {
    			pre[nxt.v] = new Edge(v,nxt.w);
    			dfs2(nxt.v,v,dis+nxt.w);
    		}
    	}
    }
    static void dfs(int v, int par, int dis) {
    	if (dis > max1) {
    		max1 = dis; far1 = v;
    	}
    	for (Edge nxt: adj[v]) {
    		if (nxt.v != par) {
    			dfs(nxt.v,v,dis+nxt.w);
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
