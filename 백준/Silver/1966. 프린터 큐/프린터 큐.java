 import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static class file{
        int importance;
        int seq;

        public file(int importance, int seq) {
            this.importance = importance;
            this.seq = seq;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            LinkedList<file> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                queue.offer(new file(sc.nextInt(),j));
            }
            int count = 0;
            boolean input = false;
            while(!queue.isEmpty()){
                 file temp = queue.poll();

                 for (int j = 0; j < queue.size(); j++) {
                     if( temp.importance < queue.get(j).importance) {
                         queue.offer(temp);
                         input = true;
                         break;
                     }
                     input = false;
                 }
                if(input == false) {
                    count++;
                    if(temp.seq == m){
                        sb.append(count+"\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}