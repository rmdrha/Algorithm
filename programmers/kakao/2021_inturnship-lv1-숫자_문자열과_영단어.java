import java.util.*;
class Solution {
    public int solution(String s) {
        HashMap<String,String> map = new HashMap<>();
        // 기준이 될 map 생성
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
        // System.out.println(map);
        // System.out.println(s);
        String convert = "0";

        int i = 0;
        // System.out.println(s.length());
        for (int j=1; j<s.length()+1; j++) {
            // System.out.println("찾아줘"+s.substring(i,j));
            // 숫자이면 convert에 추가하고 넘기기
            if(map.containsValue(s.substring(i,j))) {
                // System.out.println("i = "+i);
                // System.out.println("j = "+j);
                // System.out.println(s.substring(i,j));
                convert=convert+s.substring(i,j);
                // System.out.println("convert = "+convert);
                i=j;
            }
            // 문자이면 한글자씩 늘리며 key로 존재하는지 찾기 -> convert에 추가하기
            if(map.containsKey(s.substring(i,j))) {
                // System.out.println(j);
                // System.out.println(s.substring(i,j));
                convert=convert+map.get(s.substring(i,j));
                // System.out.println(convert);
                i=j;
            }
        }
        int answer = Integer.parseInt(convert);
        return answer;
    }
}