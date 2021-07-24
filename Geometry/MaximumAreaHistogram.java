package DMOJ;
import java.util.*;
import java.io.*;
public class MaximumAreaHistogram {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] his = new int[n];
		for (int i = 0; i < n; i++) {
			his[i] = readInt();
		}
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int l = 0;
		while (l < n) {
			if (stack.isEmpty() || his[l] >= his[stack.peek()]) {
				stack.add(l++);
			} else {
				int top = stack.pop(), area = 0;
				if (stack.isEmpty()) {
					area = his[top] * l;
				} else {
					area = his[top] * (l - stack.peek() - 1);
				}
				max = Math.max(max, area);
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop(), area = 0;
			if (stack.isEmpty()) {
				area = his[top] * l;
			} else {
				area = his[top] * (l - stack.peek() - 1);
			}
			max = Math.max(max, area);
		}
		System.out.println(max);
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
