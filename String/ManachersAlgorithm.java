package DMOJ;
import java.util.*;
import java.io.*;
public class ManachersAlgorithm {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String temp = next();
		String str = "#";
		for (int i = 0; i < n; i++) {
			str += temp.charAt(i) + "#";
		}
		int max = 0;
		String ans = "";
		for (int i = 0; i < n*2+1; i++) {
			int lo = i, hi = i;
			while (lo >= 0 && hi < n*2+1 && str.charAt(lo) == str.charAt(hi)) {
				if (hi - lo + 1 > max) {
					//System.out.println(str.substring(lo,hi+1));
					max = hi - lo + 1;
					ans = str.substring(lo,hi+1);
				}
				lo--; hi++;
			}
		}
		ans = ans.replaceAll("#", "");
		System.out.println(ans);
		System.out.println(ans.length());
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
