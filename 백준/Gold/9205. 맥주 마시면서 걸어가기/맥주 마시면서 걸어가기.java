import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static boolean isArrive;
	static int[][] store;
	static boolean[] isVisit;
	static List<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine())+2;
			store = new int[n][2];
			isVisit = new boolean[n];
			list = new ArrayList<>();
			isArrive = false;
			for (int i = 0; i < n; i++) {
				list.add(new ArrayList<>());
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					float dist = (float)(getDistance(store[i][1], store[i][0], store[j][1], store[j][0])/50.0);
					if(dist <= 20) {
						list.get(i).add(j);
						list.get(j).add(i);
					}
				}
			}
			bfs();
			if(isArrive) sb.append("happy\n");
			else sb.append("sad\n");
			
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(0);
		isVisit[0] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == n-1) {
				isArrive = true;
				return;
			}
			
			for (Integer next : list.get(cur)) {
				if(isVisit[next]) continue;
				isVisit[next] = true;
				q.offer(next);
			}
		}
	}
	
	static int getDistance(int x1, int y1 , int x2 , int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
}