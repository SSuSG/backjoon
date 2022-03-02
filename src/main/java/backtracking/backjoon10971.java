package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon10971 {
    static int n,min = Integer.MAX_VALUE;
    static int[][] w;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        w = new int[n+1][n+1];
        visit = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n ; i++) {
            bt(i,i,0 , 0);
        }
        System.out.println(min);

    }

    private static void bt(int end, int node , int depth , int sum) {
        if(depth == n && node == end){
            if(min > sum)
                min = sum;
            return;
        }

        for (int i = 1; i <= n ; i++) {
            if(w[node][i] > 0 && !visit[i] && i != end){
               visit[i] = true;
               bt(end, i,depth+1 , sum+w[node][i]);
               visit[i] = false;
            }else if(w[node][i] > 0 && !visit[i] && i == end && depth == n-1){
                bt(end, i,depth+1 , sum+w[node][i]);
            }
        }
    }
}
