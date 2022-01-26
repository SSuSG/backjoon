package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        String func;
        int m;
        String arr;

        for (int i = 0 ; i < n ; i++){
            int end = 0;
            boolean isRight = true;
            List<Character> characterList = new ArrayList<>();
            func = br.readLine();
            m = Integer.parseInt(br.readLine());
            arr = br.readLine();
            char[] answer = new char[3*m];

            for (int j =0 ; j< arr.length() ; j++){
                if(arr.charAt(j) == '[' || arr.charAt(j) == ',' || arr.charAt(j) == ']')
                    continue;
                characterList.add(arr.charAt(j));
            }

            for (int j = 0 ; j < func.length() ; j++){
                if(func.charAt(j) == 'R'){
                    if(isRight == true)
                        isRight = false;
                    else
                        isRight = true;
                }else if(func.charAt(j) == 'D'){
                    if (!characterList.isEmpty()){
                        if(isRight)
                            characterList.remove(0);
                        else
                            characterList.remove(characterList.size()-1);
                    } else{
                        continue;
                    }
                }
            }

            if(characterList.isEmpty()){
                sb.append("error").append("\n");
            }else {
                answer[0] = '[';
                int k = 0;
                int z =1;
                while(characterList.size() != k){
                    answer[z] = characterList.get(k);
                    answer[z+1] = ',';
                    k++;
                    z+=2;
                }
                end = characterList.size()*2+1;
                answer[characterList.size()*2] = ']';
                sb.append(new String(answer).substring(0,end)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
