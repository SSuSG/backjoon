package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon8958 {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            boolean lastAnswer = false;
            int var = 1;
            int sum = 0;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c =='O'){
                    if(lastAnswer){
                        sum += var;
                        var++;
                    }else{
                        sum += 1;
                        var++;
                    }
                    lastAnswer = true;
                }else if(c == 'X'){
                    lastAnswer = false;
                    var = 1;
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
