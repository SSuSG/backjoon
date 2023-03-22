import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static int[][] map,move;
	static List<int[]> clouds = new ArrayList<>();
	static List<int[]> cloudCopy;
	static int[][] dirs = {
			{0,-1},
			{-1,-1},
			{-1,0},
			{-1,1},
			{0,1},
			{1,1},
			{1,0},
			{1,-1}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		move = new int[m][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			//방향
			move[i][0] = Integer.parseInt(st.nextToken())-1;
			//이동 칸 수
			move[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//구름 생성
		clouds.add(new int[] {n,1});
		clouds.add(new int[] {n,2});
		clouds.add(new int[] {n-1,1});
		clouds.add(new int[] {n-1,2});
		
		for (int i = 0; i < m; i++) {
			//구름 이동
			cloudMove(move[i]);
			//구름 위치에 따른 비가 내린다.
			rain();
			//구름이 사라진다.
			//물복사버그 마법(이전 구름의 위치에서)
			waterCopy();
			//모든 맵에 바구니에 물이 2이상인 경우 구름이 생긴다
			//(직전 구름이 있던 곳에는 구름이 생기지 않음)
			makeCloud();
		}
		System.out.println(getResult());
	}
	
	static void waterCopy() {
		List<int[]> result = new ArrayList<>();
		for (int[] cloud : clouds) {
			int sum = 0;
			//대각선 방향에 물이 있는 바구니 만큼 물의양 증가
			for (int i = 1; i <= 7 ; i+=2) {
				int ny = cloud[0] + dirs[i][0];
				int nx = cloud[1] + dirs[i][1];
				
				if(!isArea(nx,ny)) continue;
				if(map[ny][nx] > 0)
					sum++;
			}
			if(sum > 0) {
				result.add(new int[] {cloud[0],cloud[1],sum});
			}
		}
		for (int[] r : result) {
			map[r[0]][r[1]] += r[2];
		}
	}
	
	static void rain() {
		for (int[] cloud : clouds) {
			map[cloud[0]][cloud[1]]++;
		}
	}
	
	static void cloudMove(int[] move) {
		int[] dir = dirs[move[0]];
		int s = move[1];
		
		for (int[] cloud : clouds) {
			//거리만큼 이동
			for(int i = 0 ; i < s ; i++) {
				int ny = cloud[0] + dir[0];
				int nx = cloud[1] + dir[1];
				
				if(nx < 1)
					cloud[1] = n;
				else if(nx > n)
					cloud[1] = 1;
				else 
					cloud[1] = nx;
				
				if(ny < 1)
					cloud[0] = n;
				else if(ny > n)
					cloud[0] = 1;
				else 
					cloud[0] = ny;
			}
		}
	}
	
	static void makeCloud() {
		boolean[][] isCloud = new boolean[n+1][n+1];
		for (int[] cloud : clouds) {
			isCloud[cloud[0]][cloud[1]] = true;
		}
		clouds = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(!isCloud[i][j] && map[i][j] >= 2 ) {
					clouds.add(new int[] {i,j});
					map[i][j] -= 2;
				}
			}
		}
		
	}
	
	static boolean isArea(int x,  int y) {
		if(x < 1 || y < 1 || x > n || y > n)
			return false;
		return true;
	}
	
	static int getResult() {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n ; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}
}