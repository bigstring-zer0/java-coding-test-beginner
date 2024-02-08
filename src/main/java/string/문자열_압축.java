package string;

import java.io.IOException;

public class 문자열_압축 {
    public static String solution(String str) {
//        StringBuilder answer = new StringBuilder();
//        int len = str.length();
//
//        // 이중 루프를 활용한 풀이법
//        // 시간복잡도 O(N^2)
//        int i = 0;
//        // i가 len보다 같거나 크면 반복문 종료
//        while (i < len) {
//            int cnt = 0;
//            // 주어진 문자열에서 연속해서 반복되는 갯수를 계산하기위한 기준 문자
//            char target = str.charAt(i);
//            // 기준 문자 위치를 시작으로 순차적으로 탐색
//            for (int j = i; j < len; j++) {
//                // 만약 기준 문자와 순차적으로 탐색한 문자가 같다면
//                if (target == str.charAt(j)) {
//                    // 카운팅
//                    cnt++;
//                    // 아니라면
//                } else {
//                    // 주어진 문자열 끝까지 탐색할 필요가 없으므로 for 루프를 빠져나온다.
//                    break;
//                }
//            }
//            // i값을 현재 기준문자가 존재하는 갯수만큼 더해주면 현재 기준문자와 다른문자가 시작하는 위치부터 탐색
//            i += cnt;
//            // 갯수를 카운팅한 기준문자를 answer에 누적
//            answer.append(target);
//            // 만약 기준문자의 연속해서 반복하는 갯수가 1이 아니라면
//            if (cnt != 1) {
//                // 몇번 연속해서 반복하는지 갯수를 answer에 이어서 누적
//                answer.append(cnt);
//            }
//        }
//        return answer.toString();

        // 현재 접근한 문자와 현재 접근한 문자의 바로뒤 문자를 비교하면서 풀이
        // 시간 복잡도 O(N)
        StringBuilder answer = new StringBuilder();
        // 주어진 문자열의 마지막 문자에 접근했을때 마지막 문자의 다음 위치에 접근하려면 예외가 발생하므로
        // 예외 발생을 방지하고자 마지막에 공백 삽입
        str = str + " ";
        int cnt = 1;
        // i번째 문자와 i+1 번째 문자를 한번에 비교하므로 예외 발생을 방지하기 위해
        // 반복문을 str.length() - 1 번째까지 반복
        for (int i = 0; i < str.length() - 1; i++) {
            // i번째 문자와 i+1 번째 문자를 한번에 비교하여 만약 같다면
            if (str.charAt(i) == str.charAt(i + 1)) {
                // cnt 1증가
                cnt++;
                // 만약 다르다면
            } else {
                // 이때까지 카운팅한 연속해서 반복하는 문자를 answer에 누적
                answer.append(str.charAt(i));
                // 문자의 반복 갯수가 2보다 작다면 생략해줘도 됨으로 만약 문자의 반복 갯수가 1보다 크다면
                if (cnt > 1) {
                    // 반복 문자 갯수를 answer에 누적
                    answer.append(cnt);
                }
                // 새로운 문자의 연속해서 반복하는 갯수를 카운팅 할것이므로 cnt를 1로 초기화.
                cnt = 1;
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(문자열_압축.solution("KKHSSSSSSSE"));
    }

}
