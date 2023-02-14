import java.io.*;
import java.util.*;

/**
 * 
 * 현재 방향을 기준으로 왼쪽 
 * 상 -> 좌
 * 하 -> 우
 * 좌 -> 하
 * 우 -> 상
 * 상 : 0 , 우 : 1 , 하 : 2 , 좌 : 3
 */
public class Main {
	static int n,m;
	static int[][] map;
	static int cleanRoomCnt =0;
	static boolean[][] isClean;
	static Robot robot;
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
		
		st = new StringTokenizer(br.readLine());
		int robotStartY = Integer.parseInt(st.nextToken());
		int robotStartX = Integer.parseInt(st.nextToken());
		int robotStartD = Integer.parseInt(st.nextToken());
		
		robot = new Robot(robotStartX ,robotStartY , robotStartD);
		isClean = new boolean[n][m];
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					isClean[i][j] = true;
			}
		}
		
		bfs();
		System.out.println(cleanRoomCnt);
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {robot.y , robot.x , robot.d});
		isClean[robot.y][robot.x]= true;
		cleanRoomCnt++;
		
		while(!q.isEmpty()) {
			int[] curRobotPoint = q.poll();
			//System.out.println("현재 좌표 : " + curRobotPoint[0] + " " + curRobotPoint[1] + " " + curRobotPoint[2]);
			
			if(curRobotPoint[2] == 0) {
				//상 -> 좌
				//네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우
				if(isAllClean(curRobotPoint[1], curRobotPoint[0])) {
					if(curRobotPoint[0]+1 >= n || map[curRobotPoint[0]+1][curRobotPoint[1]] == 1) {
						return;
					}
				}
				//네 방향 모두 청소가 이미 되어있거나 벽인 경우
				if(isAllClean(curRobotPoint[1], curRobotPoint[0])) {
					q.add(new int[] {curRobotPoint[0]+1,curRobotPoint[1],0});
					continue;
				}
				
				int ny = curRobotPoint[0] + dirs[2][0];
				int nx = curRobotPoint[1] + dirs[2][1];
				
				//왼쪽 방향에 아직 청소하지 않은 공간이 존재
				if(ny >= 0 && nx >= 0 && ny < n && nx < m && !isClean[ny][nx]) {
					q.add(new int[] {ny,nx,3});
					isClean[ny][nx] = true;
					//System.out.println("다음좌표 : " + ny + " " + nx);
					cleanRoomCnt++;
				}else {
					//왼쪽 방향에 청소할 공간이 없다면
					q.add(new int[] {curRobotPoint[0],curRobotPoint[1],3});
				}
				
				
			}else if(curRobotPoint[2] == 1) {
				//우 -> 상
				//네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우 -> 로봇 작동 중지
				if(isAllClean(curRobotPoint[1], curRobotPoint[0])) {
					if(curRobotPoint[1]-1 < 0 || map[curRobotPoint[0]][curRobotPoint[1]-1] == 1) {
						return;
					}
				}
				//네 방향 모두 청소가 이미 되어있거나 벽인 경우 -> 방향유지한채로 후진
				if(isAllClean(curRobotPoint[1], curRobotPoint[0])) {
					q.add(new int[] {curRobotPoint[0],curRobotPoint[1]-1,1});
					continue;
				}
				
				int ny = curRobotPoint[0] + dirs[0][0];
				int nx = curRobotPoint[1] + dirs[0][1];
				
				//왼쪽 방향에 아직 청소하지 않은 공간이 존재 -> 청소
				if(ny >= 0 && nx >= 0 && ny < n && nx < m && !isClean[ny][nx]) {
					q.add(new int[] {ny,nx,0});
					isClean[ny][nx] = true;
					//System.out.println("다음좌표 : " + ny + " " + nx);
					cleanRoomCnt++;
				}else {
					//왼쪽 방향에 청소할 공간이 없다면 -> 방향 회전
					q.add(new int[] {curRobotPoint[0],curRobotPoint[1],0});
				}

				
			}else if(curRobotPoint[2] == 2) {
				//하 -> 우
				//네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우 -> 로봇 작동 중지
				if(isAllClean(curRobotPoint[1], curRobotPoint[0])) {
					if(curRobotPoint[0]-1 < 0 || map[curRobotPoint[0]-1][curRobotPoint[1]] == 1) {
						return;
					}
				}
				//네 방향 모두 청소가 이미 되어있거나 벽인 경우 -> 방향유지한채로 후진
				if(isAllClean(curRobotPoint[1], curRobotPoint[0])) {
					q.add(new int[] {curRobotPoint[0]-1,curRobotPoint[1],2});
					continue;
				}
				
				int ny = curRobotPoint[0] + dirs[3][0];
				int nx = curRobotPoint[1] + dirs[3][1];
				
				//왼쪽 방향에 아직 청소하지 않은 공간이 존재 -> 청소
				if(ny >= 0 && nx >= 0 && ny < n && nx < m && !isClean[ny][nx]) {
					q.add(new int[] {ny,nx,1});
					isClean[ny][nx] = true;
					//System.out.println("다음좌표 : " + ny + " " + nx);
					cleanRoomCnt++;
				}else {
					//왼쪽 방향에 청소할 공간이 없다면 -> 방향 회전
					q.add(new int[] {curRobotPoint[0],curRobotPoint[1],1});
				}
				
				
			}else if(curRobotPoint[2] == 3) {
				//좌 -> 하
				//네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우 -> 로봇 작동 중지
				if(isAllClean(curRobotPoint[1], curRobotPoint[0])) {
					if(curRobotPoint[1]+1 >= m || map[curRobotPoint[0]][curRobotPoint[1]+1] == 1) {
						return;
					}
				}
				//네 방향 모두 청소가 이미 되어있거나 벽인 경우 -> 방향유지한채로 후진
				if(isAllClean(curRobotPoint[1], curRobotPoint[0])) {
					q.add(new int[] {curRobotPoint[0],curRobotPoint[1]+1,3});
					continue;
				}
				
				int ny = curRobotPoint[0] + dirs[1][0];
				int nx = curRobotPoint[1] + dirs[1][1];
				
				//왼쪽 방향에 아직 청소하지 않은 공간이 존재 -> 청소
				if(ny >= 0 && nx >= 0 && ny < n && nx < m && !isClean[ny][nx]) {
					q.add(new int[] {ny,nx,2});
					isClean[ny][nx] = true;
					//System.out.println("다음좌표 : " + ny + " " + nx);
					cleanRoomCnt++;
				}else {
					//왼쪽 방향에 청소할 공간이 없다면 -> 방향 회전
					q.add(new int[] {curRobotPoint[0],curRobotPoint[1],2});
				}

			}
			

		}
	}
	
	public static boolean isAllClean(int x, int y) {
		for (int[] dir : dirs) {
			int ny = y + dir[0];
			int nx = x + dir[1];
			
			if(ny >= 0 && nx >= 0 && ny < n && nx < m && !isClean[ny][nx]) 
				return false;
		}
		return true;
	}
	
	public static class Robot{
		int x;
		int y;
		int d;

		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}