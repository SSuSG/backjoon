package dp;

import java.util.Scanner;

public class bakcjoon9461 {
    static long[] dp = new long[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sb.append(wave(n)+"\n");
        }
        System.out.println(sb);
    }

    private static long wave(int n) {
        if(n<=6)
            return dp[n];

        for (int i = 7; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }
        return dp[n];
    }
}
