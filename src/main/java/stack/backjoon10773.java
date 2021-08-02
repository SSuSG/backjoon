package stack;

import java.util.Scanner;
import java.util.Stack;

public class backjoon10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            int temp = sc.nextInt();
            if(temp > 0 )
                stack.push(temp);
            else if(temp == 0)
                stack.pop();
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        System.out.println(sum);
    }
}
