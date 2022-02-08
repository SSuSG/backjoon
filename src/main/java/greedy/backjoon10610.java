package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int strLen = str.length();
        int[] numCountArr = new int[10];
        long total = 0;

        for (int i = 0 ; i < strLen ; i++){
            int tNum = Integer.parseInt(str.substring(i,i+1));
            numCountArr[tNum] += 1;
            total += tNum;
        }

        if(!str.contains("0") || total%3 != 0){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9 ; i >= 0 ; i--){
            while (numCountArr[i] >0) {
                sb.append(i);
                numCountArr[i]--;
            }
        }
        System.out.println(sb);


    }
}
