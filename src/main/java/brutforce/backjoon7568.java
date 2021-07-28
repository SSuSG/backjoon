package brutforce;

import java.util.Scanner;

public class backjoon7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Member[] arr = new Member[n];
        int x;
        int y;

        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            arr[i] = new Member(x,y);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if(i==j)
                    continue;
                if(arr[i].x < arr[j].x && arr[i].y < arr[j].y)
                    arr[i].rank++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].rank+" ");
        }

    }

    static class Member{
        int x;
        int y;
        int rank=1;

        public Member(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
