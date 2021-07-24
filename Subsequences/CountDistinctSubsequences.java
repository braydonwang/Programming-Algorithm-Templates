package DMOJ;
import java.util.*;
import java.io.*;
public class CountDistinctSubsequences {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = 10007;
	public static void main(String[] args) throws IOException {
		String str = next();
		int n = str.length();
		//dp holds the # of distinct subsequences using the substring from 1 to i
		long[] dp = new long[n+1];
		//last holds the index of the last occurence of that character minus 1
		int[] last = new int[26];
		Arrays.fill(last, -1);
		//there is one distinct empty subsequence " "
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			//every distinct subsequence from the previous substring can have this letter put to the end of it
			dp[i] = 2*dp[i-1] % mod;
			//however, if this letter occured before, you must not double count it
			if (last[str.charAt(i-1)-'a'] != -1) {
				//every subsequence from the substring before the last occurence already has that character after it
				//so reduce the current total by the # of distinct subsequences before the last occurence
				dp[i] -= dp[last[str.charAt(i-1)-'a']];
			}
			//change the last occurence to this index - 1
			last[str.charAt(i-1)-'a'] = i-1;
		}
		//exclude the empty space
		System.out.println(dp[n]-1);
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
