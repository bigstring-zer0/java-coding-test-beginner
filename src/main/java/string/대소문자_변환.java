package string;

import java.io.IOException;

public class 대소문자_변환 {

    public static String solution(String str) {
        String answer = "";
        // for each 문을 활용하여 Character 클래스의 isUpperCase(), isLowerCase() 활용
        // 대문자라면 Character 클래스의 toLowerCase(), 소문자라면 toUpperCase()로 대소문자를 반전
        // 반전시킨 값을 answer에 저장
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                answer += Character.toLowerCase(c);
            } else {
                answer += Character.toUpperCase(c);
            }
        }

        // Char은 메모리에 숫자로 저장된다. A(65)와 a(97)은 32가 차이나기 때문에 이를 이용한 풀이법
        // 단, char 형 자료와 숫자를 더했을때 해당 결과값을 문자열과 더하더라도 문자열로 자동 캐스팅되지 않는다.
        // 그래서 char 형 자료와 숫자를 더한후 다시 (char)로 캐스팅 한 후에 문자열과 더해준다.

        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                answer += (char) (c + 32);
            } else {
                answer += (char) (c - 32);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(대소문자_변환.solution("StuDY"));
    }
}
