package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class backjoon2667 {
    static int[][] arr;
    static boolean[][] visit;
    static ArrayList<Integer> a;
    static int n , temp;

    static int[][] dirs = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n][n];

        a = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp = 0;
                if(arr[i][j] == 1 && visit[i][j] == false){
                    dfs(i,j);
                }
                if(temp > 0 ){
                    a.add(temp);
                }
            }
        }
        Collections.sort(a);

        System.out.println(a.size());
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }

    private static void dfs(int i, int j) {
        temp++;
        visit[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x >=0 && y >= 0 && x < n && y < n && arr[x][y]==1 && visit[x][y] == false){
                dfs(x,y);
            }
        }
    }


}
