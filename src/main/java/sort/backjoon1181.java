package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class backjoon1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
        });
        String prev=arr[0];
        System.out.println(prev);
        for (int i = 1; i < arr.length; i++) {
            if(prev.equals(arr[i])){
                continue;
            }
            System.out.println(arr[i]);
            prev = arr[i];
        }
    }
}
