package string;

import java.io.IOException;

public class 문장_속_단어 {

    public static String solution(String str) {
        String answer = "";
        int maxVal = Integer.MIN_VALUE;

        // for each문을 활용하여 푸는 방법
        // split() 메서드를 활용하여 빈칸을 기준으로 문자열을 분리한다.
        // 분리된 문자열을 하나씩 접근하여 해당 문자열의 길이를 구한다.
        // 문자열의 길이가 최대 문자열의 길이 값이 저장된 maxVal보다 큰경우에 maxVal값을 업데이트한다.
        // 최대 문자열 값을 구했으므로 answer을 현재 접근한 문자열로 업데이트.
        String[] strArr = str.split(" ");
        for (String s : strArr) {
            int len = s.length();
            if (len > maxVal) {
                maxVal = len;
                answer = s;
            }
        }

        // while 문을 활용하여 푸는 방법
        // indexOf()는 해당 문자열 앞에서부터 찾고자하는 문자열이 위치한 인덱스를 반환한다.
        // indexOf()의 반환값을 pos에 저장하고 -1과 다른지 비교한다.
        // pos의 값이 -1이라면 찾고자하는 해당 문자열이 없다는 의미므로 while 문을 종료한다.
        // 입력받은 문자열의 공백을 찾아 해당 공백 바로 앞에 위치한 문자열의 길이 값을 계산한다.
        // 계산한 문자열의 길이가 이전에 계산한 문자열의 길이보다 클경우 문자열의 최대 길이값을 업데이트
        // 문자열의 최대 길이값을 업데이트 했다는 의미는 해당 문자가 공백을 기준으로 나눴을때 가장 길이가 길다는 의미.
        // 따라서 answer에 해당 문자열 값으로 업데이트.
        // 하지만 해당 풀이법은 공백을 기준으로 가장 마지막 문자열에는 접근하지 못하고 while 문이 종료된다.
        // 따라서 만약 while문이 종료되고 공백을 기준으로 가장 마지막에 위치한 문자열의 길이가 현재 문자열의 최대 길이값보다 큰 경우가 있을 수 있다.
        // 만약 공백을 기준으로 가장 마지막에 위치한 문자열의 길이가 현재 문자열의 최대 길이 값보다 크다면 answer에 해당 문자열 값으로 업데이트.
        int pos;
        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > maxVal) {
                maxVal = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);

        }
        if (str.length() > maxVal) answer = str;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(문장_속_단어.solution("it is time to study"));
    }
}
