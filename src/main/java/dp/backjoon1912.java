package dp;

import java.util.Scanner;

public class backjoon1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if(arr[i] > 0 ){
                if(dp[i-1] < 0 ){
                    dp[i] = arr[i];
                }else{
                    dp[i] = dp[i-1] + arr[i];
                }
                continue;
            }else{
                if(arr[i] > dp[i-1]){
                    dp[i] = arr[i];
                }else{
                    dp[i] = dp[i-1]+arr[i];
                }
            }
        }
        int max = dp[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
