import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> map = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<String[]>();
        for(int i=0; i<record.length; i++) {
            // System.out.println(record[i]);
            String[] record_arr = record[i].split(" ");
            
            if(record_arr[0].equals("Enter")) {
                map.put(record_arr[1],record_arr[2]);
                list.add(new String[]{record_arr[1],"님이 들어왔습니다."});
                // System.out.println(record_arr[1]+"님이 들어왔습니다");
            }
            else if(record_arr[0].equals("Change")) {
                map.put(record_arr[1],record_arr[2]);
            }
            else {
                list.add(new String[]{record_arr[1],"님이 나갔습니다."});
                // System.out.println(record_arr[1]+"님이 나갔습니다.");
            }
        }
        // System.out.println(map);
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            String s = map.get(list.get(i)[0]) + list.get(i)[1];
            // System.out.println(s);
            answer[i] = s;
        }
        return answer;
    }
}