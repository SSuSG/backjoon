import java.util.*;
import java.io.*;
public class Main {
	static int n,m,k,result=0;
	static int[][] map;
	static Dice dice = new Dice();
	static int[][] dirs = {
			{0,1},
			{1,0},
			{0,-1},
			{-1,0},
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(k-- > 0) {
			//주사위가 이동 방향으로 한 칸 굴러간다. 
			//만약, 이동 방향에 칸이 없다면, 이동 방향을 반대로 한 다음 한 칸 굴러간다.
			while(true) {
				int ny = dice.y + dirs[dice.d][0];
				int nx = dice.x + dirs[dice.d][1];
				
				if(nx >= 1 && ny >= 1 && nx <= m && ny <= n) {
					dice.x = nx;
					dice.y = ny;
					if(dice.d == 0)
						dice.goEast();
					else if(dice.d == 1)
						dice.goSouth();
					else if(dice.d == 2)
						dice.goWest();
					else if(dice.d == 3)
						dice.goNorth();
					
					break;
				}
				dice.changeDirReverse();
			}
			//주사위가 도착한 칸 (x, y)에 대한 점수를 획득한다.
			result += getScore();
			
			//주사위의 아랫면에 있는 정수 A와 주사위가 있는 칸 (x, y)에 있는 정수 B를 비교해 이동 방향을 결정한다.
			/*
			 * A > B인 경우 이동 방향을 90도 시계 방향으로 회전시킨다.
			 * A < B인 경우 이동 방향을 90도 반시계 방향으로 회전시킨다.
			 * A = B인 경우 이동 방향에 변화는 없다.
			 */
			if(dice.six > map[dice.y][dice.x]) 
				dice.changeDirClock();
			else if(dice.six < map[dice.y][dice.x]) 
				dice.changeDirReverseClock();
		}
		System.out.println(result);
	}
	
	static int getScore() {
		int b = map[dice.y][dice.x];
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {dice.y,dice.x});
		boolean[][] isVisit = new boolean[n+1][m+1];
		isVisit[dice.y][dice.x] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int[] dir : dirs) {
				int ny = cur[0] + dir[0];
				int nx = cur[1] + dir[1];
				
				if(nx >= 1 && ny >= 1 && nx <= m && ny <= n && !isVisit[ny][nx] && map[ny][nx] == b) {
					isVisit[ny][nx] = true;
					q.offer(new int[] {ny,nx});
					cnt++;
				}
			}
		}
		return cnt * b;
	}
	
	static class Dice{
		int x;
		int y;
		int d;
		int one;
		int two;
		int three;
		int four;
		int five;
		int six;
		
		public Dice() {
			this.x = 1;
			this.y = 1;
			this.d = 0;
			this.one = 1;
			this.two = 2;
			this.three = 3;
			this.four = 4;
			this.five = 5;
			this.six = 6;
		}
		
		void changeDirReverse() {
			if(d == 0)
				d = 2;
			else if(d == 1)
				d = 3;
			else if(d == 2)
				d = 0;
			else if(d == 3)
				d = 1;
		}
		
		void changeDirClock() {
			if(d == 3)
				d = 0;
			else
				d += 1;
		}
		void changeDirReverseClock() {
			if(d == 0)
				d = 3;
			else
				d -= 1;
		}
		void goEast() {
			int temp = one;
			one = four;
			four = six;
			six = three;
			three = temp;
		}
		void goWest() {
			int temp = one;
			one = three;
			three = six;
			six = four;
			four = temp;
		}
		//남
		void goSouth() {
			int temp = one;
			one = two;
			two = six;
			six = five;
			five = temp;
		}
		void goNorth() {
			int temp = one;
			one = five;
			five = six;
			six = two;
			two = temp;
		}
		
	}
}