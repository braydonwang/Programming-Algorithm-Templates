package DMOJ;

import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class AllPairShortestPath 
{   
    int[][] floydWarshall(int graph[][]) 
    { 
        int dist[][] = new int[graph.length][graph.length]; 
        int i, j, k; 
        for (i = 0; i < graph.length; i++) {
            for (j = 0; j < graph.length; j++) {
                dist[i][j] = graph[i][j]; 
            }
        }
        
        for (k = 0; k < graph.length; k++) { 
            for (i = 0; i < graph.length; i++) { 
                for (j = 0; j < graph.length; j++) { 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                    }
                } 
            } 
        } 
        return dist;
    } 
}
  
public class FloydWarshall {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), d = readInt();
		AllPairShortestPath a = new AllPairShortestPath(); 
		int[][] graph = new int[n+1][n+1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(graph[i], 10000);
		}
		for (int i = 0; i < n-1; i++) {
			int A = readInt(); int B = readInt(); int C = readInt();
			graph[A][B] = C;
			graph[B][A] = C;
		}
		for (int i = 0; i <= n; i++) {
			graph[i][i] = 0;
		}
        int[][] dist = a.floydWarshall(graph); 
        ArrayList<String> list = new ArrayList<String>();
        int b = readInt(), c = readInt();
        String temp = b + "" + c;
    	String temp2 = c + "" + b;
    	list.add(1 + temp);
    	list.add(1 + temp2);
        for (int i = 1; i < d; i++) {
        	b = readInt(); c = readInt();
        	temp = b + "" + c;
        	temp2 = c + "" + b;
        	ArrayList<String> t = new ArrayList<String>();
        	for (int j = 0; j < list.size(); j++) {
        		String str = list.get(j);
        		t.add(str + temp);
        		t.add(str + temp2);
        	}
        	list.clear();
        	for (int j = 0; j < t.size(); j++) {
        		list.add(t.get(j));
        	}
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
        	int total = 0;
        	String str = list.get(i);
        	for (int j = 0; j < str.length()-1; j++) {
        		int num = str.charAt(j) - '0';
        		int num2 = str.charAt(j+1) - '0';
        		total += dist[num][num2];
        	}
        	min = Math.min(min, total);
        }
        System.out.println(min);
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
