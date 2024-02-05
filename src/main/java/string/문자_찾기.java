package string;

import java.io.IOException;

public class 문자_찾기 {
    public static int solution(String str, char c) {
        int answer = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        // for each 문을 활용하여 입력받은 문자열을 toCharArray() 메서드를 활용하여 문자 하나씩 접근.
        // 만약 하나씩 접근한 문자열이 찾는 문자값과 일치한다면 answer을 1 증가시킨다.
        // 문자열과 다르게 문자는 컴퓨터에 저장될때 정수형으로 저장되므로 equals() 메서드로 값을 비교하지 않는다.
        // == 연산을 활용하여 정수값을 비교한다.
        for (char ch : str.toCharArray()) {
            if (ch == c) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(문자_찾기.solution("Computercooler", 'c'));
    }
}
