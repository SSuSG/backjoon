import java.util.*;
import java.io.*;
public class Solution {
	static int n,min,max;
    static int[] input;
    static int[] op;

    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("res/input_숫자만들기.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= t; tc++) {
        	min= Integer.MAX_VALUE;
			max=Integer.MIN_VALUE;
        	n = Integer.parseInt(br.readLine());
            input = new int[n];
            op = new int[4];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            
            calc(input[0],1);
            sb.append("#" + tc + " " + (max-min) + "\n");
		}
        System.out.println(sb);
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