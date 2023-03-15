import java.io.*;
import java.util.*;
public class Main {
	static int n,m,min=Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] isVisit;
	static int[][] dirs = {
			{0,1},
			{0,-1},
			{-1,0},
			{1,0}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        isVisit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
        bfs();
        System.out.println(min);
        
	}
	
	static void bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>( (o1,o2) -> o1[2]-o2[2]);
		pq.offer(new int[] {0,0,0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if(cur[0] == n-1 && cur[1] == m-1) {
				min = Math.min(min, cur[2]);
				return;
			}
			
			for (int[] dir : dirs) {
				int ny = cur[0] + dir[0];
				int nx = cur[1] + dir[1];
				
				if(ny >= 0 && nx >= 0 && ny < n && nx < m && !isVisit[ny][nx]) {
					if(map[ny][nx] == 1) {
						isVisit[ny][nx] = true;
						pq.offer(new int[] {ny,nx,cur[2]+1});
					}else {
						isVisit[ny][nx] = true;
						pq.offer(new int[] {ny,nx,cur[2]});
					}
				}
			}
		}
	}
}