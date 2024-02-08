package string;

import java.io.IOException;

public class 암호 {
    // 입력받은 암호를 7글자씩 전달받아 이진수 형태의 문자열로 변환
    public static String toBinary(String str) {
        String tmp = "";
        int val = 0;
        for (char c : str.toCharArray()) {
            // 만약 '#'라면 1을 의미하므로 tmp에 "1"을 누적
            if (c == '#') tmp += "1";
            // 아니라면 '*', 그러니까 0을 의미하므로 tmp에 "0"을 누적
            else tmp += "0";
        }
        return tmp;
    }

    // 이진수 형태의 문자열을 10진수로 변환
    public static int toDecimal(String str) {
        int val = 0;
        // 2의 지수승을 계산하기 위한 square
        // 이진수의 가장 오른쪽부터 1로 시작하므로 1로 초기화
        int square = 1;
        // 입력받은 이진수 형태의 문자열을 변환하기 위해 뒤에서부터 순차 탐색한다.
        for (int i = str.length() - 1; i >= 0; i--) {
            // 만약 순차 접근한 문자열이 '1' 이라면
            if (str.charAt(i) == '1') {
                // 현재 접근한 위치에 있는 2진수를 10진수로 변환한 값을 val에 누적
                val += square;
                // 값을 누적시켰으므로 다음에 접근할 자릿수를 계산하기 위해서 square에 * 2 값으로 초기화.
                square *= 2;
                // 아니라면 해당 위치의 문자값은 '0'을 의미한다.
            } else {
                // 그렇기 때문에 val에다가 자연수 값을 누적시키지 않고 자릿수만 계산한다.
                square *= 2;
            }

        }
        return val;
    }

    public static String solution(String str, int n) {
        String answer = "";

        // 하드코딩 느낌의 풀이
        for (int i = 0; i < n; i++) {
            // 입력받은 문자열의 0번 인덱스부터 7번 인덱스 전까지의 문자열을 tmp에 저장.
            String tmp = str.substring(0, 7);
            // 분리한 암호형태의 문자열을 이진수 형태의 문자열로 변환
            tmp = toBinary(tmp);
            // 이진수 형태의 문자열을 10진수로 변환하고 문자로 변환하기위해 char형태로 캐스팅
            answer += (char) toDecimal(tmp);
            // 입력받은 문자열중에 0부터 7번 인덱스 전까지의 암호는 해석했으므로
            // 해석하지 않은 문자열만 분리해서 str에 저장.
            str = str.substring(7);
        }

        // 자바에서 제공하는 메서드를 활용한 풀이
        for (int i = 0; i < n; i++) {
            // replace() 메서드를 활용하여 입력받은 문자열의
            // 0번 인덱스부터 7번 인덱스 전까지 분리한 문자열 중에서
            // '#'은 '1'로 '*'는 '0'으로 변환
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            // 변환한 2진수 형태의 문자열을 parseInt()로 정수값으로 변환.
            int num = Integer.parseInt(tmp, 2);
            // 변환한 정수값을 문자로 answer에 누적시키기 위해 (char) 형태로 캐스팅
            answer += (char) num;
            // 입력받은 문자열중에 0부터 7번 인덱스 전까지의 암호는 해석했으므로
            // 해석하지 않은 문자열만 분리해서 str에 저장.
            str = str.substring(7);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(암호.solution("#****###**#####**#####**##**", 4));
    }
}
