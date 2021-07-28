package brutforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon1436 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count=0;
        int i =665;

        while(count != n){
            String s = String.valueOf(i);
            int length = s.length();
            int temp=0;
            for (int j = 0; j < length-2; j++) {
                if(s.charAt(j)=='6'&&s.charAt(j+1)=='6'&&s.charAt(j+2)=='6'){
                    count++;
                    break;
                }
            }
            i++;
        }
        System.out.println(i-1);
    }
}
