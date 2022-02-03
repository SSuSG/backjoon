package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class backjoon9935 {
    static String origin;
    static String bomb;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        origin = br.readLine();
        bomb = br.readLine();
        Stack<Character> st = new Stack<>();

        for (int i = 0 ; i < origin.length() ; i++){
            st.push(origin.charAt(i));

            if(st.size() >= bomb.length()){
                flag = true;
                for (int j = 0 ;  j < bomb.length() ; j++){
                    if(st.get(st.size() - bomb.length() + j) != bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for (int j = 0 ; j < bomb.length(); j++){
                        st.pop();
                    }
                }
            }
        }

        for (Character c : st) {
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb);

    }
}
