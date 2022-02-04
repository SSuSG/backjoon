package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon4963 {
    static int w,h;
    static int map[][];
    static boolean[][] visit;
    static int[][] dirs = {
            {-1 , 0},
            {1 , 0},
            {0 , -1},
            {0 , 1},
            {1 , 1},
            {-1 ,-1},
            {1 , -1},
            {-1 ,1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int result = 0;
            if(w == 0 && h == 0)
                break;

            map = new int[h+1][w+1];
            visit = new boolean[h+1][w+1];
            for (int i = 1 ; i <= h ; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 1 ; j <= w ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 1 ; i <= h ; i++){
                for (int j = 1; j <= w ; j++){
                    if(map[i][j] == 1 && visit[i][j] == false){
                        dfs(i,j);
                        result++;
                    }

                }
            }
            System.out.println(result);
        }

    }

    private static void dfs(int row, int col) {
        visit[row][col] = true;

        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if( x >= 1 && y >= 1 && x <= h && y <= w && visit[x][y] == false && map[x][y] == 1){
                dfs(x,y);
            }
        }

    }
}
