import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String next = sc.next();
        int[] arr = new int[26];
        int max = 0;
        char c=0;

        for(int i = 0 ; i < next.length() ; i++){
            if(next.charAt(i)>90)
                arr[next.charAt(i)-97]++;
            else
                arr[next.charAt(i)-65]++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(max < arr[i]) {
                max = arr[i];
                c = (char) (65+i);
            }
        }

        int count = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(max == arr[i])
                count++;
        }

        if(count>1)
            System.out.println("?");
        else
            System.out.println(c);
    }
}