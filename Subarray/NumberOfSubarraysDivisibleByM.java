package DMOJ;
import java.util.*;
import java.io.*;
public class NumberOfSubarraysDivisibleByM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		HashMap<Long,Integer> map = new HashMap<Long,Integer>();
		long sum = 0;
		long ans = 0;
		map.put((long)0,1);
		for (int i = 0; i < n; i++) {
			sum += readInt();
			if (map.get(sum%m) == null) {
				map.put(sum%m,1);
			} else {
				ans += map.get(sum%m);
				map.put(sum%m,map.get(sum%m)+1);
			}
		}
		System.out.println(ans);
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
