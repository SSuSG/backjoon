import java.io.*;
import java.util.*;

public class Main {
	static int n,m,t,s,g,h,tc;
	static int[] target;
	static List<Node>[] graph;
	static int[] distG,distH,distStart;
	static boolean[] isVisit;
	static boolean isPath;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int w = 0; w < tc; w++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			graph = new List[2001];
			target = new int[t];
			distStart = new int[2001];
			distG = new int[2001];
			distH = new int[2001];
			
			for (int i = 0; i < 2001; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				graph[from].add(new Node(to,weight));
				graph[to].add(new Node(from,weight));
			}
			
			for (int i = 0; i < t; i++) {
				target[i] = Integer.parseInt(br.readLine());
			}
			isPath = false;
			ds(s,distStart);
			boolean path = isPath;
			ds(g,distG);
			Set<Integer> result = new TreeSet<>();
			
			//s에서 g까지 가는길에 h를 거쳤다면 g에서 도착후보지들을 비교 s -> h -> g -> 도착후보지
			if(path) {
				int startToG = distStart[g];
				
				for (int i = 0; i < t; i++) {
					int dest = target[i];
					if(startToG + distG[dest] == distStart[dest]) {
						result.add(dest);
					}
				}
				
			}else {
				//s에서 g까지 가는길에 h를 거치지 못했다면 s -> g -> h -> 도착후보지
				ds(h,distH);
				int startToH = distStart[g] + distG[h];
				
				for (int i = 0; i < t; i++) {
					int dest = target[i];
					if(startToH + distH[dest] == distStart[dest]) {
						result.add(dest);
					}
				}
			}
			
			for (int i : result) {
				sb.append(i + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void ds(int start ,int[] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>( (o1,o2) -> Integer.compare(o1.w, o2.w));
		isVisit = new boolean[2001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(isVisit[cur.v]) continue;
			isVisit[cur.v] = true;
			
			for (Node next : graph[cur.v]) {
				if(!isVisit[next.v] && dist[next.v] > dist[cur.v] + next.w) {
					if( (next.v == g && cur.v == h ))
						isPath=true;
					
					dist[next.v] = dist[cur.v] + next.w;
					pq.offer(new Node(next.v,dist[next.v]));
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