import java.io.*;

public class Main{
    static int n;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i=0; i < n; i++){
            String input = br.readLine();
            for(int j=0; j < n; j++){
                if(input.charAt(j) == 'T')
                    map[i][j] = 1;    
            }
        }
        
        int ans = 400;
        for(int bit=0; bit < (1<<n)-1; bit++){
            int sum = 0;
           
            // 현재 비트값에 대해 모든 열에서 탐색 수행
            for(int x=0; x < n; x++){
                int tail = 0;
                for(int y=0; y < n; y++){
                    int cur = map[y][x];
                    if((bit&(1<<y)) != 0)
                        cur = map[y][x] ^ 1;
                    if(cur == 1) 
                        tail++;
                }
                sum += Math.min(tail, n-tail);
            }
            if(ans > sum) ans = sum;
        }
        System.out.println(ans);
    }
}