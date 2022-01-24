package dp;

import java.util.Scanner;

public class backjoon10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] dp = new int[n+1];
        if(n==1){
            System.out.println(1);
        }else if(n==0){
            System.out.println(0);
        }else{
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;

            for (int i = 3 ; i <= n ; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            System.out.println(dp[n]);
        }
    }
}
