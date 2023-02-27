import java.io.*;
import java.util.*;
public class Solution {
	static int n,m;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t ; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); 
			m = Integer.parseInt(st.nextToken()); 
			p = new int[n+1];
			make();
			sb.append("#" + tc + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(cal == 0)
					union(a,b);
				else {
					if(find(a) == find(b)) 
						sb.append(1);
					else
						sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void make() {
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
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
}