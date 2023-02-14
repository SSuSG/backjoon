import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] input;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		input = new int[n+1];
		dp = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) 
			 input[i] = Integer.parseInt(st.nextToken());
		
		dp[1] = input[1];
		for (int j = 2; j <= n ; j++) {
			dp[j] = dp[j-1] + input[j];
		}
		
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			sum = dp[j] - dp[i-1];
			sb.append(sum+"\n");
		}

		System.out.println(sb);
	}
}