package programmersLV1;

import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {
    public static void main(String[] args) {

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> num = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i] , new HashSet<>());
            num.put(id_list[i] , i);
        }

        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");

            String from = split[0];
            String to = split[1];
            map.get(to).add(from);
        }
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);

            if(send.size() >= k ){
                for (String s : send) {
                    answer[num.get(s)]++;
                }
            }
        }

        return answer;
    }
}
