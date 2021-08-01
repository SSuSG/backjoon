package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("-");

        int sum=Integer.MAX_VALUE;
        for (String s : split) {
            int temp = 0;
            String[] split1 = s.split("\\+");

            for (String s1 : split1) {
                temp += Integer.parseInt(s1);
            }
            if(sum==Integer.MAX_VALUE)
                sum = temp;
            else
                sum -= temp;


        }
        System.out.println(sum);
    }
}
