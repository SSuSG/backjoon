package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon7576 {
    static int[][] arr;
    static boolean[][] visit;
    static int m,n,min;
    static int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs();

        int result =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]==0){
                    System.out.println(-1);
                    return ;
                }
                result = Math.max(result,arr[i][j]);
            }
        }
        System.out.println(result-1);


    }
    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] ==1){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] temp = queue.poll();

            for (int[] dir : dirs) {
                int next_x = temp[0]+dir[0];
                int next_y = temp[1]+dir[1];

                if(next_x >= 0 && next_y >= 0 && next_x < n && next_y < m && arr[next_x][next_y] == 0 ){
                    arr[next_x][next_y] = arr[temp[0]][temp[1]]+1;
                    queue.offer(new int[]{next_x,next_y});
                }
            }
        }


    }
}
