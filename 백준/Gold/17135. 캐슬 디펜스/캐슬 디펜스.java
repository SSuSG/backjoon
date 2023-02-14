import java.io.*;
import java.util.*;

public class Main {
	static int n,m,d;
	static int[][] map;
	static int[] archerIdxArr;
	static int[][] copyMap;
	static boolean[][] isVisit;
	static int maxRemoveEnemy = 0;
	static int removeEnemy = 0;
	static int[][] dirs = {
			{-1,0},
			{0,1},
			{0,-1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m];
		copyMap = new int[n+1][m];
		archerIdxArr = new int[m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copyMap[i][j] = map[i][j];
			}
		}
		
		

		selectArcher(0,0);
		//궁수위치를 순열로 정한다
		//궁수 위치를 고정하고 게임시작
		//궁수가 적을 제거 (마킹 -> isVisit배열 사용?) // 이때 공격거리 안에 있어야됌 / 거리가 같으면 가장 왼쪽적을 공격
		//모든 궁수가 적을 쏘고 마킹된 적은 사라진다.
		//적은 한칸씩 내려온다 / 이때 n+1행에 온 적은 사라진다. -> 복사맵을 사용
		System.out.println(maxRemoveEnemy);
		
	}
	
	public static void selectArcher(int startIdx , int depth) {
		if(depth == 3) {
			removeEnemy = 0;
			
			//최대 n번 반복한다
			for (int a = 0; a < n; a++) {
				isVisit = new boolean[n+1][m];
				//각 궁수의 최소거리 위치 적을 찾는다.
				for (int i = 0; i < 3; i++) {
					int archerIdx = archerIdxArr[i];
					int minD = Integer.MAX_VALUE;
					int minX = Integer.MAX_VALUE;
					int minY = Integer.MAX_VALUE;
					
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < m; k++) {
							if(map[j][k] == 1) {
								int distance = calcDistance(k, j, archerIdx, n);

								if(minD == distance && distance <= d) {
									if(minX > k) {
										minX = k;
										minY = j;
									}
								}else if(minD > distance && distance <= d){
									minX = k;
									minY = j;
									minD = distance;
								}
							}
						}
					}
					//궁수가 공격할 적 마킹
					if(minY != Integer.MAX_VALUE && minX != Integer.MAX_VALUE)
						isVisit[minY][minX] = true;
					
				}
				
				//적을 죽인다.
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if(isVisit[i][j]) {
							map[i][j] = 0;
							removeEnemy++;
						}
					}
				}
				
				//적이 한칸씩 내려온다.
				for (int i = n-2; i >= 0; i--) {
					for (int j = 0; j < m; j++) {
						map[i+1][j] = map[i][j];
						if(i == 0)
							map[i][j] = 0;
					}
				}

			}
			if(maxRemoveEnemy < removeEnemy)
				maxRemoveEnemy = removeEnemy;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = copyMap[i][j];
				}
			}
			
			return;
		}
		
		for (int i = startIdx; i < m; i++) {
			archerIdxArr[depth] = i;  
			selectArcher(i + 1 , depth + 1);
		}
	}
	
	public static int calcDistance(int x1 , int y1 , int x2 , int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
	
}