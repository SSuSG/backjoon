import java.io.*;
import java.util.*;
public class Solution {
	static int n,m;
	static int[] p;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t ; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); 
			m = Integer.parseInt(st.nextToken()); 
			p = new int[n+1];
			visit = new boolean[n+1];
			make();
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			for (int i = 1; i <= n ; i++) {
				visit[find(i)] = true;
			}
			int count = 0;
			for (int i = 1; i <= n ; i++) {
				if(visit[i])
					count++;
			}
			
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}
	static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		
		if(aParent == bParent)
			return;
		p[bParent] = aParent;
		return;
	}
	
	static int find(int x) {
		if(p[x] == x)
			return x;
		else
			return p[x] = find(p[x]);
	}
	
	static void make() {
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
	}
}