package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon12865 {
    static class item{
        int w,v;

        public item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    static int n,k;
    static item[] items;
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        items = new item[n+1];
        dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items[i] = new item(w,v);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                //아이템을 담을수 없다면
                if(items[i].w > j ){
                    dp[i][j] = dp[i-1][j];
                }else{ //아이템을 담을수 있다면
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-items[i].w] + items[i].v);

                }
            }
        }

    }

}
