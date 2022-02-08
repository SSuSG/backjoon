package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon2468 {
    static int[][] map;
    static int max = 0;
    static int maxHeight = 0;
    static int n,temp;
    static boolean[][] check;
    static boolean[][] check2;
    static int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];


        for (int i =  0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j< n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(maxHeight < map[i][j])
                    maxHeight = map[i][j];
            }
        }

        for (int i = 0 ; i < maxHeight ; i++ ){
            check = new boolean[n][n];
            check2 = new boolean[n][n];
            func(i);
        }
        System.out.println(max);

    }

    private static void func(int h) {
        temp = 0;
        for (int i =  0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j ++){
                if(map[i][j] <= h ){
                    check[i][j] = true;
                }
            }
        }

        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                if(check[i][j] == false && check2[i][j] == false){
                    temp++;
                    enter(i,j);
                    if (max < temp)
                        max = temp;
                }
                
            }
        }

    }

    private static void enter(int i, int j) {
        check2[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x >=0 && y >= 0 && x < n && y < n && check[x][y] == false && check2[x][y] == false){
                enter(x,y);
            }
        }

    }
}
