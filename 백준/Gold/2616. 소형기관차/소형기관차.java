import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,k,max=0;
	static int[] input;
	static int[][] dp;
	static boolean[] isVisit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		input = new int[n+1];
		dp = new int[4][n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			input[i] += input[i-1];
		}
		//소형 기관차가 끌 수 있는 객차의 수 
		k = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < 4 ; i++) {
			for (int j = i*k; j <= n; j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-k] + (input[j] - input[j-k]));
			}
		}
		
		System.out.println(dp[3][n]);
	}
}