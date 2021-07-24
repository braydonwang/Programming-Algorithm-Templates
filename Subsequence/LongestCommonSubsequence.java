package DMOJ;
import java.util.*;
import java.io.*;
public class LongestCommonSubsequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str1 = next();
		String str2 = next();
		int[][] array = new int[str1.length()+1][str2.length()+1];
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					array[i][j] = array[i-1][j-1] + 1;
				} else {
					array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
				}
			}
		}
		int i = str1.length(), j = str2.length(), num = array[i][j];
		String temp = "";
		while (array[i][j] != 0) {
			if (array[i-1][j] == num) {
				i--;
			} else if (array[i][j-1] == num) {
				j--;
			} else {
				temp += str1.charAt(i-1);
				i--;
				j--;
				num--;
			}
		}
		System.out.println(array[str1.length()][str2.length()]);
		for (int k = temp.length()-1; k >= 0; k--) {
			System.out.print(temp.charAt(k));
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
