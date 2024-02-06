package string;

import java.io.IOException;

public class 특정_문자_뒤집기 {

    public static String solution(String str) {
        char[] charArray = str.toCharArray();
        int lt = 0, rt = charArray.length - 1;

        // while문을 활용한 이분탐색 알고리즘을 사용한 풀이.
        // lt값과 rt값이 같거나 lt값이 rt값보다 클경우 while문을 빠져나온다.
        // while문을 빠져나왔다는 것은 입력받은 문자열을 순차적으로 탐색 완료했다는 의미다.
        // lt가 가리키는 위치의 문자가 알파벳이 아니라면 lt값을 1 증가시킴으로써 lt위치를 변경한다.
        // rt가 가리키는 위치의 문자가 알파벳이 아니라면 rt값을 1 감소시켜서 rt위치를 변경한다.
        // 만약 둘다 아니라면 lt와 rt가 가리키는 위치의 문자가 둘다 알파벳이라는 의미이므로 서료 값을 교환한다.
        // 값을 교환한 다음에 lt값을 1 증가시키고 rt 값을 1 감소시킨다.
        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            } else {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(charArray);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(특정_문자_뒤집기.solution("a#b!GE*T@S"));

    }

}
