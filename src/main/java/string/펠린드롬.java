package string;

import java.io.IOException;

public class 펠린드롬 {

    public static String solution(String str) {

        // 정규식을 이용한 풀이
        // 입력받은 문자열을 대문자로 변환한 후에 정규식을 사용하여 "[^A-Z]"
        // 그러니까 A부터 Z까지의 문자가 아니라면 "" 처럼 삭제
        // 그러면 입력받은 문자열은 A - Z 까지만 남게 된다.
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        // StringBuilder의 reverse()를 활용 문자열을 뒤집는다.
        String tmp = new StringBuilder(str).reverse().toString();
        // 입력받은 문자열과 뒤집은 문자열을 비교한다.
        if (tmp.equals(str)) {
            // 입력받은 문자열과 뒤집은 문자열이 같다면 "YES"를 리턴하고 함수를 종료            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(펠린드롬.solution("stuats"));
    }
}
