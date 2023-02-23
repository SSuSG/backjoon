import java.util.*;
import java.io.*;
public class Main {
	static int n,m,min=Integer.MAX_VALUE;
	static int[] memory,cost;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		memory = new int[n+1];
		cost = new int[n+1];
		dp = new int[n+1][10001];
		
		st = new StringTokenizer(br.readLine());	
		for (int i = 1; i <= n ; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());	
		for (int i = 1; i <= n ; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		
		for (int i = 1; i <= n ; i++) {
			for (int j = 0; j <= 10000; j++) {
				if(j >= cost[i]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]] + memory[i]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
				
				if(dp[i][j] >= m) {
					min = Math.min(min, j);
				}
			}
		}
		System.out.println(min);
		
	}
}