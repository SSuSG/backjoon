import java.io.*;
import java.util.*;

public class Main {
	static int r,c,m;
	static List<Shark> sharkList;
	static Shark[][] map;
	static int result = 0;
	static int[][] dirs = {
			{-1,0}, //상
			{1,0},  //하
			{0,1}, //우
			{0,-1}   //좌
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new Shark[r+1][c+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(c,r,s,d-1,z);
		}
		
		
		for (int i = 1; i <= c; i++) {
			//낚시왕 오른쪽 한 칸 이동 , 가까운 상어 잡기
			for (int j = 1; j <= r ; j++) {
				if(map[j][i] != null) {
					result += map[j][i].z;
					map[j][i] = null;
					break;
				}
			}
			
			//상어 이동
			moveShark();
		}
		
		System.out.println(result);
		
	}
	
	public static void moveShark() {
		Queue<Shark> q = new LinkedList<>();
		
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if(map[i][j] != null) {
					q.add(new Shark(map[i][j].x , map[i][j].y ,map[i][j].s ,map[i][j].d ,map[i][j].z));
				}
			}
		}
		map = new Shark[r+1][c+1];
		
		while(!q.isEmpty()) {
			Shark movingShark = q.poll();
			
			//속력만큼 반복
			for (int i = 0; i < movingShark.s; i++) {
				int ny = movingShark.y + dirs[movingShark.d][0];
				int nx = movingShark.x + dirs[movingShark.d][1];
				
				if(ny >= 1 && nx >= 1 && ny <= r && nx <= c) {
					movingShark.x = nx;
					movingShark.y = ny;
				}else {
					movingShark.changeDir();
					movingShark.y += dirs[movingShark.d][0];
					movingShark.x += dirs[movingShark.d][1];
				}
			}
			
			//이동한 자리에 상어가 있다면?
			if(map[movingShark.y][movingShark.x] != null) {
				if(map[movingShark.y][movingShark.x].z < movingShark.z)
					map[movingShark.y][movingShark.x] = movingShark;
			}else {
				map[movingShark.y][movingShark.x] = movingShark;
			}
		}
	}
	
	public static class Shark{
		int x;
		int y;
		int s;
		//0 : 상
		//1 : 하
		//2 : 우
		//3 : 좌
		int d;
		int z;

		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		public void changeDir() {
			if(d == 0)
				d = 1;
			else if(d == 1)
				d = 0;
			else if(d == 2) 
				d = 3;
			else if(d == 3)
				d = 2;
		}
	}
}