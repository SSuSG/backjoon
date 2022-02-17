package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon11052 {
    static int n;
    static int[] price;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        price = new int[n+1];
        dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = price[1];

        for (int i = 2; i < n+1; i++) {
            dp[i] = func(i);
        }
        System.out.println(dp[n]);

    }

    private static int func(int i) {
        int max = price[i];

        for (int j = 0; j < i; j++) {
            if(max < dp[j] + price[i-j])
                max = dp[j] + price[i-j];
        }
        return max;
    }
}
