package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon10942 {
    static int arr[];
    static boolean dp[][];
    static int m,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new boolean[n+1][n+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        palindrome(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]){
                sb.append(1+"\n");
            }else{
                sb.append(0+"\n");
            }
        }
        System.out.println(sb);

    }
    public static void palindrome(int n) { // 팰린드롬이면 1 , 아니면 0 리턴

        //길이 1,2 짜리 펠린드롬 찾기
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;  // 길이 1짜리
            if (arr[i] == arr[i - 1]) { //길이 2짜리
                dp[i - 1][i] = true;
            }
        }

        //길이 3이상 펠린드롬 찾기
        for (int length = 2; length < n; length++) {
            for (int k = 1 ; k <= n-length; k++) {
                if (arr[k] == arr[k+length] && dp[k + 1][k+length - 1]) {
                    dp[k][k+length] = true;
                }

            }
        }
    }
}
