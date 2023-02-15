import java.io.*;
import java.util.*;

public class Main {
	static int n,s,min=Integer.MAX_VALUE;
	static int[] input;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		input = new int[n+1];
		dp = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dp[i] = dp[i-1] + input[i];
		}
		
		int start=1;
		int end=1;
		//구간합  dp[end] - dp[start-1];
		while(true) {
			if( dp[end] - dp[start-1] < s)
				end++;
			else if(dp[end] - dp[start-1] >= s) {
				if(min > end-start+1)
					min = end -start+1;
				start++;
			}
			
			if(end > n)
				break;
		}
		
		
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}