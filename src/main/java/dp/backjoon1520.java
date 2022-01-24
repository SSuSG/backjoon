package dp;

import java.util.Scanner;

public class backjoon1520 {
    static int[][] dirs = {
            {-1,0}, // 상
            {1,0}, // 하
            {0,-1}, // 좌
            {0,1} // 우
    };
    static int n ,m;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        arr = new int[m+1][n+1];
        dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(1,1));


    }

    public static int dfs(int x , int y){

        if(x == m && y == n)
            return 1;

        if(dp[x][y] != -1){
            return dp[x][y];
        }else{
            dp[x][y] = 0;
            for (int[] dir : dirs) {
                int nx = x+dir[0];
                int ny= y+dir[1];

                if(nx <1 || ny < 1 || nx > m || ny >n)
                    continue;

                if(arr[nx][ny] < arr[x][y]){ //갈수있다면
                    dp[x][y] += dfs(nx,ny);
                }
            }
        }


        return dp[x][y];

    }
}
