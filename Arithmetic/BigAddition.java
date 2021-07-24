import java.util.*;
import java.io.*;
public class APlusBHard {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int i = 0; i < n; i++) {
			String a = next(), b = next();
			int tempa = a.indexOf('-'), tempb = b.indexOf('-');
			if (tempa == -1 && tempb == -1) {
				System.out.println(add(a,b));
			} else if (tempa != -1 && tempb == -1) {
				int temp = larger(a,b);
				if (temp == 1) {
					System.out.println("-" + sub(a,b));
				} else if (temp == 2){
					System.out.println(sub(b,a));
				} else {
					System.out.println(0);
				}
			} else if (tempa == -1 && tempb != -1) {
				int temp = larger(a,b);
				if (temp == 2) {
					System.out.println("-" + sub(b,a));
				} else if (temp == 1){
					System.out.println(sub(a,b));
				} else {
					System.out.println(0);
				}
			} else {
				System.out.println("-" + add(a,b));
			}
		}
	}
	static String add(String a, String b) {
		int carry = 0;
		a = a.replaceAll("-","");
		b = b.replaceAll("-","");
		String ans = "";
		if (b.length() < a.length()) {
			while (true) {
				if (b.length() == a.length()) {
					break;
				}
				b = "0" + b;
			}
		} else if (a.length() < b.length()) {
			while (true) {
				if (a.length() == b.length()) {
					break;
				}
				a = "0" + a;
			}
		}
		for (int i = a.length()-1; i >= 0; i--) {
			int num = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
			carry = num/10;
			ans = num%10 + ans;
		}
		if (carry > 0) {
			ans = carry + ans;
		}
		return ans;
	}
	static String sub(String a, String b) {
		a = a.replaceAll("-","");
		b = b.replaceAll("-","");
		String ans = "";
		if (b.length() < a.length()) {
			while (true) {
				if (b.length() == a.length()) {
					break;
				}
				b = "0" + b;
			}
		} else if (a.length() < b.length()) {
			while (true) {
				if (a.length() == b.length()) {
					break;
				}
				a = "0" + b;
			}
		}
		for (int i = a.length()-1; i >= 0; i--) {
			int n1 = a.charAt(i) - '0';
			int n2 = b.charAt(i) - '0';
			if (n1 < n2) {
				n1 += 10;
				if (a.charAt(i-1) != '0') {
					a = a.substring(0,i-1) + (char)(a.charAt(i-1) - 1) + a.substring(i);
				} else {
					int ind = i-1;
					while (true) {
						if (a.charAt(ind) != '0') {
							a = a.substring(0,ind) + (char)(a.charAt(ind) - 1) + a.substring(ind+1);
							break;
						} else {
							a = a.substring(0,ind) + "9" + a.substring(ind+1);
						}
						ind--;
					}
				}
			}
			ans = (n1-n2) + ans;
		}
		while (true) {
			if (ans.charAt(0) != '0') {
				break;
			} else {
				ans = ans.substring(1);
			}
		}
		return ans;
	}
	static int larger(String a, String b) {
		a = a.replaceAll("-", "");
		b = b.replaceAll("-","");
		if (a.length() > b.length()) {
			return 1;
		} else if (a.length() < b.length()) {
			return 2;
		} else {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) > b.charAt(i)) {
					return 1;
				} else if (a.charAt(i) < b.charAt(i)) {
					return 2;
				}
			}
		}
		return 3;
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
