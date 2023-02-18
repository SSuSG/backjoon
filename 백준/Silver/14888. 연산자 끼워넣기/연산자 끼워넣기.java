import java.io.*;
import java.util.*;
public class Main {
    static int n,min= Integer.MAX_VALUE,max=Integer.MIN_VALUE;
    static int[] input;
    static int[] op = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        calc(input[0],1);
        System.out.println(max);
        System.out.println(min);
    }

    static void calc(int num , int idx){
        if(idx == n){
            if(min > num)
                min = num;
            if(max < num)
                max = num;

            return;
        }

        for (int i = 0; i < 4; i++) {
            if(op[i] > 0 ) {
                op[i]--;

                if (i == 0)
                    calc(num + input[idx] , idx+1);
                else if (i == 1)
                    calc(num - input[idx] , idx+1);
                else if (i == 2)
                    calc(num * input[idx] , idx+1);
                else if (i == 3)
                    calc(num / input[idx] , idx+1);

                op[i]++;
            }
        }
    }
}