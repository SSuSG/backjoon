package kako;

public class solution4 {

    public static void main(String[] args) {

    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        int[][] path = new int[n+1][n+1];
        int intensity = Integer.MAX_VALUE;

        for (int i = 0; i < paths.length; i++) {
            path[paths[i][0]][paths[i][1]] = paths[i][2];
        }

        // gates중 하나로 시작과 끝
        // summits중 하나만 거쳐야함
        // intensity는 최저



        return answer;
    }
}
