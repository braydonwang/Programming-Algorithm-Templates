package DMOJ;
import java.util.*;
import java.io.*;
public class LineSweep {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int MM;
	static int[] bit;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), ans = 0;
		MM = 2*n+m+5;
		bit = new int[MM];
		ArrayList<Event> e = new ArrayList();
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for (int i = 0; i < n; i++) {
			int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
			if (r1 <= r2 && c1 <= c2) {
				e.add(new Event(r1,c1,c2,1)); e.add(new Event(r2,c1,c2,3));
				map.put(c1, 0); map.put(c2,0);
			}
		}
		for (int i = 0; i < m; i++) {
			int x = readInt(), y = readInt();
			e.add(new Event(x,y,y,2)); map.put(y, 0);
		}
		int count = 1;
		for (int x: map.keySet()) {
			map.put(x,count);
			count++;
		}
		Collections.sort(e);
		count = 0;
		for (int i = 0; i < e.size(); i++) {
			System.out.println(Arrays.toString(bit));
			Event v = e.get(i);
			if (v.type == 1) {
				int lo = map.get(v.yl), hi = map.get(v.yh);
				update(lo,1); update(hi+1,-1);
			} else if (v.type == 3) {
				int lo = map.get(v.yl), hi = map.get(v.yh);
				update(lo,-1); update(hi+1,+1);
			} else {
				int pos = map.get(v.yl);
				if (query(pos) > 0) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	static void update(int x, int v) {
		for (int i = x; i < MM; i+=i&-i) {
			bit[i] += v;
		}
	}
	static int query(int x) {
		int tot = 0;
		for (int i = x; i > 0; i -= i&-i) {
			tot += bit[i];
		}
		return tot;
	}
	static class Event implements Comparable<Event>{
		int x, yl, yh, type;
		Event(int x, int yl, int yh, int type){
			this.x = x;
			this.yl = yl;
			this.yh = yh;
			this.type = type;
		}
		public int compareTo(Event e) {
			if (this.x == e.x) {
				return this.type - e.type;
			}
			return this.x - e.x;
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
