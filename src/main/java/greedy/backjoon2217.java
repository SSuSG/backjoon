package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon2217 {
    static int[] arr;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        for (int i = 0 ; i < n ; i++){
            if(max < arr[i]*(n-i))
                max = arr[i]*(n-i);

        }
        System.out.println(max);
    }
}
