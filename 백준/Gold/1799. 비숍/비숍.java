import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,max=0;
	static int[][] map;
	static int[][] dirs = {
			{-1,-1},
			{-1,1}
	};
	static int[] res = new int[2];
	static boolean[][] color,isVisit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		color = new boolean[n][n];
		isVisit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				color[i][j] = (i%2 == 0 && j%2 == 0) || (i%2 != 0 && j%2 != 0);
			}
		}
		
		dfs(0,true,0);
		dfs(0,false,0);
		System.out.println(res[0] + res[1]);
	}
	
	static void dfs(int index , boolean isBlack ,int cnt ) {
		for (int i = index; i < n*n; i++) {
			int y = i/n;
			int x = i%n;
			
			if(color[y][x] != isBlack || map[y][x] == 0 || !isValid(x,y)) continue;
			
			isVisit[y][x] = true;
			dfs(i+1,isBlack,cnt+1);
			isVisit[y][x] = false;
		}
		res[isBlack ? 0 : 1] = Math.max(res[isBlack ? 0 : 1], cnt);
	}
	
	static boolean isValid(int x, int y) {
		for (int[] dir : dirs) {
			int ny = y;
			int nx = x;
			
			while(true) {
				if(nx < 0 || ny < 0 || nx >= n || ny >= n)
					break;
				if(isVisit[ny][nx])
					return false;
				ny += dir[0];
				nx += dir[1];
			}
		}
		return true;
	}
}