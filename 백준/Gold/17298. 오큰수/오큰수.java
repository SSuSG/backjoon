
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] output = new int[N];
        int[] seq = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < N ; i++){
            if(s.isEmpty()){
                s.push(new int[]{seq[i],i});
            }else{
                while(!s.isEmpty() && s.peek()[0] < seq[i]){
                    output[s.peek()[1]] = seq[i];
                    s.pop();
                }
                s.push(new int[]{seq[i],i});
            }
        }
        while(!s.isEmpty()){
            output[s.peek()[1]] = -1;
            s.pop();
        }

        for(int i = 0 ; i < N ; i++){
            sb.append(output[i]).append(' ');
        }
        System.out.println(sb);
    }
}
