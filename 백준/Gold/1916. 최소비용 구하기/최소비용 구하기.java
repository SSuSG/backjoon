import java.io.*;
import java.util.*;
public class Main {
	static int n,m;
	static int[] distance;
	static boolean[] isVisit;
	static List<List<Node>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i <= n; i++) 
			graph.add(new ArrayList<>());	
		distance = new int[n+1];
		isVisit = new boolean[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(new Node(end,cost));
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		ds(start);
		
		System.out.println(distance[end]);
	}
	
	static void ds(int start) {
		distance[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2) ->  o1.cost - o2.cost);
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			
			if(isVisit[curNode.v])
				continue;
			isVisit[curNode.v] = true;
			
			//현재 정점과 연결된 정점 확인
			for (Node next : graph.get(curNode.v)) {
				if(!isVisit[next.v] && distance[next.v] > (distance[curNode.v] + next.cost) ) {
					distance[next.v] = (distance[curNode.v] + next.cost);
					pq.add(new Node(next.v , distance[next.v]));
				}
			}
		}
	}
	
	static class Node{
		int v;
		int cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		public int getV() {
			return v;
		}

		public int getCost() {
			return cost;
		}
	}
}