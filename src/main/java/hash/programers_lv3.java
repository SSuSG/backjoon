package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class programers_lv3 {
}


class Solution_lv3 {
    static class Music{
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }

    public int[] solution(String[] genres, int[] plays) {


        HashMap<String,Integer> map =new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i] , map.getOrDefault(genres[i],0)+plays[i]);
        }

        ArrayList<String> genre_order = new ArrayList<>();
        ArrayList<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2)-map.get(o1);
            }
        });

        for (String s : keySetList) {
            genre_order.add(s);
        }

        ArrayList<Music> result = new ArrayList<>();
        for (String genre_od : genre_order) {
            ArrayList<Music> list = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if(genre_od.equals(genres[i])){
                    list.add(new Music(genres[i],plays[i],i));
                }
            }
            Collections.sort(list, new Comparator<Music>() {
                @Override
                public int compare(Music o1, Music o2) {
                    return o2.play-o1.play;
                }
            });

            result.add(list.get(0));
            if(list.size()!=1)
                result.add(list.get(1));
        }
        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).idx;
        }

        return answer;
    }
}

