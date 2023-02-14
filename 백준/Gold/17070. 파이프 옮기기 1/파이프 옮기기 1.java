import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int map[][];
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(2,1,0);
		System.out.println(result);
	}
	
	//가로 0
	//세로 1
	//대각 2
	public static void dfs(int x, int y , int dir) {
		if(x == n && y == n) {
			result++;
			return;
		}

		if(dir == 0) {
			if(isArea(x+1,y) && map[y][x+1] != 1)
				dfs(x+1,y,0);
			if(isArea(x+1,y+1) && isArea(x,y+1) && isArea(x+1,y) && map[y][x+1] != 1 && map[y+1][x] != 1 && map[y+1][x+1] != 1)
				dfs(x+1,y+1,2);
		}else if(dir == 1) {
			if(isArea(x,y+1) && map[y+1][x] != 1)
				dfs(x,y+1,1);
			if(isArea(x+1,y+1) && isArea(x,y+1) && isArea(x+1,y) && map[y][x+1] != 1 && map[y+1][x] != 1 && map[y+1][x+1] != 1)
				dfs(x+1,y+1,2);
		}else if(dir == 2) {
			if(isArea(x+1,y) && map[y][x+1] != 1)
				dfs(x+1,y,0);
			if(isArea(x,y+1) && map[y+1][x] != 1)
				dfs(x,y+1,1);
			if(isArea(x+1,y+1) && isArea(x,y+1) && isArea(x+1,y) && map[y][x+1] != 1 && map[y+1][x] != 1 && map[y+1][x+1] != 1)
				dfs(x+1,y+1,2);
			
		}
	}
	
	public static boolean isArea(int x, int y) {
		if(x >= 1 && y >= 1 && x <= n && y <= n)
			return true;
		return false;
	}
}