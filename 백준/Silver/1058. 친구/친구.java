import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static int[][] dp;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map =new char[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j);
				if(i==j) continue;
				if(map[i][j] == 'N') dp[i][j] = 987654321;
				if(map[i][j] == 'Y') dp[i][j] = 1;
			}
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if(i == k) continue;
				for (int j = 0; j < n; j++) {
					if(k == j || i == j ) continue;
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
				}
			}
		}
		int maxFreindNum  = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if(i==j) continue;
				if(dp[i][j] <= 2) sum++; 
			}
			maxFreindNum = Math.max(maxFreindNum, sum);
		}
		System.out.println(maxFreindNum);
	}
}