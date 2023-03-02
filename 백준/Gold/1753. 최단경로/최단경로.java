import java.io.*;
import java.util.*;

public class Main {
	static int v,e;
	static int[] dist;
	static boolean[] isVisit;
	static List<List<Node>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());
		dist = new int[v+1];
		isVisit = new boolean[v+1];
		for (int i = 0; i <= v; i++) 
			graph.add(new ArrayList<>());	
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Node(end,cost));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>( (o1,o2) -> Integer.compare(o1.cost, o2.cost) );
		dist[s] = 0;
		pq.offer(new Node(s,0));

		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			
			if(isVisit[curNode.v])
				continue;
			isVisit[curNode.v] = true;
			
			//현재 정점과 연결된 정점 확인
			for (Node next : graph.get(curNode.v)) {
				if(!isVisit[next.v] && dist[next.v] > (dist[curNode.v] + next.cost) ) {
					dist[next.v] = (dist[curNode.v] + next.cost);
					pq.add(new Node(next.v , dist[next.v]));
				}
			}
		}
		
		for (int i = 1; i <= v ; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
		}
	}
	
	static class Node{
		int v;
		int cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
}