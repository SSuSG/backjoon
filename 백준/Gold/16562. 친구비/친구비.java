import java.io.*;
import java.util.*;

public class Main {
	static int n,m,k,min=Integer.MAX_VALUE;
	static int[] friendCost;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		friendCost = new int[n+1];
		parent = new int[n+1];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			friendCost[i] = Integer.parseInt(st.nextToken());
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x,y);
		}
		
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if(find(i) == i) {
				sum += friendCost[i];
			}
		}
		if(k >= sum)
			System.out.println(sum);
		else
			System.out.println("Oh no");
		
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			parent[y] = x;
			int min = Math.min(friendCost[x], friendCost[y]);
			friendCost[x] = min;
			friendCost[y] = min;
		}
	}
	
	static int find(int x) {
		if(x == parent[x])
			return x;
		else 
			return parent[x] = find(parent[x]);
	}
}