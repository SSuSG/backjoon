package backtracking;

import java.util.Scanner;

public class backjoon15650 {
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
        visit = new boolean[n+1];
        dfs(0,1);
        System.out.println(sb);

    }

    private static void dfs(int depth ,int at) {
        if(depth == m){
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append('\n');
            return;
        }
        for (int i = at ; i <= n ; i++){
            arr[depth]=i;
            dfs(depth+1 , i+1);
        }
    }
}
