import java.io.*;
import java.util.*;
public class Solution {
	static int v,e;
	static Edge[] edges;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_d4_치즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= t; tc++) {
        	st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			edges = new Edge[e];
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				long weight = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(from,to,weight);
			}
			
			Arrays.sort(edges);
			make();
			long result =0;		//최소 가중치
			int cnt = 0; 		//cnt == N-1이 되면 break
			for (Edge edge : edges) {
				if(union(edge.from,edge.to)) {
					result += edge.weight;
					if(++cnt == v-1)
						break;
				}
			}
			
			sb.append("#" + tc + " " + result + "\n");
		}
        System.out.println(sb);
	}
	
	static void make() {
		p = new int[v+1];
		for (int i = 1; i <= v; i++) {
			p[i] = i;
		}
	}
	
	static int find(int a) {
		if(p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		long weight;
		
		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight);
		}
	}
}