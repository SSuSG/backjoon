import java.util.*;
import java.io.*;
public class Main {
	static int n,m,min=Integer.MAX_VALUE;
	static int[][] map;
	static int[][] dirs = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1}
	};
	static boolean[][][] isVisit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map =new int[n+1][m+1];
		// n,m,0 -> 현재 벽을 아직 안부순상태
		// m,m,1 -> 현재 벽을 한번 부순상태
		isVisit = new boolean[n+1][m+1][2]; 
		
		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = input.charAt(j-1)-'0';
			}
		}
		bfs();
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {1,1,0,1});
		isVisit[1][1][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(min < cur[3]) continue;
			if(cur[0] == n && cur[1] == m) {
				min = Math.min(min, cur[3]);
				continue;
			}
			
			for (int[] dir : dirs) {
				int ny = cur[0] + dir[0];
				int nx = cur[1] + dir[1];
				
				if(isArea(nx,ny)) {
					//다음 장소가 벽이라면
					if(map[ny][nx] == 1) {
						//현재 벽을 한번 부순 상태가 아니고 벽을 부순상태로 다음 장소에 방문한 적이 없을경우
						if(cur[2] == 0 && !isVisit[ny][nx][1]) {
							isVisit[ny][nx][1] = true;
							q.offer(new int[] {ny,nx,1,cur[3]+1});
						}
					}else {
						//벽이없으면 내 현재상태를 바탕으로 다음 장소를 방문했는지 확인
						if(!isVisit[ny][nx][cur[2]]) {
							isVisit[ny][nx][cur[2]] = true;
							q.offer(new int[] {ny,nx,cur[2],cur[3]+1});
						}
					}
				}
			}
		}
	}
	
	static boolean isArea(int x, int y) {
		if(x < 1 || y < 1  || x > m || y > n)
			return false;
		return true;
	}
}