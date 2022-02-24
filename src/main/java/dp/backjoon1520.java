package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n+1][m+1];
        arr = new int[n+1][m+1];
        for (int i = 1; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=m; j++) {
                dp[i][j] = -1;
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(1,1));

    }

    public static int dfs(int x , int y){
        if(x == n && y == m)
            return 1;

        if(dp[x][y] != -1) {
            return dp[x][y];
        }else{
            dp[x][y] = 0;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 1 && ny >= 1 && nx <= n && ny <=m && arr[nx][ny] < arr[x][y] ){
                    dp[x][y] += dfs(nx,ny);
                }
            }
        }
        return dp[x][y];



    }
}
