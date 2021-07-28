package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class backjoon11650 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Member[] arr = new Member[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new Member(x,y);
        }

        Arrays.sort(arr, new Comparator<Member>() {

            @Override
            public int compare(Member o1, Member o2) {
                if(o1.x==o2.x){
                    return o1.y-o2.y;
                }else{
                    return o1.x-o2.x;
                }
            }
        });

        for (Member member : arr) {
            System.out.println(member.x+" "+member.y);
        }

    }

    static class Member{
        int x,y;

        public Member(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
