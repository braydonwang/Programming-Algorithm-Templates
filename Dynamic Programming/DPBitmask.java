import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
  //from the question "DMOPC '14 Contest 3 P5 - Not Enough Servers!"
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int[] bit = new int[m];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			String str = next();
			boolean ac = true;
			for (int j = 0; j < m; j++) {
				bit[j] = bit[j] << 1;
				if (str.charAt(j) == 'X') {
					ac = false;
					bit[j] = bit[j]| 1;
				}
			}
			if (!ac) {
				ans = ans << 1 | 1;
			} else {
				ans = ans << 1;
			}
		}
		if (ans == 0) {
			System.out.println(1);
			System.out.println(1);
			return;
		}
		int[] dp = new int[1 << n];
		int[] pre = new int[1 << n];
		int[] cas = new int[1 << n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < m; i++) {
			for (int j = (1 << n) - 1; j >= 0; j--) {
				if (dp[j] != Integer.MAX_VALUE && (j | bit[i]) < (1 << n)) {
					if (dp[j] + 1 < dp[j | bit[i]]) {
						dp[j | bit[i]] = dp[j] + 1;
						pre[j | bit[i]] = j;
						cas[j | bit[i]] = i+1;
					}
				}
			}
		}
		System.out.println(dp[ans]);
		int temp = ans;
		for (int i = 0; i < dp[ans]; i++){
		    System.out.print(cas[temp] + " ");
		    temp = pre[temp];
		}
		System.out.println();
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
