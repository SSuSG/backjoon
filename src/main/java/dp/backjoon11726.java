package dp;

import java.util.Scanner;

public class backjoon11726 {
    static int[] dp;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dp = new int[n+1];

        if(n >= 3){
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i-1]+dp[i-2];
                dp[i] %=10007;
            }
        }else if(n == 2){
            dp[1] = 1;
            dp[2] = 2;
        }else{
            dp[1] = 1;
        }
        System.out.println(dp[n]);
    }
}
