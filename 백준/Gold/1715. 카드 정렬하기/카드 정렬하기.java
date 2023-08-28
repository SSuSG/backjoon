import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> arr = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }


        int sum = 0;
        int a,b;
        for (int i = 1; i < n; i++) {
            if(arr.size() >= 2){
                a = arr.poll();
                b = arr.poll();
                sum += (a+b);
                arr.add(a+b);
            }else{
                sum += arr.poll();
            }

        }
        System.out.println(sum);
    }
}