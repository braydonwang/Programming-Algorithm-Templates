package DMOJ;
import java.util.*;
import java.io.*;
public class XOR {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//finds the XOR of all numbers between l and r (inclusive)
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int i = 0; i < t; i++) {
			int l = readInt(), r = readInt();
			int ans1 = findXOR(l-1), ans2 = findXOR(r);
			System.out.println(ans1 ^ ans2);
		}
	}
	static int findXOR(int num) {
		//finds xor of all numbers between 1 and n
		int mod = num % 4;
		if (mod == 0) {
			return num;
		} else if (mod == 1) {
			return 1;
		} else if (mod == 2) {
			return num+1;
		} else {
			return 0;
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
