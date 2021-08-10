package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class backjoon2565 {

    static class rope{
        int a,b;

        public rope(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        rope[] r= new rope[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = new rope(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(r, new Comparator<rope>() {
            @Override
            public int compare(rope o1, rope o2) {
                return o1.a-o2.a;
            }
        });

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(r[i].b > r[j].b && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max =0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i],max);
        }
        int result=0;
        result = r.length - max;
        System.out.println(result);

    }
}
