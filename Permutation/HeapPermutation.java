package DMOJ;
import java.util.*;
import java.io.*;
public class HeapPermutation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		Arrays.sort(a);
		do {
			System.out.println(Arrays.toString(a));
		} while (next_permutation(a));
		heapPermutation(a,n,n);
	}
	static boolean next_permutation(int[] a) {
		//must be sorted
		if (a.length <= 1) {
			return false;
		}
		int p = a.length - 2, q = a.length - 1;
		while (p >= 0 && a[p] >= a[p+1]) {
			p--;
		}
		if (p < 0) {
			return false;
		}
		while (a[q] <= a[p]) {
			q--;
		}
		int tmp = a[p]; a[p] = a[q]; a[q] = tmp;
		for (int l = p+1, r = a.length-1; l < r; l++, r--) {
			tmp = a[l]; a[l] = a[r]; a[r] = tmp;
		}
		return true;
	}
	static void heapPermutation(int array[], int size, int n){
        if (size == 1) {
        	//print the array
        	System.out.println(Arrays.toString(array));
        }
        for (int i = 0; i < size; i++) {
            heapPermutation(array, size - 1, n);
            if (size % 2 == 1) {
                int temp = array[0];
                array[0] = array[size - 1];
                array[size - 1] = temp;
            }
            else {
                int temp = array[i];
                array[i] = array[size - 1];
                array[size - 1] = temp;
            }
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
