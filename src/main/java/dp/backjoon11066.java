package dp;

import java.util.*;

public class backjoon11066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int min;
        int smin;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] file = new int[n+1];
            int[][] dp = new int[n+1][n+1];
            int[] sum = new int[n+1];

            for (int j = 1; j <= n; j++) {
                file[j] = sc.nextInt();
                sum[j] = sum[j-1] + file[j];
            }

            for (int k = 1; k <= n; k++) {
                for (int from = 1; from + k <= n; from++) {
                    int to = from + k;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            System.out.println(dp[1][n]);

        }
    }
}
