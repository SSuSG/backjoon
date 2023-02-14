import java.io.*;
import java.util.*;

public class Main {
	static int n,l,r;
	static int[][] map;
	static boolean[][] isVisit;
	static boolean isMove;
	static int result = 0;
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
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			isMove = false;
			isVisit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(!isVisit[i][j])
						openBorderLine(j,i);
				}
			}
			
			if(!isMove)
				break;
			
			result++;
		}
		
		System.out.println(result);
	}
	
	public static void openBorderLine(int x , int y) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> visitList = new ArrayList<>();
		
		int withPeopleNum = 0;
		int withCanNum = 0;
		q.add(new int[] {y,x});
		visitList.add(new int[] {y,x});
		isVisit[y][x] = true;
		
		while(!q.isEmpty()) {
			int[] curPoint = q.poll();
			
			withPeopleNum += map[curPoint[0]][curPoint[1]];
			withCanNum += 1;
			
			for (int[] dir : dirs) {
				int ny = dir[0] + curPoint[0];
				int nx = dir[1] + curPoint[1];
				
				if(ny >= 0 && nx >= 0 && ny < n && nx < n && !isVisit[ny][nx]) {
					if( l <= Math.abs( map[curPoint[0]][curPoint[1]] - map[ny][nx] ) && Math.abs( map[curPoint[0]][curPoint[1]] - map[ny][nx] ) <= r) {
						q.add(new int[] {ny,nx});
						visitList.add(new int[] {ny,nx});
						isVisit[ny][nx] = true;
						isMove = true;
					}
				}
			}
		}
		
		int avgPeopleNum = withPeopleNum/withCanNum;
		
		
		for (int[] visitCan : visitList) {
			map[visitCan[0]][visitCan[1]] = avgPeopleNum;
		}
	}
}