import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] input = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(br.readLine());
			dp[i] = 1;
		}
		
		int max = dp[1];
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if(input[i] > input[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(n - max);
	}
}