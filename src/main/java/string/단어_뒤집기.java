package string;

import java.io.IOException;

public class 단어_뒤집기 {
    public static String solution(String str) {

        // for each 문을 활용한 풀이법
        // answer += c 가 아닌 새로 접근하는 문자열을 앞에서 더해준다.
//        String answer = "";
//        for (char c : str.toCharArray()) {
//            answer = c + answer;
//        }
//        return answer;

        // StringBuilder의 reverse() 메서드를 활용한 풀이법
        // StringBuilder를 사용하는 이유는 일반적으로 String 클래스로 문자열을 생성한다.
        // String 객체는 불변이며, 문자열을 생성할때마다 String 객체가 생성되기 때문에 메모리에 계속 객체가 생성된다.
        // StringBuilder를 사용하면 문자를 추가하거나 삭제해도 객체가 생성되지 않으므로 메모리를 효율적으로 사용할 수 있다.
        // String에 대한 연산이 많아지면 StringBuilder를 사용한다.
//        return new StringBuilder(str).reverse().toString();

        // while문을 활용한 이분 탐색을 통한 값 교환방식 풀이법
        // lt와 rt를 활용하여 한번 값 교환이 이루어 지면 lt는 1증가 rt는 1감소를 통해 reverse()를 구현
        // 문자열의 길이가 짝수일 경우 while문은 rt가 lt보다 값이 커지면서 while문을 빠져나온다.
        // 문자열의 길이가 홀수일 경우 lt값과 rt값이 같아지면서 while문을 빠져나온다.
        // 문자열의 길이가 홀수일 경우 가운데 있는 문자값은 교환하지 않아도 되므로 신경쓰지 않아도 된다.
        char[] charArr = str.toCharArray();
        int lt = 0, rt = charArr.length - 1;
        while (lt < rt) {
            char tmp = charArr[lt];
            charArr[lt] = charArr[rt];
            charArr[rt] = tmp;
            lt++;
            rt--;
        }

        return String.valueOf(charArr);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(단어_뒤집기.solution("good"));
        System.out.println(단어_뒤집기.solution("Time"));
        System.out.println(단어_뒤집기.solution("Big"));
    }
}
