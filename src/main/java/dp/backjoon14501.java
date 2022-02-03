package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon14501 {
    static int[] dp;
    static int[] time;
    static int[] price;
    static int n;
    static int max =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        time = new int[n+1];
        price = new int[n+1];
        dp = new int[n+1];
        for (int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        calc(1 ,0 );
        System.out.println(max);
    }

    private static void calc(int day , int sum) {
        if (day > n ){
            if (max < sum)
                max = sum;
            return;
        }

        calc(day + 1 , sum);
        if (day + time[day] <= n + 1){
            calc(day + time[day] , sum + price[day]);
        }


    }
}
