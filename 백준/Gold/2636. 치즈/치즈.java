import java.io.*;
import java.util.*;

public class Main {
	static int n,m,cheezeCnt =0 ,time = 0,answer;
	static int[][] map;
	static boolean[][] isVisit;
	static boolean[][] isRemove;
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
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) cheezeCnt++;
			}
		}
        
        while(cheezeCnt > 0 ) {
        	time++;
        	answer = cheezeCnt;
        	isVisit = new boolean[n][m];
        	isRemove = new boolean[n][m];
        	//치즈 녹이기
        	removeCheeze();
        }
        System.out.println(time);
        System.out.println(answer);
	}
	
	static void removeCheeze() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0});
		isVisit[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int[] dir : dirs) {
				int ny = cur[0] + dir[0];
				int nx = cur[1] + dir[1];
				
				if(isArea(nx,ny) && !isVisit[ny][nx]) {
					if(map[ny][nx] == 1) {
						isRemove[ny][nx] = true;
						isVisit[ny][nx] = true;
					}else if(map[ny][nx] == 0){
						isVisit[ny][nx] = true;
						q.offer(new int[] {ny,nx});
					}
				}
			}
		}

		//방문처리가 된곳을 0으로 만들어주면서 치즈카운트 감소
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(isRemove[i][j]) {
					map[i][j] = 0;
					cheezeCnt--;
				}
			}
		}
	}
	
	static boolean isArea(int x, int y) {
		if(x < 0 || y < 0 || x >= m || y >= n)
			return false;
		return true;
	}
}