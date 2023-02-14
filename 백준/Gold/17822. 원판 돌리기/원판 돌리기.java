import java.io.*;
import java.util.*;
public class Main {
	static int n,m,t;
	static int numCount = 0;
	static int[][] map;
	static Rotation[] rotateArr;
	static boolean isRemove;
	static boolean[][] isAdjacentAndEqual;
	static int[][] dirs = {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		rotateArr = new Rotation[t];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				numCount++;
			}
		}
		
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			rotateArr[i] = new Rotation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < t; i++) {
			rotate(i);
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
		
	}
	
	static void rotate(int rotationIdx) {
		Rotation rotation = rotateArr[rotationIdx];
		
		//rotation.num 의 배수에 해당하는 원판을 돌린다.
		for (int diskNum = rotation.num; diskNum <=n ; diskNum++) {
			if(diskNum%rotation.num != 0)
				continue;
			
			//d방향으로 k칸 회전
			for (int i = 0; i < rotation.k; i++) {
				if(rotation.d == 0) {
					int temp = map[diskNum][m];
					for (int j = m-1; j >= 1; j--) {
						map[diskNum][j+1] = map[diskNum][j];
					}
					map[diskNum][1] = temp;
				}else {
					int temp = map[diskNum][1];
					for (int j = 2; j <= m; j++) {
						map[diskNum][j-1] = map[diskNum][j];
					}
					map[diskNum][m] = temp;
				}
			}
		}
			
		isAdjacentAndEqual = new boolean[n+1][m+1];
		isRemove = false;
		//원판에 수가 남아 있으면
		if(numCount > 0) {
			//인접하면서 수가 같은 것을 모두 찾는다
			for (int i = 1; i <= n ; i++) {
				for (int j = 1; j <= m; j++) {
					if(map[i][j] != 0)
						checkAdjacentAndEqual(j,i);
				}
			}
			
			//그러한 수가 있는 경우에는 원판에서 인접하면서 같은 수를 모두 지운다.
			if(isRemove) {
				for (int i = 1; i <= n ; i++) {
					for (int j = 1; j <= m; j++) {
						if(isAdjacentAndEqual[i][j]) {
							//System.out.println(i + " " + j);
							map[i][j] = 0;
							numCount--;
						}
					}
				}
			}else {
			//없는 경우에는 원판에 적힌 수의 평균을 구하고, 평균보다 큰 수에서 1을 빼고, 작은 수에는 1을 더한다.
				double avg = 0;
				int sum = 0;
				int count = 0;
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m  ; j++) {
						if(map[i][j] > 0)
							count++;
						sum += (double)map[i][j];
					}
				}

				avg = (double)sum/(count);
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= m; j++) {
						if(avg < map[i][j] && map[i][j] > 0) 
							map[i][j] -= 1;
						else if(avg > map[i][j] && map[i][j] > 0)
							map[i][j] += 1;
						//System.out.print(map[i][j] + " ");
					}
					//System.out.println();
				}
				//System.out.println();
				
				
			}
		}
		
	}
	
	//인접수이면서 동일값인 수를 체크한다.
	static void checkAdjacentAndEqual(int x , int y) {
		for (int[] dir : dirs) {
			int ny = y + dir[0];
			int nx = x + dir[1];
			
			isRemoveAble(x,y,nx, ny);
		}
	}
	
	static void isRemoveAble(int x, int y , int nx , int ny) {
		if(ny < 0 || ny > n)
			return;
		
		if(nx < 1 && map[ny][m] == map[y][x]) {
			isAdjacentAndEqual[y][x] = true;
			isAdjacentAndEqual[ny][m] = true;
			isRemove = true;
		}else if(nx > m && map[ny][1] == map[y][x]) {
			isAdjacentAndEqual[y][x] = true;
			isAdjacentAndEqual[ny][1] = true;
			isRemove = true;
		}else if( 1 <= nx && nx <= m && map[ny][nx] == map[y][x]){
			isAdjacentAndEqual[y][x] = true;
			isAdjacentAndEqual[ny][nx] = true;
			isRemove = true;
		}
	}
	
	static class Rotation{
		int num;
		int d;		//시계 : 0 , 반시계 : 1
		int k;

		public Rotation(int num, int d, int k) {
			this.num = num;
			this.d = d;
			this.k = k;
		}
	}
}
