import java.util.*;
import java.io.*;
public class Solution {
	static int n,m,min;
	static char[][] map;
	static int[] start,end;
	static boolean[][] isVisit;
	static ArrayDeque<int[]> devilQ;
	static int[][] dirs = {
			{0,-1},
			{1,0},
			{0,1},
			{-1,0}
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        
        for (int tc = 1; tc <= t; tc++) {
			st  =new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			map = new char[n][m];
			devilQ = new ArrayDeque<>();
			isVisit = new boolean[n][m];
			start = new int[2];
			end = new int[2];
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = input.charAt(j);
					if(map[i][j] == 'S') {
						map[i][j] = '.';
						start = new int[] {i,j};
					}
					if(map[i][j] == 'D') end = new int[] {i,j};
					if(map[i][j] == '*') devilQ.add(new int[] {i,j,0});
				}
			}
			bfs();
			sb.append("#" + tc + " " + (min == Integer.MAX_VALUE ? "GAME OVER" : min) + "\n");
        }
        System.out.println(sb);
	}
	
	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start[0] , start[1],0});
		isVisit[start[0]][start[1]] = true;
		
		int time = 0;
		int devilCnt=0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == end[0] && cur[1] == end[1]) {
				min = cur[2];
				return;
			}
			if(devilCnt == cur[2]) {
				spread();
				devilCnt++;
			}
			for (int[] dir : dirs) {
				int ny = cur[0] + dir[0];
				int nx = cur[1] + dir[1];
				if(isArea(nx,ny) && !isVisit[ny][nx] && map[ny][nx] != '*' && map[ny][nx] != 'X') {
					isVisit[ny][nx] = true;
					q.offer(new int[] {ny,nx,cur[2]+1});
				}
			}
			
		}
	}
	static void spread() {
		int size = devilQ.size();
		int count = 0;
		while(count < size) {
			int[] cur = devilQ.poll();
			for (int[] dir : dirs) {
				int ny = cur[0] + dir[0];
				int nx = cur[1] + dir[1];
				
				if(isArea(nx,ny) && map[ny][nx] == '.') {
					map[ny][nx] = '*';
					devilQ.add(new int[] {ny,nx});
				}
			}
			count++;
		}
	}
	
	static boolean isArea(int x, int y) {
		if(x < 0 || y < 0 || x >= m || y >= n )
			return false;
		return true;
	}
}