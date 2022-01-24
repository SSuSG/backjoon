package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class backjoon15649 {
    public static int arr[];
    public static boolean visit[];
    public static StringBuilder sb;

    public static void main(String[] args) {
        sb = new StringBuilder();
        int n,m;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        visit = new boolean[n];

        dfs(n,m,0);


    }

    private static void dfs(int n, int m, int depth) {
        if(m == depth){
            for (int i : arr) {
                System.out.print(i +" ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n ; i++){
            if(visit[i] == false){
                visit[i] = true;
                arr[depth] = i+1;
                dfs(n,m,depth+1);
                visit[i] = false;
            }
        }
    }
}
