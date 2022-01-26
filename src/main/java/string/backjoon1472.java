package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class backjoon1472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        char[] chars = n.toCharArray();
        Arrays.sort(chars);
        for (int i = chars.length-1  ; i >= 0  ; i--){
            System.out.print(chars[i]);
        }

    }
}
