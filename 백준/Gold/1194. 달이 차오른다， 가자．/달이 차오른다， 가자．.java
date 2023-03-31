import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[][][] isVisit;
	static int n,m,min=Integer.MAX_VALUE;
	static int[] start;
	static int[][] dirs = {
			{0,1},
			{0,-1},
			{1,0},
			{-1,0}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        isVisit = new boolean[n][m][64];
        
        for (int i = 0; i < n; i++) {
        	String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == '0')  start = new int[] {i,j};
			}
		}
        
        bfs();
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start[0],start[1],0,0});
		isVisit[start[0]][start[1]][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			//System.out.println(cur[0] + " " + cur[1]);
			if(map[cur[0]][cur[1]] == '1' ) {
				min = Math.min(min, cur[2]);
				continue;
			}
			
			for (int[] dir : dirs) {
				int ny = cur[0] + dir[0];
				int nx = cur[1] + dir[1];
				
				//방문한적있거나 벽이거나 범위 밖이면 continue
				if(!isArea(nx,ny,cur[3])) continue;
				
				//열쇠면
				if(map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
					//cur[3](key)의 map[ny][nx]-'a' 번째 비트를 1로 바꿈
					int tempKey = 1 << (map[ny][nx]-'a') | cur[3];
					if(!isVisit[ny][nx][tempKey]) {
						isVisit[ny][nx][tempKey] = true;
						q.offer(new int[] {ny,nx,cur[2]+1,tempKey});
					}
					
				}else if(map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
					//문이면
					//cur[3]의 map[ny][nx]-'A'번째 비트가 1인지 확인
					
					int hasKey = 1 << (map[ny][nx]-'A') & cur[3];
					
					//0보다 크면 문과 일치하는 키를 가지고있음
					if(hasKey > 0) {
						isVisit[ny][nx][cur[3]] = true;
						q.offer(new int[] {ny,nx,cur[2]+1,cur[3]});
					}
					
				}else {
					isVisit[ny][nx][cur[3]] = true;
					q.offer(new int[] {ny,nx,cur[2]+1,cur[3]});
				}
			}
		}
	}
	
	static boolean isArea(int x, int y , int key) {
		if(x < 0 || y < 0 || x >= m || y >= n || map[y][x] == '#' || isVisit[y][x][key])
			return false;
		return true;
	}
}