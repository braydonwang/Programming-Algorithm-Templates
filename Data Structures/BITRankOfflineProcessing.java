package DMOJ;
import java.util.*;
import java.io.*;
public class BITRankOfflineProcessing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] bit;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		bit = new int[n+1];
		Triple[] array = new Triple[n];
		Pair[] rank = new Pair[n];
		int count = 0;
		Arrays.fill(rank, new Pair(0,Integer.MAX_VALUE));
		for (int i = 0; i < n; i++) {
			char ch = readCharacter();
			if (ch == 'Q') {
				int k = readInt();
				array[i] = new Triple(ch,k,0);
			} else {
				int x = readInt(), r = readInt();
				rank[count] = new Pair(x,r);
				array[i] = new Triple(ch,x,r);
				count++;
			}
		}
		Arrays.sort(rank);
		int[] temp = new int[(int) (1e6+5)];
		int[] temp2 = new int[(int) (1e6+5)];
		int total = 0;
		for (int i = 0; i < n; i++) {
			if (array[i].ch == 'N') {
				total++;
				int lo = 0, hi = count-1;
				int ind = 0;
				while (lo <= hi) {
					int mid = (lo + hi) / 2;
					if (rank[mid].val == array[i].val) {
						ind = mid + 1;
						break;
					} else if (rank[mid].val < array[i].val) {
						lo = mid + 1;
					} else {
						hi = mid - 1;
					}
				}
				temp[array[i].ind] = ind; 
				temp2[ind] = array[i].ind;
				update(ind,1);
			} else if (array[i].ch == 'M') {
				update(temp[array[i].ind],-1);
				int lo = 0, hi = count-1;
				int ind = 0;
				while (lo <= hi) {
					int mid = (lo + hi) / 2;
					if (rank[mid].val == array[i].val) {
						ind = mid + 1;
						break;
					} else if (rank[mid].val < array[i].val) {
						lo = mid + 1;
					} else {
						hi = mid - 1;
					}
				}
				temp[array[i].ind] = ind;
				temp2[ind] = array[i].ind;
				update(ind,1);
			} else {
				int lo = 0, hi = count-1;
				while (lo <= hi) {
					int mid = (lo + hi) / 2;
					if (query(mid) > total - array[i].ind) {
						hi = mid - 1;
					} else {
						lo = mid + 1;
					}
				}
				System.out.println(temp2[lo]);
			}
		}
	}
	static class Pair implements Comparable<Pair>{
		int ind, val;
		Pair(int ind, int val){
			this.ind = ind;
			this.val = val;
		}
		public int compareTo(Pair p) {
			return this.val - p.val;
		}
	}
	static class Triple{
		char ch;
		int ind, val;
		Triple(char ch, int ind, int val){
			this.ch = ch;
			this.ind = ind;
			this.val = val;
		}
	}
	static void update(int x, int v) {
		for (int i = x; i <= n; i += i&-i) {
			bit[i] += v;
		}
	}
	static int query(int x) {
		int total = 0;
		for (int i = x; i > 0; i -= i&-i) {
			total += bit[i];
		}
		return total;
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
