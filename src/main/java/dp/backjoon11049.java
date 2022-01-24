package dp;

import java.util.Scanner;

public class backjoon11049 {
    static class matrix{
        int r,c;

        public matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        matrix[] arr = new matrix[n+1];
        int[] mul = new int[n+1];
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new matrix(sc.nextInt() , sc.nextInt());
        }
        

        for (int i = 1; i <= n; i++) {
            for (int from = 1; from +i <= n; from++) {
                int to = from + i;
                dp[from][to] = Integer.MAX_VALUE;

                for (int k = from; k < to ; k++) {
                    dp[from][to] = Math.min(dp[from][k] + dp[k + 1][to] + (arr[from].r * arr[k].c * arr[to].c) , dp[from][to]);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
