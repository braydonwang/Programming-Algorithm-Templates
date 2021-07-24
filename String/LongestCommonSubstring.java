package DMOJ;
import java.util.*;
import java.io.*;
public class LongestCommonSubstring {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str1 = next();
        String str2 = next();
        int max = 0;
        int[][] array = new int[str1.length()+1][str2.length()+1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    array[i][j] = array[i-1][j-1] + 1;
                    max = Math.max(array[i][j], max);
                } else {
                    array[i][j] = 0;
                }
            }
        }
        String temp = "";
        boolean done = false;
        //Nested for-loop may not be necessary
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (array[i][j] == max) {
                    for (int k = i-1; k >= i-max; k--) {
                        temp += str1.charAt(k);
                    }
                    done = true;
                    break;
                }
            }
            if (done) break;
        }
        System.out.println("The longest substring is " + max);
        for (int i = temp.length()-1; i >= 0; i--) {
            System.out.print((char)(temp.charAt(i)));
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
