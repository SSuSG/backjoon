package string;

import java.util.Scanner;

public class backjoon1316 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            int[] arr = new int[26];
            String temp = sc.next();
            for (int j = 0; j < temp.length(); j++) {
                if(j>=1){
                    if(temp.charAt(j)!=temp.charAt(j-1)){
                        if(arr[temp.charAt(j)-'a'] > 0 ){
                            break;
                        }
                    }
                }
                arr[temp.charAt(j)-'a']++;
                if(j==temp.length()-1)
                    count++;
            }

        }
        System.out.println(count);
    }
}
