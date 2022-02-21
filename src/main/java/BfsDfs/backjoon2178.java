package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon2178 {
    static int[][] arr;
    static int[][] map;
    static boolean[][] visit;
    static int m ,n,min;
    static int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];
        map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = s.charAt(j-1)-'0';
            }
        }
        min = Integer.MAX_VALUE;
        bfs(1, 1);

        System.out.println(map[n][m]+1);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y,1});
        map[x][y] = 1;
        visit[x][y] = true;

        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == n && temp[1] == m){
                if(map[temp[0]][temp[1]] > temp[2])
                    map[temp[0]][temp[1]] = temp[2];
            }

            for (int[] dir : dirs) {
                int nx = temp[0] + dir[0];
                int ny = temp[1] + dir[1];
                if(nx >= 1 && ny >= 1 && nx <= n && ny <= m && arr[nx][ny] == 1 && !visit[nx][ny]  ){
                    visit[nx][ny] = true;
                    map[nx][ny] = temp[2];
                    queue.offer(new int[]{nx,ny,temp[2]+1});
                }
            }
        }

    }
}
