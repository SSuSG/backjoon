import java.util.*;
import java.io.*;
public class Main {
	static int n,result = 0;
	static int[][] map;
	static int[][] dirs = {
			{0,-1},
			{1,0},
			{0,1},
			{-1,0}
	};
	//서 , 남 , 동 , 북
	static int[][] dx = {
			{1,1,0,0,-2,0,0,-1,-1,-1},
			{1,-1,2,-2,0,1,-1,1,-1,0},
			{-1,-1,0,0,2,0,0,1,1,1},
			{-1,1,-2,2,0,-1,1,-1,1,0}
	};
	static int[][] dy = {
			{1,-1,2,-2,0,1,-1,1,-1,0},
			{-1,-1,0,0,2,0,0,1,1,1},
			{-1,1,-2,2,0,-1,1,-1,1,0},
			{1,1,0,0,-2,0,0,-1,-1,-1}
	};
	static int[] rate = {
			1,1,2,2,5,7,7,10,10
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
		solve();
		System.out.println(result);
	}
	
	static void solve() {
		int x = n/2;
		int y = n/2;
		
		int moveLen = 1;
		int moveCnt = 0;
		int moveDir = 0;
		int flag = 0;
		while(true) {
			if(x == 0 && y == 0)
				break;
			
			//moveLen만큼 움직였으면 방향을 바꿔야함
			if(moveCnt == moveLen) {
				moveCnt = 0;
				flag++;
				//moveLen만큼 2번 움직였으면 1칸 더 늘림
				if(flag == 2) {
					moveLen++;
					flag = 0;
				}
				if(moveDir == 3)
					moveDir = 0;
				else
					moveDir++;
			}
			
			x += dirs[moveDir][1];
			y += dirs[moveDir][0];
			spread(x,y,moveDir);
			moveCnt++;
		}
	}
	
	static void spread(int x, int y,int d) {
		int minusSum = 0;
		
		for (int i = 0; i <= 9; i++) {
			int nx = x + dx[d][i];
			int ny = y + dy[d][i];
			
			if(!isArea(nx,ny)) {
				if(i == 9) {
					result += map[y][x]-minusSum;
				}else {
					minusSum += (map[y][x]*rate[i])/100;
					result += (map[y][x]*rate[i])/100;
				}
				
				continue;
			}
			if(i == 9) {
				map[y][x] -= minusSum;
				map[ny][nx] += map[y][x];
				map[y][x] = 0;
			}else {
				map[ny][nx] += (map[y][x]*rate[i])/100;
				minusSum += (map[y][x]*rate[i])/100;
			}
		}
	}
	static boolean isArea(int x , int y) {
		if(x < 0 || y < 0 || x >= n || y >= n )
			return false;
		return true;
	}
}