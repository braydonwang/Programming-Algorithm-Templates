package DMOJ;
import java.util.*;
import java.io.*;
public class NumberOfSubarraysWhereMaxMinusMinLessThanK {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		//Monotonous Increasing and Decreasing Deque
		Deque<Integer> q1 = new LinkedList<Integer>();
		Deque<Integer> q2 = new LinkedList<Integer>();
		//Count the number of subarrays
		int count = 0;
		int ind = 0;
		//the strategy here is to find a subarray that works with an ending element of i 
		//if subarray i to j works, then subarray i+1 to j must also work and etc.
		//also if the subarray i to j does not work, then subarray i to j+1 must also not work
		//thats why we use ind to hold the value of the previous working beginning element so we don't have the start at the very beginning index
		for (int i = 0; i < n; i++) {
			while (!q1.isEmpty() && q1.getLast() < array[i]) {
				q1.removeLast();
			}
			while (!q2.isEmpty() && q2.getLast() > array[i]) {
				q2.removeLast();
			}
			q1.add(array[i]); q2.add(array[i]);
			//find the beginning element of the subarray that works
			while (ind < i && q1.getFirst() - q2.getFirst() > k) {
				if (!q1.isEmpty() && array[ind] == q1.getFirst()) {
					q1.removeFirst();
				}
				if (!q2.isEmpty() && array[ind] == q2.getFirst()) {
					q2.removeFirst();
				}
				ind++;
			}
			count += i - ind + 1;
		}
		System.out.println(count);
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
