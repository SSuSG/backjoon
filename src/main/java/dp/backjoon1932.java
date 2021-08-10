package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [][] arr = new int[n][n];
        int [][] dp = new int[n][n];


        for (int i = 0; i < n; i++) {
            int j=0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j==0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
                }
            }
        }
        int max = dp[n-1][0] ;
        for (int i = 1; i < n; i++) {
            max = Math.max(dp[n-1][i],max);
        }
        System.out.println(max);

    }
}
