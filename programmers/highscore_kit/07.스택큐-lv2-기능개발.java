import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        //queue에 넣기
        for(int i=0; i<progresses.length; i++) {
            queue.add(progresses[i]);
        }
        for(int i=0; i<speeds.length; i++) {
            queue2.offer(speeds[i]);
        }
        // int day = 0;
        while(true) {
            // 가장 첫 요소가 나갈 수 있는 날짜 days 구하기
            while(queue.peek() < 100) {
                for(int i=0; i<queue2.size(); i++) {                    
                    int speed = queue2.poll();
                    queue.offer(queue.poll()+speed);
                    queue2.offer(speed);
                }
                // day++;
            }
            int size = 0;
            for(int j=0; j<queue.size(); j++) {
                if(queue.peek() < 100) {
                    break;
                } else { //100보다 크면 빼기 
                    queue.offer(queue.poll());
                    queue2.poll();
                    size++;
                }
            }
            //queue 원래대로 돌려놓기
            int correction = queue.size() - size;
            for(int k=0; k<correction; k++) {
                queue.offer(queue.poll());
            }
            for(int l=0; l<size; l++) {
                queue.poll();
            }
            //size를 return 에 던지기
            temp.add(size);
            if(queue.size()==0) {
                break;
            }
        }

        int[] answer = new int[temp.size()];
        int k = 0;
        for(Integer t : temp) {
            answer[k++] = t;
        }
        return answer;
    }
}