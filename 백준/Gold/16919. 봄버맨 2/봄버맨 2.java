import java.io.*;
import java.util.*;
public class Main {
	static int r,c,n;
	static char[][] map;
	static int[][] bombTime;
	static int[][] dirs = {
			{0,-1},
			{1,0},
			{0,1},
			{-1,0}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		bombTime = new int[r][c];
		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'O') bombTime[i][j] = 3;
			}
		}
		int time = 0;
		if(n >= 3) n = n%4 + 4;
		while(time++ < n) {
			//1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치
			if(time%2 == 0) {
				install(time);
			}else if(time%2 == 1) {
			//1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발
				bomb(time);
			}
		}
		
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	
	static void install(int time) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] == '.') {
					map[i][j] = 'O';
					bombTime[i][j] = time+3;
				}
			}
		}
	}
	static void bomb(int time) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				//사방탐색
				if(bombTime[i][j] == time) {
					map[i][j] = '.';
					
					for (int[] dir : dirs) {
						int ny = i + dir[0];
						int nx = j + dir[1];
						
						if(!isArea(nx,ny)) continue;
						if(map[ny][nx] == 'O' && bombTime[i][j] != bombTime[ny][nx]) {
							map[ny][nx] = '.';
							bombTime[ny][nx] = 0;
						}
					}
				}
			}
		}
	}
	
	static boolean isArea(int x, int y) {
		if(x < 0 || y < 0 || x >= c || y >= r) 
			return false;
		return true;
	}
}