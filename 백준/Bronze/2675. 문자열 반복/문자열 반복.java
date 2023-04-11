import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int n;
        String s;
        

        for(int i = 0 ; i < testcase ; i++){
           StringBuilder sb = new StringBuilder(); 
           n = sc.nextInt();
           s = sc.next();

           for(int j = 0 ; j < s.length() ; j++){
               for(int z = 0 ; z < n ; z++){
                   sb.append(s.charAt(j));
               }
           }
           System.out.println(sb);
        }
    }
}