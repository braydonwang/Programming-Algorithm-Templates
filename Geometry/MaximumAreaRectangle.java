package DMOJ;
import java.util.*;
import java.io.*;
public class MaximumAreaRectangle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		//number of test cases (k)
		int k = readInt();
		for (int a = 0; a < k; a++) {
			//dimensions of grid (m by n)
			int m = readInt(), n = readInt();
			char[][] array = new char[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++){
				    array[i][j] = next().charAt(0);
				}
			}
			//'R' = reserved, 'F' = free
			int[] his = new int[n];
			int max = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (array[i][j] == 'R') {
						his[j] = 0;
					} else {
						his[j]++;
					}
				}
				Stack<Integer> stack = new Stack<Integer>();
				int l = 0;
				while (l < n) {
					if (stack.isEmpty() || his[l] >= his[stack.peek()]) {
						stack.add(l++);
					} else {
						int top = stack.peek(), area = 0;
						stack.pop();
						if (stack.isEmpty()) {
							area = his[top] * l;
						} else {
							area = his[top] * (l - stack.peek() - 1);
						}
						max = Math.max(max, area);
					}
				}
				while (!stack.isEmpty()) {
					int top = stack.peek(), area = 0;
					stack.pop();
					if (stack.isEmpty()) {
						area = his[top] * l;
					} else {
						area = his[top] * (l - stack.peek() - 1);
					}
					max = Math.max(max, area);
				}
			}
			System.out.println(max);
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
