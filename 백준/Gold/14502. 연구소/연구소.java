import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static int n,m;
	static int maxSafetyArea;
	static int[][] map;
	static ArrayList<Virus> virus;
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
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		virus = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new Virus(j,i));
				}
			}
		}
		
		dfs(0);
		System.out.println(maxSafetyArea);
	}
	
	public static void dfs(int wallCount) {
		if(wallCount == 3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wallCount + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] copyMap = new int[n][m];
		int safetySum = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		for (Virus v : virus) 
			q.add(new int[] {v.y , v.x});
		
		while(!q.isEmpty()) {
			int[] nowPoint = q.poll();
			
			for (int[] dir : dirs) {
				int ny = nowPoint[0] + dir[0];
				int nx = nowPoint[1] + dir[1];
				
				if(ny >= 0 && nx >= 0 && ny < n && nx < m && copyMap[ny][nx] == 0) {
					copyMap[ny][nx] = 2;
					q.add(new int[] {ny,nx});
				}	
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(copyMap[i][j] == 0)
					safetySum++;
			}
		}
		
		if(maxSafetyArea < safetySum)
			maxSafetyArea = safetySum;
		
	}
	
	public static class Virus{
		int x;
		int y;

		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}