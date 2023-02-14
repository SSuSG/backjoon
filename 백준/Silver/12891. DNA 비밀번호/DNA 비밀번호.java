import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int s,p,result=0;
    static String dna;
    static int[] count = new int[4];
    static int[] charCount = new int[20];    //T까지의 COUNT배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        dna = br.readLine();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            count[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++)
            charCount[dna.charAt(i)-'A']++;

        int idx = 0;
        while(true){
            if(isSuccess())
                result++;

            if(idx+p >= dna.length())
                break;
            charCount[dna.charAt(idx)-'A']--;
            charCount[dna.charAt(idx+p)-'A']++;
            idx++;
        }

        System.out.println(result);
    }

    static boolean isSuccess(){
        if(charCount[0] >= count[0] && charCount[2] >= count[1] && charCount[6] >= count[2] && charCount[19] >= count[3])
            return true;
        return false;
    }
}