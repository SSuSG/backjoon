import java.io.*;
import java.util.*;

public class Main {
	static int n,e,v1,v2;
	static List<Node>[] graph;
	static int[] distance;
	static boolean[] isVisit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		graph = new List[801];
		for (int i = 0; i < 801; i++) {
			graph[i] = new ArrayList<>();
		}
		int edge=0;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to,weight));
			graph[to].add(new Node(from,weight));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		long case1;
		long case2;
		ds(0);
		case1 = distance[v1];
		case2 = distance[v2];
		
		ds(1);
		case1 += distance[v2];
		case2 += distance[v2];
		
		ds(2);
		case1 += distance[v2];
		case2 += distance[v1];
		long min = Math.min(case1, case2);
		System.out.println(min >= Integer.MAX_VALUE ? "-1" : min);
		
	}
	static void ds(int t) {
		PriorityQueue<Node> pq = new PriorityQueue<>( (o1,o2) -> Integer.compare(o1.w, o2.w));
		distance = new int[801];
		Arrays.fill(distance, Integer.MAX_VALUE);
		isVisit = new boolean[801];
		
		if(t == 0) {
			distance[1] = 0;
			pq.offer(new Node(1,0));
		}else if(t == 1){ 
			distance[v1] = 0;
			pq.offer(new Node(v1,0));
		}else if(t == 2){
			distance[n] = 0;
			pq.offer(new Node(n,0));
		}
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(isVisit[cur.v]) continue;
			isVisit[cur.v] = true;
			
			for (Node next : graph[cur.v]) {
				if(!isVisit[next.v] && distance[next.v] > distance[cur.v] + next.w) {
					distance[next.v] = distance[cur.v] + next.w;
					pq.offer(new Node(next.v,distance[next.v]));
				}
			}
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