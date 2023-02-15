import java.io.*;
import java.util.*;
class Solution
{
	static int n,moveCnt,max,room;
	static int[][] map;
	static int[][] dirs = {
			{-1,0},
			{1,0},
			{0,1},
			{0,-1}
	};
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input_d4_정사각형방.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n+1][n+1];
			room = 0;
			max = 0;
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());	
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					move(j,i);
					if(max == moveCnt) {
						if(room > map[i][j])
							room = map[i][j];
					}else if(max < moveCnt) {
						max = moveCnt;
						room = map[i][j];
					}
	
				}
			}
			sb.append("#" + tc + " " + room + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	static void move(int x, int y) {
		moveCnt = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {y,x});
		moveCnt++;
		
		while(!q.isEmpty()) {
			int[] curPoint = q.poll();
			
			for (int[] dir : dirs) {
				int ny = curPoint[0] + dir[0];
				int nx = curPoint[1] + dir[1];
				
				if(isArea(curPoint[1] , curPoint[0] , nx , ny)) {
					q.add(new int[] {ny,nx});
					moveCnt++;
				}
			}
		}
		
	}
	
	static boolean isArea(int x , int y , int nx , int ny) {
		if(nx >= 1 && ny >= 1 && nx <= n & ny <= n && map[ny][nx]-map[y][x] == 1)
			return true;
		return false;
		
	}
}