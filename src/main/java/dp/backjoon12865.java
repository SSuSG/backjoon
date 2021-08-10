package dp;

import java.util.Scanner;

public class backjoon12865 {
    static class item{
        int w,v;

        public item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        item[] items = new item[n+1];
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i < n; i++) {
            items[i] = new item(sc.nextInt(), sc.nextInt());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k; j++) {
                if(items[i].w <= j){
                    dp[i][j] = items[i].v;
                }
            }
        }


    }
}
