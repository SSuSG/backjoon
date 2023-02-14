import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m,h;
	static int[][] map;
	static boolean isFinish = false;
	static int curRowLineNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 세로선의 개수
		n = Integer.parseInt(st.nextToken());
		
		// 가로선의 개수
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h+1][n+1];
		
		// 0 : 가로선 없음
		// 1 : 왼쪽으로 가는 선 있음
		// 2 : 오른쪽으로 가는 선 있음
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			map[row][col] = 2;
			map[row][col+1] = 1;
		}
		
		for (int i = 0; i < 4; i++) {
			curRowLineNum = i;
			dfs(0);
			if(isFinish) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
	}
	
	public static void dfs(int rowLineNum) {
		if(curRowLineNum == rowLineNum) {
			if(isValidLadder()) 
				isFinish = true;
			return;
		}
		
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j < n; j++) {
				if(map[i][j] == 0 && map[i][j+1] == 0) {
					map[i][j] = 2;
					map[i][j+1] = 1;
					
					dfs(rowLineNum+1);
					
					map[i][j] = 0;
					map[i][j+1] = 0;
				}
			}
		}
	}
	
	public static boolean isValidLadder() {
		
		for (int i = 1; i <= n; i++) {
			int nx = i;
			int ny = 1;
			
			while(ny <= h) {
				if(map[ny][nx] == 1)
					nx--;
				else if(map[ny][nx] == 2)
					nx++;
				ny++;
			}
			if(nx != i)
				return false;
		}
		return true;
	}
}
