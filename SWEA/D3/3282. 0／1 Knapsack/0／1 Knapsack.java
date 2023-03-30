import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] items = new int[n+1][2];
			int[][] dp = new int[n+1][k+1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				//무게
				items[i][0] = Integer.parseInt(st.nextToken());
				//가치
				items[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= k; j++) {
					if(items[i][0] > j) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]] + items[i][1]);
					}
				}
			}
			
			sb.append("#" + tc + " " + dp[n][k] + "\n");
		}
		System.out.println(sb);
	}
}