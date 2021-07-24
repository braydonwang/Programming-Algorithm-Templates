package DMOJ;
import java.util.*;
import java.io.*;
public class BinaryTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Pair[] tree;
	static int num;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		num = (int) Math.pow(2, n);
		tree = new Pair[num*2];
		int count = 1;
		for (int i = num; i < num*2; i++) {
			tree[i] = new Pair(count,readInt());
			count++;
		}
		update();
		for (int i = 0; i < m; i++) {
			String str = next();
			//replacing the number at position 'a' with the value of 'b'
			if (str.equals("R")) {
				int a = readInt(), b = readInt();
				tree[num+a-1] = new Pair(a,b);
				for (int j = (num+a-1)/2; j >= 1; j/=2) {
					if (tree[j*2].val > tree[j*2+1].val) {
						tree[j] = tree[j*2];
					} else {
						tree[j] = tree[j*2+1];
					}
				}
			//print out the largest number in the tree
			} else if (str.equals("W")) {
				System.out.println(tree[1].ind);
			//count the number of numbers that the value at position 'a' is bigger than in its bracket
			} else {
				int a = readInt();
				int win = 0, temp = tree[num+a-1].val;
				for (int j = (num+a-1)/2; j >= 1; j/=2) {
					if (tree[j].val == temp) {
						win++;
					} else {
						break;
					}
				}
				System.out.println(win);
			}
		}
	}
	static void update() {
		for (int i = num-1; i >= 1; i--) {
			if (tree[i*2].val > tree[i*2+1].val) {
				tree[i] = tree[i*2];
			} else {
				tree[i] = tree[i*2+1];
			}
		}
	}
	static class Pair{
		int ind, val;
		Pair(int ind, int val){
			this.ind = ind;
			this.val = val;
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
