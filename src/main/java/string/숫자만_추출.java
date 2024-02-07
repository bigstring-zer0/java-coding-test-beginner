package string;

import java.io.IOException;

public class 숫자만_추출 {

    public static int solution(String str) {
        String answer = "";
        // for each문을 활용하여
        for (char c : str.toCharArray()) {
            // 순차적으로 접근한 문자값이 숫자라면
            if (Character.isDigit(c)) {
                // answer에 문자열 형태로 값을 업데이트
                answer += c;
            }
        }
        // answer의 값이 "00125" 이렇게 저장될수도 있으므로 125로 변환하기 위해서
        // parseInt를 사용해서 문자열 값을 정수값으로 변환하여 리턴
        return Integer.parseInt(answer);

//        int answer = 0;
//        // 문자 '0' - '9' 까지의 정수값은 48 - 57이다 이 사이에 있는 문자는 '0' - '9'라는걸 이용
//        for (char c : str.toCharArray()) {
//            // '0' 부터 '9' 까지에 포함된 문자라면
//            if (c >= 48 && c <= 57) {
//                // answer 에다가 값을 누적시킨다.
//                // c - 48을 할때 만약 answer는 0, c가 '0'이라면 정수와 연산을 하게 되면 48이다
//                // 48 - 48은 0이므로 answer(0) * 10 + (48-48) = 0이므로 answer는 0이 된다.
//                // 다음으로 접근한 문자가 '5'이라면 정수값으로 53이다.
//                // answer(0) * 10 + (53-48) = 5이므로 answer에는 문자'5'가 아닌 정수값 5가 저장된다.
//                // 이렇게 접근한 문자가 '0' - '9'까지의 문자라면 문자값을 정수형으로 변환해서 answer에 값을 업데이트
//        }
//        return answer;

//        // 정규식을 활용한 풀이법
//        // 정규식을 활용하여 '0' - '9'를 제외한 문자값을 제거
//        str = str.replaceAll("[^0-9]", "");
//
//        // 정규식을 화용하여 '0' - '9'를 제외만 문자값을 제거한 문자열이 "00125"일수도 있기 때문에
//        // parseInt()를 활용하여 문자열값을 정수값으로 변환
//        int answer = Integer.parseInt(str);
//        return answer;

    }

    public static void main(String[] args) throws IOException {
        System.out.println(숫자만_추출.solution("g0en2T0s8eSoft"));
    }
}
