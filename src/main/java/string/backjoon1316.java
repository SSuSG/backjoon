package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char lastChar=s.charAt(0);
            boolean arr[] = new boolean[26];
            arr[lastChar-'a'] = true;
            boolean success = true;
            for (int j = 1; j < s.length(); j++) {
                char c = s.charAt(j);

                if(lastChar == c){
                    continue;
                }else{
                    if(arr[c-'a'] == false){
                        arr[c-'a'] = true;
                        lastChar = c;
                    }else{
                        success = false;
                        break;
                    }
                }
            }
            if(success){
                count++;
            }
        }
        System.out.println(count);
    }



//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int count = 0;
//
//        for(int i = 0 ; i < n ; i++){
//            int[] arr = new int[26];
//            String temp = sc.next();
//            for (int j = 0; j < temp.length(); j++) {
//                if(j>=1){
//                    if(temp.charAt(j)!=temp.charAt(j-1)){
//                        if(arr[temp.charAt(j)-'a'] > 0 ){
//                            break;
//                        }
//                    }
//                }
//                arr[temp.charAt(j)-'a']++;
//                if(j==temp.length()-1)
//                    count++;
//            }
//
//        }
//        System.out.println(count);
//    }
}
