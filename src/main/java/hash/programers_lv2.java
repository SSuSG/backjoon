package hash;

import java.util.HashMap;

public class programers_lv2 {
}

class Solution_lv2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if(i==j)
                    continue;
                if(phone_book[i].startsWith(phone_book[j])){
                    answer = false;
                }
            }
        }

        return answer;
    }
}

class Solution_lv2_2 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String , Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            hashMap.put(clothes[i][1] , hashMap.getOrDefault(clothes[i][1],0)+1);
        }

        for (String s : hashMap.keySet()) {
            answer *= hashMap.get(s)+1;
        }

        return answer-1;

    }
}
