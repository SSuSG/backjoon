package dp;

import java.util.Scanner;

public class backjoon9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();

        for (int i = 0 ; i < t ; i++){
            int n = sc.nextInt();
            int[] dp = new int[n+1];

            if(n==3){
                sb.append(4);
                sb.append('\n');
            }else if(n==2){
                sb.append(2);
                sb.append('\n');
            }else if(n==1){
                sb.append(1);
                sb.append('\n');
            }else{
                dp[3]=4;
                dp[2]=2;
                dp[1]=1;

                for (int j = 4 ; j <=n ; j++){
                    dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
                }
                sb.append(dp[n]);
                sb.append('\n');
            }

        }
        System.out.println(sb);

    }
}
