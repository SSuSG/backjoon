import java.util.*;
import java.io.*;
public class Main {
	static int n,max=0;
	static boolean[] isVisit;
	static List<Node>[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		graph = new List[n+1];
		for (int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		isVisit = new boolean[n+1];
		
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to,weight));
			graph[to].add(new Node(from,weight));
		}
		for (int i = 1; i <= n; i++) {
			isVisit[i] = true;
			dfs(i,0);
			isVisit[i] = false;
		}
		System.out.println(max);
	}
	
	static void dfs(int cur , int sum) {
		if(max < sum)
			max = sum;
		
		for (Node next : graph[cur]) {
			if(isVisit[next.v]) continue;
			
			isVisit[next.v] = true;
			dfs(next.v,sum+next.w);
			isVisit[next.v] = false;
		}
	}
	
	static class Node{
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}