import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Car[] cars = new Car[routes.length];
        
        for(int i = 0 ; i < routes.length ; i++){
            cars[i] = new Car(routes[i][0],routes[i][1]);
        }
        Arrays.sort(cars , (c1,c2) -> c1.end-c2.end);
        
        answer++;
        int start = cars[0].start;
        int end = cars[0].end;
        for(int i = 1 ; i < cars.length ; i++){
            if(end >= cars[i].start) continue;
            end = cars[i].end;
            answer++;
        }
        
        return answer;
    }
    
    static class Car{
        int start;
        int end;
        public Car(int start, int end){
            this.start = start;
            this.end =end;
        }
    }
}