package backtracking;

import java.util.Scanner;

public class backjoon15650 {
    static int n,m;
    static int arr[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        visit = new boolean[n+1];
        int depth=0;
        dfs(depth);
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

        for (int i = 1; i <= n; i++) {
            arr[depth] = i;
            dfs(depth+1);
        }
    }
}
