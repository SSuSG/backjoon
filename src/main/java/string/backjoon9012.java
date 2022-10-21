package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class backjoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();

            Stack<Character> st = new Stack<>();
            st.push(s.charAt(0));
            for (int j = 1; j < s.length(); j++) {
                if(s.charAt(j) == ')'){
                    if(st.size() > 0 && st.peek() == '('){
                        st.pop();
                    }else{
                        st.push(')');
                    }
                }else if(s.charAt(j) == '('){
                    st.push('(');
                }
            }
            if(st.isEmpty()){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
