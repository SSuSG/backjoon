package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while(true){
            s = br.readLine();

            if(s.equals("0"))
                break;

            sb.append(palindrome(s)).append("\n");

        }
        System.out.println(sb);
    }

    private static String palindrome(String s) {
        if(s.equals(new StringBuilder(s).reverse().toString()))
            return "yes";
        else
            return "no";
    }
}
