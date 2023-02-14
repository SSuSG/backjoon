import java.io.*;
import java.util.*;

public class Main {
	static int sharkSize = 2;
	static int eatedFishNumByShark = 0;
	static int nearFishX;
	static int nearFishY;
	static int nearDistance = 0;
	static int[] sharkPoint;
	static int[][] map;
	static int[][] dist;
	static int n;
	static int time = 0;
	static int[][] dirs = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if( map[i][j] == 9 ) {
					sharkPoint = new int[] {i,j};
					map[i][j] = 0;
				}
			}
		}
		
		while(true) {
			dist = new int[n][n];
			nearDistance = Integer.MAX_VALUE;
			nearFishY = Integer.MAX_VALUE;
			nearFishX = Integer.MAX_VALUE;
			
			bfs();
			if(nearFishX == Integer.MAX_VALUE)
				break;
			
			//먹을 물고기가  존재
			map[nearFishY][nearFishX] = 0;
			eatedFishNumByShark++;
			if(eatedFishNumByShark == sharkSize) {
				sharkSize++;
				eatedFishNumByShark = 0;
			}
			
			sharkPoint[0] = nearFishY;
			sharkPoint[1] = nearFishX;
			time += nearDistance;
		}
		
		System.out.println(time);
	}
	
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {sharkPoint[0] , sharkPoint[1]});
		
		while(!q.isEmpty()) {
			int[] curPoint = q.poll();
			
			for (int[] dir : dirs) {
				int ny = curPoint[0] + dir[0];
				int nx = curPoint[1] + dir[1];
				
				if(isArea(nx, ny) && isMoveAble(nx, ny) && dist[ny][nx] == 0) {
					dist[ny][nx] = dist[curPoint[0]][curPoint[1]] + 1;
					if(isEatAble(nx, ny)) {
						if(nearDistance > dist[ny][nx]) {
							nearDistance = dist[ny][nx];
							nearFishY = ny;
							nearFishX = nx;
							
						}else if(nearDistance == dist[ny][nx]) {
							if(nearFishY == ny) {
								if(nearFishX > nx)
									nearFishX = nx;
							}else if(nearFishY > ny) {
								nearFishY = ny;
								nearFishX = nx;
							}
						}
					}
					q.add(new int[] {ny,nx});
				}
			}
			
		}
	}
	
	public static boolean isArea(int x, int y) {
		if(x >= 0 && y >= 0 && x < n && y < n)
			return true;
		return false;
	}
	
	public static boolean isMoveAble(int x,  int y) {
		if(map[y][x] <= sharkSize)
			return true;
		return false;
	}
	
	public static boolean isEatAble(int x , int y) {
		if( map[y][x] != 0  && map[y][x] < sharkSize)
			return true;
		return false;
	}
	
	public static class Fish{
		int x;
		int y;
		int v;

		public Fish(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}
	
	
}