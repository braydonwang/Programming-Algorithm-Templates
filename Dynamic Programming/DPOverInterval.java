package DMOJ;
import java.util.*;
import java.io.*;
public class DPOverInterval {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		//For the question "Pick it"
		while (true) {
			int n = readInt();
			if (n == 0) {
				break;
			}
			int[] array = new int[n+1];
			for (int i = 1; i <= n; i++) {
				array[i] = readInt();
			}
			int[][] dp = new int[n+1][n+1];
			for (int l = n; l >= 1; l--) {
				//Loop for all intervals that are larger than or equal to a length of 3 (_,_,_)
				for (int r = l+2; r <= n; r++) {
					//Loop for all elements in between l and r (the edge elements that don't get removed)
					//to indicate the middle value
					for (int i = l+1; i < r; i++) {
						//The max value between l and r is the max value from the interval of l to i +
						//the max from i to r + the sum of the three values that will be included (l,r,and i)
						//*The max value from l to i considers the case where l and i are the edge values
						//so they can never be removed (same with i to r)
						dp[l][r] = Math.max(dp[l][r], dp[l][i] + dp[i][r] + array[l] + array[i] + array[r]);
					}
				}
			}
			System.out.println(dp[1][n]);
		}
	}
	//You imagine that all the values that are not l, r or i have already been removed, and it is only
	//l, r and i that are adjacent to each other (that is why we need to add the max value to get to that situation
	//with dp[l][i] + dp[i][r]
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
