import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayList<Integer> basket = new ArrayList<>();
        // Queue<Integer> basket = new LinkedList<>();
        for(int i=0; i<moves.length; i++) {
            int point = moves[i]-1;
            for(int j=0; j<board.length; j++) {
                if(board[j][point] != 0) {
                    // 가장 위에 있는 인형을 찾는다
                    int doll = board[j][point];
                    // 인형을 뺀다
                    board[j][point] = 0;
                    basket.add(doll);
                    break;
                }
            }            
        }
        // System.out.println(basket);
        
        //최소 필요한 loop size = 모두 사라진다는 가정 하에 basket size/2
        int answer = 0;
        int loopsize = basket.size()/2;
        while(loopsize>0) {
            for(int j=0; j<basket.size()-1; j++) {
                if(basket.get(j) == basket.get(j+1)) {
                    basket.remove(j+1);
                    answer++;
                    basket.remove(j);
                    answer++;
                }
            }
            loopsize--;
        }
        
        // System.out.println(basket);
        return answer;
    }
}