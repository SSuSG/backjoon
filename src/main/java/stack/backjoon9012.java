package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class backjoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            st = new StringTokenizer(s);

            int temp=0;
            char lately='*';
            char now;
            while(temp != s.length()){
                now = s.charAt(temp);
                if(stack.size() >0)
                    lately = stack.peek();
                else
                    lately = '*';
                if(now == ')' && lately == '('){
                    stack.pop();
                    temp++;
                    continue;
                }
                stack.push(now);
                lately = now;
                temp++;
            }
            if(stack.size() >0)
                sb.append("NO"+"\n");
            else
                sb.append("YES"+"\n");

        }
        System.out.println(sb);
    }
}
