package DMOJ;

import java.util.*;
import java.io.*;
public class TopologicalSorting {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> adj[] = new ArrayList[8];
        int[] in = new int[8];
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            adj[i] = new ArrayList();
        }
        adj[1].add(7); adj[1].add(4); adj[2].add(1); adj[3].add(4); adj[3].add(5);
        in[7]++; in[4]++; in[1]++; in[4]++; in[5]++;
        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0 && y == 0) break;
            adj[x].add(y);
            in[y]++;
        }
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < 8; i++) {
            if (in[i] == 0 && cnt == 0) {
                q.add(i);
                pre.add(i);
                cnt++;
            }
            else if (in[i] == 0){
                a.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt: adj[cur]) {
                in[nxt]--;
                if (in[nxt] == 0) {
                    a.add(nxt);
                }
            }
            Collections.sort(a);
            if (!a.isEmpty()){
                q.add(a.get(0));
                pre.add(a.get(0));
                a.remove(0);
                cnt++;
            }
        }
        //If count is equal to the number of tasks, then there is no cycles
        if (cnt == 7) {
            for (int k = 0; k < pre.size(); k++) {
                System.out.print(pre.get(k) + " ");
            }
        }
        else System.out.println("Cannot complete these tasks. Going to bed.");
	}
}
