package DMOJ;
import java.util.*;
import java.io.*;
public class BinarySearchTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Node root = null;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += solve(readInt()) + 1;
		}
		System.out.printf("%.2f", (double)sum / n);
	}
	static int solve(int x) {
		int rank = 0;
		if (root == null) {
			root = new Node(x);
			return 0;
		} else {
			Node n = root;
			while (true) {
				if (x < n.val) {
					rank += n.rank + 1;
					if (n.left == null) {
						n.left = new Node(x);
						return rank;
					} else {
						n = n.left;
					}
				} else {
					n.rank++;
					if (n.right == null) {
						n.right = new Node(x);
						return rank;
					} else {
						n = n.right;
					}
				}
			}
		}
	}
	static class Node{
		int val, rank;
		Node left, right;
		Node(int x){
			this.val = x;
			this.rank = 0;
			left = null;
			right = null;
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
