import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int mapSum = 0;
	static int minResult = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		
		for (int i = 1; i <= n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mapSum += map[i][j];
			}
		}
		
		// x,y,d1,d2  구하기
		for (int y = 1; y <= n ; y++) {
			for (int x = 1; x <= n ; x++) {
				for (int d1 = 1; d1 <= n ; d1++) {
					for (int d2 = 1; d2 <= n ; d2++) {
						if(d1+d2+y > n)
							continue;
						if(x+d2 > n || x-d1 < 1)
							continue;
					
						calc(x,y,d1,d2);
					}
				}
			}
		}
		
		System.out.println(minResult);
	}
	
	static void calc(int x, int y , int d1 , int d2) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		int[] sum = new int[6];
		boolean[][] isVisit = new boolean[n+1][n+1];
	
		
		for (int i = y+d1,t=0; i >= y ; i--,t++) {
			for (int j = x-d1+t; j <= x ; j++) {
				isVisit[i][j] = true;
			}
		}
		
		for (int i = y+d2,t=0; i >= y ; i--,t++) {
			for (int j = x+d2-t; j >= x ; j--) {
				isVisit[i][j] = true;
			}
		}
		
		for (int i = y+d1,t=0; i <= y+d1+d2 ; i++,t++) {
			for (int j = x-d1+t; j <= x+d2-d1 ; j++) {
				isVisit[i][j] = true;
			}
		}
		
		for (int i = y+d1+d2 ,t=0; i >= y+d2 ; i--,t++) {
			for (int j = x+d2-d1; j <= x+d2-d1+t ; j++) {
				isVisit[i][j] = true;
			}
		}
		
		//1번 구역
		for (int i = 1; i < y+d1; i++) {
			for (int j = 1; j <= x; j++) {
				if(isVisit[i][j])
					continue;
				sum[1] += map[i][j];
			}
		}
		
		//2번 구역
		for (int i = 1; i <= y+d2; i++) {
			for (int j = x+1; j <= n; j++) {
				if(isVisit[i][j])
					continue;
				sum[2] += map[i][j];
			}
		}
		
		//3번 구역
		for (int i = y+d1; i <= n; i++) {
			for (int j = 1; j < x-d1+d2; j++) {
				if(isVisit[i][j])
					continue;
				sum[3] += map[i][j];
			}
		}

		
		//4번 구역
		for (int i = y+d2+1; i <= n; i++) {
			for (int j = x-d1+d2; j <= n; j++) {
				if(isVisit[i][j])
					continue;
				sum[4] += map[i][j];
			}
		}

		sum[5] = mapSum - (sum[1] + sum[2] + sum[3] + sum[4]);
		Arrays.sort(sum);
		
		if(minResult > sum[5] - sum[1]) {
			minResult = sum[5] - sum[1];
		}
	}
}