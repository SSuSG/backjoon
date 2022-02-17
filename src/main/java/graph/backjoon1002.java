package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon1002 {
    static int n , m, k,worm;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dirs = {
        {-1,0},
        {1,0},
        {0,-1},
        {0,1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t  = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            worm = 0;
            visit = new boolean[n][m];
            for (int z = 0; z < n; z++) {
                for (int j = 0; j < m; j++) {
                    if(map[z][j] ==1 && !visit[z][j]) {
                        worm++;
                        bfs(z, j);
                    }
                }
            }
            sb.append(worm).append('\n');
        }
        System.out.println(sb);

    }

    private static void bfs(int row, int col) {
        visit[row][col] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            for (int[] dir : dirs) {
                int ny = temp[0] + dir[0];
                int nx = temp[1] + dir[1];
                if(nx >=0 && ny >= 0 && nx < m && ny < n && map[ny][nx] == 1 && !visit[ny][nx]){
                    queue.add(new int[]{ny,nx});
                    visit[ny][nx] = true;
                }
            }
        }
    }
}
