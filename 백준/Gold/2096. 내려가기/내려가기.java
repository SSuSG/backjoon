import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] map = new int[n][3];
		int[][] minDp = new int[n][3];
		int[][] maxDp = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0 ) {
					maxDp[i][j] = minDp[i][j] = map[i][j];
				}
			}
		}
		
		for(int i = 1 ; i < n ; i++) {
			for (int j = 0; j < 3; j++) {
				if(j == 0) {
					minDp[i][j] = Math.min(minDp[i-1][j],minDp[i-1][j+1]) + map[i][j];
					maxDp[i][j] = Math.max(maxDp[i-1][j],maxDp[i-1][j+1]) + map[i][j];
				}else if(j == 2) {
					minDp[i][j] = Math.min(minDp[i-1][j],minDp[i-1][j-1]) + map[i][j];
					maxDp[i][j] = Math.max(maxDp[i-1][j],maxDp[i-1][j-1]) + map[i][j];
				}else {
					minDp[i][j] = Math.min(Math.min(minDp[i-1][j],minDp[i-1][j+1]),minDp[i-1][j-1]) + map[i][j];
					maxDp[i][j] = Math.max(Math.max(maxDp[i-1][j],maxDp[i-1][j+1]),maxDp[i-1][j-1]) + map[i][j];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0 ; i < 3 ; i++) {
			min = Math.min(min, minDp[n-1][i]);
			max = Math.max(max, maxDp[n-1][i]);
		}
		System.out.println(max + " " + min);
	}
}