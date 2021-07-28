package string;

import java.util.Scanner;

public class backjoon2908 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String num1 = sc.next();
        String num2 = sc.next();

        char[] chr1 = num1.toCharArray();
        char[] chr2 = num2.toCharArray();

        char temp;

        temp=chr1[2];
        chr1[2]=chr1[0];
        chr1[0]=temp;

        temp=chr2[2];
        chr2[2]=chr2[0];
        chr2[0]=temp;

        String n1 = String.valueOf(chr1);
        String n2 = String.valueOf(chr2);

        if(Integer.parseInt(n1) > Integer.parseInt(n2))
            System.out.println(n1);
        else
            System.out.println(n2);
    }
}
