package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon2629 {
    static boolean[][] dp;
    static int[] arr;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        dp = new boolean[31][15001];
        arr=  new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        int question;
        dfs(0,0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            question = Integer.parseInt(st.nextToken());
            if(question <= 15000){
                if(dp[n][question]){
                    sb.append("Y ");
                }else{
                    sb.append("N ");
                }
            }else{
                sb.append("N ");
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int cnt , int weight){
        if(dp[cnt][weight])
            return;
        dp[cnt][weight] = true;
        if(cnt==n)
            return;

        dfs(cnt+1,weight+arr[cnt+1]);
        dfs(cnt+1,weight);
        dfs(cnt+1, Math.abs(weight-arr[cnt+1]));

    }
}
