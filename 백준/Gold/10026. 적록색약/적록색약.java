import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static char[][] map;
	static boolean[][] isVisit;
	static int[][] dirs = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rg = 0;
		int b = 0;
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		isVisit = new boolean[n][n];
		//적록색약
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!isVisit[i][j]) {
					bfs(i,j,true);
					rg++;
				}
			}
		}
		isVisit = new boolean[n][n];
		//적록색약이 아닌사람
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!isVisit[i][j]) {
					bfs(i,j,false);
					b++;
				}
			}
		}
		System.out.println(b + " " + rg);
	}
	
	static void bfs(int y , int x,boolean isRG) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		isVisit[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int[] dir : dirs) {
				int ny = now[0] + dir[0];
				int nx = now[1] + dir[1];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && !isVisit[ny][nx]) {
					if(isRG) {
						if( (map[now[0]][now[1]] == 'R'|| map[now[0]][now[1]] == 'G') && (map[ny][nx] == 'R' || map[ny][nx] == 'G') ) {  
							isVisit[ny][nx] = true;
							q.offer(new int[] {ny,nx});
						}else if(map[now[0]][now[1]] == map[ny][nx]){
							isVisit[ny][nx] = true;
							q.offer(new int[] {ny,nx});
						}
					}else {
						if(map[now[0]][now[1]] == map[ny][nx]) {
							isVisit[ny][nx] = true;
							q.offer(new int[] {ny,nx});
						}
					}
				}
			}
		}
	}
}