package string;

import java.io.IOException;

public class 중복_문자열_제거 {

    public static String solution(String str) {
        String answer = "";

        // 입력받은 문자열의 각문자열에 대해 indexOf("순차적으로 하나씩 접근한 문자") 를 활용해서 인덱스값을 반환받는다.
        // 입력받의 문자열을 순차적으로 접근할때 순자적으로 접근한 문자의 인덱스 번호와 indexOf("현재 인덱스를 활용하여 접근한 문자")가 반환한 값이 다르다면
        // 이미 해당 문자는 해당 문자열 보다 앞에 위치해있다는 의미다.
        // 왜냐하면 indexOf("찾으려는 문자")는 문자열중에서 앞에서부터 해당 문자가 위치한 인덱스 값을 반환하기 때문이다.
        // 만약 입력받은 문자열에서 접근하려는 문자의 인덱스 번호와 indexOf("현재 인덱스를 활용하여 접근한 문자")가 반환한 값이 같다면
        // 입력받은 문자열에서 처음 발견된 문자이므로 answer에 해당 문자를 누적시킨다.
        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(중복_문자열_제거.solution("ksekkset"));
    }
}
