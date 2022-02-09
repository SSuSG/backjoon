package brutforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backjoon4673 {
    static boolean self[];
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        self = new boolean[10001];
        for (int i = 1; i < 10001; i++) {
            d(i);
        }

        for (int i = 1; i < 10001; i++) {
            if(self[i] == false)
                System.out.println(i);
        }

    }

    private static void d(int i) {
        int temp = 0 ;
        temp += i;
        while(i > 0){
            temp += (i%10);
            i = i/10;
        }
        if(temp <= 10000)
            self[temp] = true;

    }
}
