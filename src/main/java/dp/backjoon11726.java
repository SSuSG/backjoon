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
                dp[i] = cal(i);
            }
        }else if(n == 2){
            dp[1] = 1;
            dp[2] = 2;
        }else{
            dp[1] = 1;
        }

        System.out.println(dp[n]);

    }

    private static int cal(int i) {
        int result = 0;
        for (int j = 1; j < i ; j++) {
            result += (dp[j]%10007)*(dp[i-j]%10007);
        }
        return result%10007;
    }
}
