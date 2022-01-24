package backtracking;

import java.util.Scanner;

public class backjoon15651 {

    static int n,m;
    static int arr[];
    static boolean visit[];
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        visit = new boolean[n];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth == m){
            for (int i : arr) {
                sb.append(i+" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0 ; i < n ; i++){
            arr[depth] = i+1;
            dfs(depth+1);
        }


    }
}
