package DMOJ;
import java.util.*;
import java.io.*;
public class IntersectingLine {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		Pair a = new Pair(readInt(),readInt()), b = new Pair(readInt(),readInt());
		int n = readInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int k = readInt();
			Pair[] p = new Pair[k];
			for (int j = 0; j < k; j++) {
				p[j] = new Pair(readInt(),readInt());
			}
			for (int j = 0; j < k; j++) {
				if (intersect(a,b,p[j],p[(j+1)%k])) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
	static boolean intersect(Pair p1, Pair p2, Pair q1, Pair q2) {
		//check if the bounding rectangles overlap and if the two end points of each line segment
		//is on opposite sides of the other line
		if (rectCheck(p1,p2,q1,q2) && 1L*c(p1,p2,q1) * c(p1,p2,q2) <= 0 && 1L*c(q1,q2,p1) * c(q1,q2,p2) <= 0) {
			return true;
		}
		return false;
	}
	static boolean rectCheck(Pair p1, Pair p2, Pair q1, Pair q2) {
		//checking if the bounding rectangles overlap
		int lft = Math.min(p1.x, p2.x), rit = Math.max(p1.x, p2.x), bot = Math.min(p1.y, p2.y), top = Math.max(p1.y, p2.y);
		if (rit >= Math.min(q1.x, q2.x) && Math.max(q1.x,q2.x) >= lft && top >= Math.min(q1.y, q2.y) && Math.max(q1.y, q2.y) >= bot) {
			return true;
		}
		return false;
	}
	static int c(Pair a, Pair b, Pair c) {
		//using cross product formula
		return (b.x-a.x)*(c.y-a.y)- (b.y-a.y)*(c.x-a.x); 
	}
	static class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
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
