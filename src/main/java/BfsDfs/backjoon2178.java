package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon2178 {
    static int[][] arr;
    static boolean[][] visit;
    static int m ,n;
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

        arr = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        bfs(0, 0);
        System.out.println(arr[n-1][m-1]);
    }

    private static void bfs(int i,int j) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{i,j});
        visit[i][j] = true;

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            for (int[] dir : dirs) {
                int x = poll[0] + dir[0];
                int y = poll[1] + dir[1];

                if(x >=0 && y >=0 && x < n && y<m && arr[x][y] == 1 && visit[x][y] == false){
                    queue.offer(new int[]{x,y});
                    visit[x][y] = true;
                    arr[x][y] = arr[poll[0]][poll[1]]+1;
                }
            }

        }
    }
}
