package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon1520 {
    static int[][] dirs = {
            {-1, 0}, // 상
            {1, 0}, // 하
            {0, -1}, // 좌
            {0, 1} // 우
    };
    static int n, m;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        dp = new int[m + 1][n + 1];
        arr = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }


        dfs(1, 1);
        System.out.println(dp[1][1]);

    }

    private static int dfs(int row, int col) {
        if (row == m && col == n) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        } else {
            dp[row][col] = 0;

            for (int[] dir : dirs) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                if (nrow > 0 && ncol > 0 && nrow <= m && ncol <= n && arr[row][col] > arr[nrow][ncol]) {
                    dp[row][col] += dfs(nrow, ncol);
                }
            }
        }
        return dp[row][col];

    }
}
