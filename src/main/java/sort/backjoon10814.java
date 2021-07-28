package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class backjoon10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Member[] arr = new Member[n];
        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();

            arr[i] = new Member(name,age,i);
        }

        Arrays.sort(arr, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.age== o2.age){
                    return o1.order-o2.order;
                }else{
                    return o1.age-o2.age;
                }
            }
        });

        for (Member member : arr) {
            System.out.println(member.age+" "+member.name);
        }

    }

    static class Member{
        String name;
        int age;
        int order;

        public Member(String name, int age, int order) {
            this.name = name;
            this.age = age;
            this.order = order;
        }
    }
}
