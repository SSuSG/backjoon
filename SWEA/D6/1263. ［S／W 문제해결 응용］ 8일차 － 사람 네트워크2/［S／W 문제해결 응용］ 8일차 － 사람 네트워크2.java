import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("res/input_사람네트워크2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] dp = new int[n][n];
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
					if(i == j) continue;
					if(dp[i][j] == 0) dp[i][j] = 10000;
				}
			}
			
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					if(k == i) continue;
					for (int j = 0; j < n; j++) {
						if(k == j || i == j) continue;
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					sum += dp[i][j];
				}
				min = Math.min(min, sum);
			}
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.println(sb);
	}
}