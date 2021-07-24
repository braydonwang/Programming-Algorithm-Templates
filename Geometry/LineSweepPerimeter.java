package DMOJ;
import java.util.*;
import java.io.*;
public class LineSweepPerimeter {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int shift = 10000;
		Line[] v = new Line[n*2], h = new Line[n*2];
		for (int i = 0; i < n*2; i+=2) {
			int a = readInt(), b = readInt(), c = readInt(), d = readInt();
			v[i] = new Line(a,b,d,1); v[i+1] = new Line(c,b,d,2);
			h[i] = new Line(b,a,c,1); h[i+1] = new Line(d,a,c,2);
		}
		Arrays.sort(v); Arrays.sort(h);
		int[] cnt = new int[20001];
		int ans = 0;
		for (Line l: v) {
			if (l.type == 1) {
				for (int i = l.yl+shift; i < l.yh+shift; i++) {
					cnt[i]++;
					if (cnt[i] == 1) {
						ans++;
					}
				}
			} else {
				for (int i = l.yl+shift; i < l.yh+shift; i++) {
					if (cnt[i] == 1) {
						ans++;
					}
					cnt[i]--;
				}
			}
		}
		cnt = new int[20001];
		for (Line l: h) {
			if (l.type == 1) {
				for (int i = l.yl+shift; i < l.yh+shift; i++) {
					cnt[i]++;
					if (cnt[i] == 1) {
						ans++;
					}
				}
			} else {
				for (int i = l.yl+shift; i < l.yh+shift; i++) {
					if (cnt[i] == 1) {
						ans++;
					}
					cnt[i]--;
				}
			}
		}
		System.out.println(ans);
	}
	static class Line implements Comparable<Line>{
		int x, yl, yh, type;
		Line(int x, int yl, int yh, int type){
			this.x = x;
			this.yl = yl;
			this.yh = yh;
			this.type = type;
		}
		public int compareTo(Line l) {
			if (this.x == l.x) {
				return this.type - l.type;
			}
			return this.x - l.x;
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
