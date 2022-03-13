import java.util.*;
class Solution {
    public String solution(String new_id) {        
        // 1단계 : 소문자 치환
        new_id = new_id.toLowerCase();
        
        String result = "";
        // 2단계 : 알파벳 소문자, -, _, .만 사용가능
        // new_id = replaceSpecialString(new_id);
        for(int i=0; i<new_id.length(); i++) {
            if(String.valueOf(new_id.charAt(i)).matches("[a-z0-9-_.]")) {
                result += new_id.charAt(i);
            }
        }
        // System.out.println("after2 "+result);
        
        // 3단계 : 마침표 여러개를 하나로
        // . 은 대괄호로 감싸지 않으면 모든 문자를 가리킨다
        result = result.replaceAll("[.]{2,}", ".");
        // System.out.println("after3 "+result);
        
        // 4단계 : 처음이나 끝에 위치한 . 제거
        result = result.replaceAll("^[.]", "");
        result = result.replaceAll("[.]$", "");
        // System.out.println("after4 "+result);
        
        // 5단계 : 빈 문자열이면 new_id에 a대입
        if(result.isEmpty()) {
            result = new_id.replaceAll(".", "a");
            // System.out.println("after5 "+result);
        }
        
        // 6단계 : 16자 이상이면 15자까지만 자름
        if(result.length()>15) {
            result = result.substring(0,15);
            // result = result.replaceAll("^[.]", "");
            result = result.replaceAll("[.]$", "");
            // System.out.println("after6 "+result);
        }
        
        // 7단계 : 2자 이하라면 3자가 될때까지 마지막 글자 추가
        while(result.length()<3){
            String lastchar = result.substring(result.length()-1);
            // System.out.println(lastchar);
            System.out.println(result.length());
            result = result+lastchar;
            // System.out.println("after7 "+result);
        }
        // System.out.println(result);
        String answer = result;
        return answer;
    }
}