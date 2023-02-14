import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[][] input;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		input = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		
		for (int i = 1; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <=n ; i++) 
			dp[i][1] = input[i][1];
		
		for (int i = 1; i <=n ; i++) {
			for (int j = 2; j <= n; j++) {
				dp[i][j] = dp[i][j-1] + input[i][j];
			}
		}
		
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for (int i = x1; i <= x2; i++) {
				sum += (dp[i][y2] - dp[i][y1-1]);
			}
			sb.append(sum+"\n");
		}
		
		System.out.println(sb);
	}
}