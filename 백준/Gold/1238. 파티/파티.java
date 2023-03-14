import java.io.*;
import java.util.*;
public class Main {
	static int n,m,x;
	static List<Node>[] graph,backGraph;
	static int[] distance,result;
	static boolean[] isVisit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		graph = new List[1001];
		backGraph = new List[1001];
		result = new int[1001];
		for (int i = 0; i < 1001; i++) {
			graph[i] = new ArrayList<>();
			backGraph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to,time));
			backGraph[to].add(new Node(from,time));
		}
		
		//x마을로 가는 최단경로 -> 출발,도착 지점을 바꿔서 입력받은후 다익스트라
		//x마을에서 되돌아가는 최단경로 -> 다익스트라
		ds(graph);
		ds(backGraph);
		int max = 0;
		for (int i = 1; i < 1001 ; i++) {
			if(distance[i] == Integer.MAX_VALUE) continue;
			max = Math.max(max, result[i]);
		}
		System.out.println(max);
		
	}
	
	static void ds(List<Node>[] graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>( (o1,o2) -> Integer.compare(o1.time, o2.time));
		distance = new int[1001];
		Arrays.fill(distance, Integer.MAX_VALUE);
		isVisit = new boolean[1001];
		distance[x] = 0;
		pq.offer(new Node(x,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(isVisit[cur.v]) continue;
			isVisit[cur.v] = true;
			
			for (Node next : graph[cur.v]) {
				if(!isVisit[next.v] && distance[next.v] > distance[cur.v] + next.time) {
					distance[next.v] = distance[cur.v] + next.time;
					pq.offer(new Node(next.v,distance[next.v]));
				}
			}
		}
		for (int i = 1; i < 1001; i++) {
			if(distance[i] == Integer.MAX_VALUE) continue;
			result[i] += distance[i];
		}
	}
	
	static class Node{
		int v;
		int time;
		
		public Node(int v, int time) {
			this.v = v;
			this.time = time;
		}
	}
}