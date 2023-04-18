import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Record> list = new ArrayList<>();
        int[] answer;
        HashMap<String,Record> map = new HashMap<>();
        
        for(int i = 0 ; i < records.length ; i++){
            String[] split = records[i].split(" ");
            String[] time = split[0].split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            int t = h*60 + m;

            if(split[2].equals("IN")){
                if(map.containsKey(split[1])){
                    Record record = map.get(split[1]);
                    record.in = t;
                    record.isOut = false;
                }else{
                    map.put(split[1] ,new Record(split[1],t));
                }

            }else if(split[2].equals("OUT")){
                Record record = map.get(split[1]);
                record.out = t;
                record.totalTime += (record.out - record.in);
                
                record.isOut = true;
            }
        }
        //hashMAP에서 모든 차량의 요금 계산
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            Record record = map.get(key);

            //출차를 23:59에 한다는 의미
            if(record.isOut == false){
                record.totalTime += (23*60+59)-record.in;
            }

            if(record.totalTime <= fees[0]){
                record.f = fees[1];
            }else{
                //System.out.println(Math.ceil((record.totalTime-fees[0])*1.0/fees[2]));
                record.f = fees[1] + (int)Math.ceil((record.totalTime-fees[0])*1.0/fees[2])*fees[3];
            }
            //System.out.println(record.num);
            //System.out.println(record.totalTime);
            //System.out.println(record.f);
            list.add(record);
        }
        
        Collections.sort(list, (o1,o2) -> (o1.num).compareTo(o2.num));
        answer = new int[list.size()];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = list.get(i).f;
        }
        
        return answer;
    }
    static class Record{
        int f;  //요금
        int in;
        int out;
        int totalTime;
        boolean isOut;
        String num;
        
        public Record(String num,int in){
            this.f = 0;
            this.in = in;
            this.out = 0;
            this.isOut = false;
            this.totalTime=0;
            this.num = num;
        }
    }
}