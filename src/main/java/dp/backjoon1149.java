package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon1149 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        dp = new int[n+1][3];
        int[][] arr = new int[n+1][3];
        for (int i = 1; i <=n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = r;
            arr[i][1] = g;
            arr[i][2] = b;
        }
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + arr[i][2];
        }
        System.out.println(Math.min(Math.min(dp[n][0],dp[n][1]) , dp[n][2]));

    }

}
