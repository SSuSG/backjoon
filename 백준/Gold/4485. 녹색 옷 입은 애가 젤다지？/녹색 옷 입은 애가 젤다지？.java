import java.io.*;
import java.util.*;
public class Main {
	static int n,min;
	static int[][] map;
	static boolean[][] isVisit;
	static int[][] dirs = {
	        {1,0},
	        {-1,0},
	        {0,1},
	        {0,-1}
    };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = 1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			min = Integer.MAX_VALUE;
			map = new int[n][n];
			for (int i = 0; i < n; i++) {	
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			sb.append("Problem " + t + ": " + min + "\n");
			t++;
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		isVisit = new boolean[n][n];
		PriorityQueue<Point> pq = new PriorityQueue<>( (o1,o2) -> Integer.compare(o1.rupee, o2.rupee));
		pq.offer(new Point(0,0,map[0][0]));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.rupee >= min)
				break;
			
			if(cur.x == n-1 && cur.y == n-1 && cur.rupee < min) {
				min = cur.rupee;
				continue;
			}
			
			for (int[] dir : dirs) {
				int ny = cur.y + dir[0];
				int nx = cur.x + dir[1];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || isVisit[ny][nx])
					continue;
				
				isVisit[ny][nx] = true;			
				pq.offer(new Point(nx,ny,cur.rupee + map[ny][nx]));
			}
		}
	}
	
	static class Point{
		int x;
		int y;
		int rupee;
		
		public Point(int x, int y, int rupee) {
			this.x = x;
			this.y = y;
			this.rupee = rupee;
		}
	}
}