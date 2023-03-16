
import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int i = 1;
        int now = section[0];
        while(i < section.length){
            if(now+m-1 < section[i]){
                now = section[i];
                answer++;
            }
            i++;
        }
        return answer;
    }
}