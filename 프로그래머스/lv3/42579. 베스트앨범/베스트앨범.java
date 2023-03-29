import java.util.*;
class Solution {
    static class song{
        String genre;
        int plays;
        int idx;
        
        public song(String genres , int plays , int idx){
            this.genre = genres;
            this.plays = plays;
            this.idx = idx;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        song[] songs = new song[plays.length];
        HashMap<String,Integer> playByGenre = new HashMap<>();
        HashMap<String,Integer> genrePriority = new HashMap<>();
        HashMap<String,Integer> songCount = new HashMap<>();
        
        for(int i = 0 ; i < plays.length ; i++){
            playByGenre.put(genres[i] , playByGenre.getOrDefault(genres[i],0)+plays[i]);
            songs[i] = new song(genres[i],plays[i],i);
        }
        List<String> keySet = new ArrayList<>(playByGenre.keySet());
        keySet.sort( (s1,s2) -> playByGenre.get(s2)-playByGenre.get(s1));
        
        //장르 우선순위 정하기
        int cnt = 1;
        for(String genre : keySet){
            genrePriority.put(genre,cnt++);
            songCount.put(genre,2);
        }
        
        PriorityQueue<song> pq = new PriorityQueue<>(new Comparator<song>(){
            @Override
            public int compare(song s1 , song s2){
                int s1Priority = genrePriority.get(s1.genre);
                int s2Priority = genrePriority.get(s2.genre);
                if(s1Priority == s2Priority){
                    if(s1.plays == s2.plays)
                        return s1.idx - s2.idx;
                    return s2.plays-s1.plays;
                }
                return s1Priority - s2Priority;
            }
        });
        
        
        for(int i = 0 ; i < songs.length ; i++){
            pq.add(songs[i]);
        }
        //곡 선별하기
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            song cur = pq.poll();
            if(songCount.get(cur.genre) > 0){
                songCount.put(cur.genre , songCount.get(cur.genre)-1);
                list.add(cur.idx);
                //answer[i++] = cur.idx;
            }
            
        }
        answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}