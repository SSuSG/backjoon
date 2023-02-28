import java.io.*;
import java.util.*;
public class Main {
	static int n,result = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] isVisit;
	static int[][] dirs = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					result = Math.min(result, bfs(j,i));
				}
			}
		}
        System.out.println(result);
	}
	
	static int bfs(int x, int y) {
		isVisit = new boolean[n][n];
		ArrayDeque<int[]> qu = new ArrayDeque<>();
		qu.offer(new int[] {y,x,0});
		isVisit[y][x] = true;
		
		//같은섬을 방문처리 해준다.
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			
			for (int[] dir : dirs) {
				int ny = cur[0] + dir[0];
				int nx = cur[1] + dir[1];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[ny][nx] == 1 && !isVisit[ny][nx]) {
					isVisit[ny][nx] = true;
					qu.offer(new int[] {ny,nx,cur[2]+1});
				}
			}
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x,0});
		
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cnt > 0) {
				if(min < cur[2])
					return min;
				
				for (int[] dir : dirs) {
					int ny = cur[0] + dir[0];
					int nx = cur[1] + dir[1];
					
					if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[ny][nx] == 1 && !isVisit[ny][nx]) {
						min = Math.min(min, cur[2]);
						break;
					}
				}
			}
			
			for (int[] dir : dirs) {
				int ny = cur[0] + dir[0];
				int nx = cur[1] + dir[1];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[ny][nx] == 0 && !isVisit[ny][nx]) {
					isVisit[ny][nx] = true;
					q.offer(new int[] {ny,nx,cur[2]+1});
				}
			}
			cnt++;
		}
		return min;
	}
}