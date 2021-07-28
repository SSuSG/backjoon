package string;

import java.util.Scanner;

public class backjoon11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String next = sc.next();
        int sum = 0;

        for(int i = 0 ; i < next.length() ; i++){
            sum += next.charAt(i)-'0';
        }

        System.out.println(sum);
    }
}
