import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            queue.offer(scoville[i]);
        }
        // 만약 queue의 모든 요소가 K보다 크지 않으면 커질때까지..
        while(queue.peek() < K) {
            // queue의 요소가 2개보다 적다면 계산 불가
            if(queue.size() < 2) {
                answer = -1;
                break;
            } else {
                queue.offer(queue.poll() + (queue.poll() * 2));  
                answer++;
            }            
        }
        System.out.println(queue);
        return answer;
    }
}