package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon2529 {
    static int k;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        String s = br.readLine();
        for (int i = 0; i < k; i++) {
            arr[i] = s.charAt(i);
        }


    }
}
