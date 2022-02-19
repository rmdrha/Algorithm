import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<participant.length; i++) {
            //key가 이미 있는지 확인
            if(map.containsKey(participant[i])) {
                int cnt = map.get(participant[i]);
                map.put(participant[i],cnt+1);
            } else {
                map.put(participant[i],1);
            }
            
        }
        // System.out.println(map);
        for(int j=0; j<completion.length; j++) {
            //이름이 하나뿐이면 바로 삭제
            if(map.get(completion[j])==1) {
                map.remove(completion[j]);    
            } else {
                int cnt = map.get(completion[j]);
                map.put(completion[j],cnt-1);
            }
        }
        // System.out.println(map);
        Set<String> keySet = map.keySet();
        // String answer = keySet.toArray()[0];
        String answer = "";
        for(String key : keySet) {
            answer = key;
        }
        return answer;
    }
}