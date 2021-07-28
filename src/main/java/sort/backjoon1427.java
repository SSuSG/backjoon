package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String n = br.readLine();

        char[] chars = n.toCharArray();
        Arrays.sort(chars);
        for (int i = chars.length-1; i >=0  ; i--) {
            sb.append(chars[i]);
        }
        System.out.println(sb);

    }
}
