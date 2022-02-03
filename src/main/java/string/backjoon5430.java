package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon5430 {
    static boolean isRight;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int t;
        String func;
        int n;
        ArrayDeque<Integer> deque;

        t = Integer.parseInt(br.readLine());

        while (t > 0 ){
            t--;
            func = br.readLine();
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            deque = new ArrayDeque<Integer>();
            for (int i = 0 ; i < n ; i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            function(func,deque);
        }
        System.out.println(sb);
    }

    private static void function(String func, ArrayDeque<Integer> deque) {

        isRight = true;

        for (char c : func.toCharArray()) {
            if(c == 'R'){
                if(isRight)
                    isRight = false;
                else
                    isRight = true;
            }else if (c == 'D'){
                if (!deque.isEmpty()){
                    if(isRight){
                        deque.pollFirst();
                    }else{
                        deque.pollLast();
                    }
                }else if (deque.isEmpty()){
                    sb.append("error").append('\n');
                    return;
                }
            }
        }

        sb.append("[");
        if (deque.size() > 0){

            if (isRight){
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()){
                    sb.append(',').append(deque.pollFirst());
                }
            }else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }

        }
        sb.append(']').append('\n');
    }
}


/*
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String func;
        int m;
        String arr;
        LinkedList<String> stringList = new LinkedList<>();
        boolean isRight;
        String answer = "";

        for (int i = 0 ; i < n ; i++){
            isRight = true;

            func = br.readLine();
            m = Integer.parseInt(br.readLine());
            arr = br.readLine();
            answer ="";

            String substring = arr.substring(1, arr.length() - 1);
            String[] split = substring.split(",");
            for (int j = 0 ; j < split.length ; j++){
                stringList.add(split[j]);
            }

            for (int j = 0 ; j < func.length() ; j++){
                if(func.charAt(j) == 'R'){
                    if(isRight)
                        isRight = false;
                    else
                        isRight = true;
                }else if(func.charAt(j) == 'D'){
                    if (!stringList.isEmpty()){
                        if(isRight)
                            stringList.remove(0);
                        else
                            stringList.remove(stringList.size()-1);
                    } else{
                        continue;
                    }
                }
            }

            if(stringList.isEmpty()){
                sb.append("error").append('\n');
            }else {
                answer += '[';
                for (int j = 0 ; j < stringList.size() ; j++){
                    answer += stringList.get(j);
                    if(stringList.size()-1 != j)
                        answer += ',';
                }

                answer += ']';
                sb.append(answer).append('\n');
                stringList.clear();
            }
        }
        System.out.println(sb);
    }

 */
