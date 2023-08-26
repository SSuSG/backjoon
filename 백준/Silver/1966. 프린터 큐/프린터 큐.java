import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < t ; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int goalIdx = Integer.parseInt(st.nextToken());

            LinkedList<file> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                q.add(new file(j,Integer.parseInt(st.nextToken())));
            }

            int count = 0;
            boolean isInput = false;
            while(!q.isEmpty()){
                file cur = q.poll();

                for(int j = 0 ; j < q.size() ; j++){
                    if(cur.priority < q.get(j).priority){
                        q.offer(cur);
                        isInput = true;
                        break;
                    }
                    isInput = false;
                }

                if(!isInput){
                    count++;
                    if(cur.idx == goalIdx){
                        sb.append(count + "\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);

    }

    static class file{
        int idx;
        int priority;

        public file(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}