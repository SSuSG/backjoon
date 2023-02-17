import java.io.*;
import java.util.*;

public class Main {
    static int[] input = new int[9];
    static int[] output = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        dfs(0,0,0);
    }

    static void dfs(int cnt,int startIdx , int sum){
        if(cnt == 7){
            if(sum == 100){
                for (int i = 0; i < 7; i++) {
                    System.out.println(output[i]);
                }
            }

            return;
        }

        for (int i = startIdx; i < 9; i++) {
            output[cnt] = input[i];
            dfs(cnt+1,i+1,sum+input[i]);
        }
    }
}