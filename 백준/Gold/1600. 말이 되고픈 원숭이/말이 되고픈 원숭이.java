import java.util.*;
import java.io.*;
public class Main {
	static int k,w,h,min=Integer.MAX_VALUE;
	static int[][] map,dp;
	static boolean[][][] isVisit;
	static int[][] dirs = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0},
			{-2,1},
			{-2,-1},
			{2,1},
			{2,-1},
			{1,-2},
			{-1,-2},
			{1,2},
			{-1,2}
	};

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		isVisit = new boolean[h][w][k+1];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0,0,0});
		isVisit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == h-1 && cur[1] == w-1) {
				min = Math.min(min, cur[3]);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = cur[0] + dirs[d][0];
				int nx = cur[1] + dirs[d][1];
				
				if(isArea(nx,ny) && !isVisit[ny][nx][cur[2]]) {
					isVisit[ny][nx][cur[2]] = true;
					q.offer(new int[] {ny,nx,cur[2],cur[3]+1});
				}
			}
			
			//k번 횟수가 남았을때
			if(cur[2] < k) {
				for (int d = 4; d < dirs.length; d++) {
					int ny = cur[0] + dirs[d][0];
					int nx = cur[1] + dirs[d][1];
					/*
					if(d < 4 && isArea(nx,ny) && !isVisit[ny][nx][cur[2]]) {
						isVisit[ny][nx][cur[2]] = true;
						q.offer(new int[] {ny,nx,cur[2],cur[3]+1});
						
					}else */
					if(isArea(nx,ny) && !isVisit[ny][nx][cur[2]+1]) {
						isVisit[ny][nx][cur[2]+1] = true;
						q.offer(new int[] {ny,nx,cur[2]+1,cur[3]+1});
					}
				}
			}
		}
	}
	
	static boolean isArea(int x, int y) {
		if(x < 0 || y < 0 || x >= w || y >= h || map[y][x] == 1)
			return false;
		return true;
	}
}