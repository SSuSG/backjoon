package string;

import java.util.Scanner;

public class backjoon10809 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String next = sc.next();

        for(int i = 'a' ; i <= 'z' ; i++){
            if(next.indexOf(i)>=0)
                System.out.print(next.indexOf(i)+" ");
            else
                System.out.print(-1+" ");

        }
    }
}
