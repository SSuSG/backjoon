package programmersLV1;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;

            int[][] newBoard = new int[board.length][board.length];
            newBoard = board;
            for (int i = 0; i < board.length; i++) {

                for (int j = 0; j < board.length; j++) {
                    System.out.print(newBoard[i][j]+" ");
                }
                System.out.println();
            }

            Stack<Integer> basket = new Stack<>();

            return answer;
        }
    }
}
