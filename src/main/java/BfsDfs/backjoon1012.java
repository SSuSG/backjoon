package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class backjoon1012 {
    static int m , n, k , count=0,ans=0;
    static int arr[][];
    static boolean visit[][];
    static ArrayList<Integer> result;
    static int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            visit = new boolean[n][m];
            result = new ArrayList<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                //b -> row m, x -> col
                arr[b][a] = 1;
            }

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if(arr[a][b] == 1 && visit[a][b] == false) {
                        count++;
                        dfs(a, b);
                        if(count>0) {
                            ans++;
                            count=0;
                        }
                    }

                }
            }

            sb.append(ans+"\n");
            ans =0;
        }

        System.out.println(sb);

    }

    private static void dfs(int row , int col) {
        visit[row][col] = true;

        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (x >= 0 && y >= 0 && x < n && y < m && arr[x][y] == 1 && visit[x][y] == false) {
                dfs(x, y);
            }
        }

    }
}
