package map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<String> notSeeHuman = new HashSet<>();
        ArrayList<String> notSeeNotHearHuman = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String human = "";

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            human = st.nextToken();
            notSeeHuman.add(human);
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            human = st.nextToken();
            if(notSeeHuman.contains(human)){
                notSeeNotHearHuman.add(human);
            }
        }

        Collections.sort(notSeeNotHearHuman);
        System.out.println(notSeeNotHearHuman.size());
        for (int i = 0; i < notSeeNotHearHuman.size(); i++) {
            System.out.println(notSeeNotHearHuman.get(i));
        }

    }
}
