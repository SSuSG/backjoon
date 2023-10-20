
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int answer = 0;
        int leftCnt = 0;
        String input = br.readLine();

        for(int i = 0 ; i < input.length() ; i++){
            if(input.charAt(i) == '('){
                s.push('(');
                leftCnt++;
            }else{
                if(!s.isEmpty() && input.charAt(i-1) == '('){
                    answer += (leftCnt-1);
                    s.pop();
                    leftCnt--;

                }else if(!s.isEmpty() && s.peek() == '('){
                    answer += 1;
                    s.pop();
                    leftCnt--;
                }

            }
        }
        System.out.println(answer);
    }
}
