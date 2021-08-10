package dp;

import java.util.Scanner;

public class backjoon1003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int temp = sc.nextInt();
            fibo(temp+1);
        }
    }

    private static void fibo(int temp) {
        int[] f = new int[temp];
        int[][] dp = new int[temp][2];
        f[0] = 1;
        dp[0][0]=1;
        if(temp>=2){
            f[1] = 1;
            dp[0][1]=0;
        }
        if(temp>=2){
            dp[1][0]=0;
            dp[1][1]=1;
        }

        for (int i = 2; i < temp; i++) {
            f[i] = f[i-1] + f[i-2];
            dp[i][0]=dp[i-1][0]+dp[i-2][0];
            dp[i][1]=dp[i-1][1]+dp[i-2][1];
        }

        System.out.println(dp[temp-1][0]+" "+dp[temp-1][1]);
    }
}
