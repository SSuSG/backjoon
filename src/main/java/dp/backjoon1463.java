package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        if(n >= 3){
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 1;
        }else if(n == 2){
            dp[1] = 0;
            dp[2] = 1;
        }else if(n ==1){
            dp[1] = 0;
        }

        for (int i = 4; i <= n; i++) {
            if(i%3==0 && i%2==0){
                dp[i] = Math.min(Math.min(dp[i/3] , dp[i-1]) , dp[i/2]) +1;
            } else if(i%3==0){
                dp[i] = Math.min(dp[i/3] , dp[i-1]) +1;
            }else if(i%2==0){
                dp[i] = Math.min(dp[i/2] , dp[i-1]) +1;
            }else{
                dp[i] = dp[i-1] +1;
            }
        }
        System.out.println(dp[n]);
    }
}
