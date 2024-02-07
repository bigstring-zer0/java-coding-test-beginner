package string;

import java.io.IOException;

public class 회문_문자열 {

    public static String solution(String str) {
        str = str.toUpperCase();
        int n = str.length();

//        // 회문 문자열의 특징은 앞에서 부터 읽어도 뒤에서 부터 읽어도 똑같은 문자열을 의미한다.
//        // 그래서 입력받은 문자열을 전부 접근할 필요가 없고 입력받은 for문을 활용하여
//        // 문자열의 길이 / 2 만큼만 반복하면 입력받은 문자열의 길이가 홀수던 짝수던
//        // 회문 문자열인지 알 수 있다.
        for (int i = 0; i < n / 2; i++) {
            // 현재 접근한 문자와 현재 접근한 문자열과 대칭위치에 있는 문자가 같은지를 확인
            // 만약 입력받은 문자열의 길이(n)가 5이고 i = 0 이라면
            // 0번째 문자 != (5-1-0) = 4, 그러니까 0번째 문자와 4번째 문자가 같은지 확인한다.
            // 그다음 1번째 문자 != 3번째 문자도 비교한다.
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                // 만약 비교했을때 문자가 서로 다르다면 "NO" 리턴하고 함수를 종료
                return "NO";
            }
        }
        return "YES";

//        // 투포인터를 이용한 풀이
//        // 입력받은 문자열의 시작과 끝부분을 각각 lt와 rt로 지정
//        int lt = 0, rt = str.length()- 1;
//        while (lt < rt) {
//            // 지정한 위치의 문자가 서로 다른지 확인
//            if (str.charAt(lt) != str.charAt(rt)) {
//                // 두 위치의 문자가 다르다면 "NO"를 리턴하고 함수를 종료
//                return "NO";
//            }
//            // 지정한 위치의 문자가 서로 다르지 않다는 의미는 같다는 의미이므로
//            // lt값 1증가 rt값 1감소하여 양쪽 끝에서 중심을 향하면서 두 위치의 문자가 같은지 비교한다.
//            lt++;
//            rt--;
//        }
//        return "YES";

//        // StringBuilder의 reverse() 함수를 이용한 풀이
//        StringBuilder sb = new StringBuilder(str);
//        // equalsIgnoreCase() 함수는 대소문자 구분없이 두 문자열이 같은지 비교하는 함수다.
//        if (str.equalsIgnoreCase(sb.reverse().toString())) {
//            // 비교해서 같다면 "YES" 출력하고 함수를 종료
//            // return "YES";
//        }
//        return "NO";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(회문_문자열.solution("stuts"));
    }
}
