package string;

import java.io.IOException;
import java.util.Arrays;

public class 가장_짧은_문자거리 {
    public static int[] solution(String str, char ch) {
        int len = str.length();
        int[] answer = new int[len];

        // 문제를 보자마자 두개의 반복문이 필요하다고 생각이 들었다.
        // 주어진 문자열의 하나를 순차적으로 접근해 해당 위치 i를 기준으로 잡았다.
        // 기준으로 잡은 위치를 시작으로 찾는 문자 ch를 찾을때까지 lt는 기준의 왼쪽으로 rt는 기준의 오른쪽으로 탐색한다.
        // 탐색하다가 lt 또는 rt가 가르키는 위치의 문자가 찾는 문자 ch와 동일하다면
        // 현재 거리를 구하는 기준위치 i와 lt또는 rt와의 차이를 구하면 가장 짧은 문자거리를 계산할 수 있다.
         for (int i = 0; i < len; i++) {
             // 기준 i의 왼쪽으로 탐색할 lt, 오른쪽으로 탐색할 rt
             int lt = i, rt = i;
             while (true) {
                 // 만약 왼쪽으로 탐색하다가 찾는문자 ch가 발견되면,
                 if (str.charAt(lt) == ch) {
                     // lt - i 값을 기준 문자가 있는 i의 위치에 업데이트한다
                     // abs 메서드를 사용하는 이유는 lt = 0, i = 1일 경우 -1 처럼 음수가 될수 있기때문에
                     // 음수 인덱스위치에 저장하려고 하면 예외가 발생하기 때문에 abs()를 사용했다.
                     answer[i] = Math.abs(lt - i);
                     // 답을 구한이상 더이상 while문을 실행할 필요가 없으므로 while문을 빠져나온다.
                     break;
                     // 만약 오른쪽으로 탐색하다가 찾는 문자 ch가 발견된다면,
                 } else if (str.charAt(rt) == ch) {
                     // rt - i 값을 기준 문자가 있는 i의 위치에 업데이트
                     answer[i] = Math.abs(rt - i);
                     break;
                     // 만약 lt, rt가 가르키는 위치 둘다 찾는문자 ch가 발견되지 않았다면
                 } else {
                     // 인덱스 예외발생을 방지하기 위해, 만약 lt가 문자열의 첫번째 인덱스를 가르키는 0보다 크다면 1을 감소
                     if (lt > 0) lt--;
                     // 인덱스 예외발생을 방지하기 위해, 만약 rt가 문자열의 마지막 인덱스를 가르키는 len-1 보다 작다면 1을 증가
                     if (rt < len-1) rt++;
                 }
             }

         }
         return answer;
//        // 오른쪽, 왼쪽 두방향으로 탐색하는 풀이
//        // 양방향으로 탐색하는 이유는 순차적으로 접근한 문자가 오른쪽방향 기준으로 가장 가까울수 있고
//        // 왼쪽 방향으로 가장 가까울수 있기 떄문이다.
//        // 오늘쪽 방향으로 일단 탐색
//        int len = str.length();
//        int[] answer = new int[len];
//        int p = 1000;
//        for (int i = 0; i < len; i++) {
//            // 접근한 문자가 찾는 문자와 같다면
//            if (str.charAt(i) == ch) {
//                // p를 0으로 초기화
//                p = 0;
//                // answer의 해당 위치에 거리값 p를 업데이트
//                answer[i] = p;
//                // 그게 아니라면 접근한 문자가 찾는 문자와 다르다는 의미
//            } else {
//                // 거리값 1증가
//                p++;
//                // answer의 해당 위치에 거리값 p를 업데이트
//                answer[i] = p;
//            }
//        }
//
//        // 오른쪽으로 탐색했으니 왼쪽으로 탐색
//        p = 1000;
//        for (int i = len; i >= 0; i--) {
//            // 접근한 문자가 찾는 문자와 같다면
//            if (str.charAt(i) == ch){
//                // 오른쪽으로 탐색했을때 이미 answer에 0으로 값이 저장되어 있으므로 p값만 0으로 초기화.
//                p = 0;
//            }
//            // 그게 아니라면 현재 순차적으로 접근한 문자와 찾는문자의 거리가 있다는 의미
//            else {
//                // p값을 1증가
//                p++;
//                // 이미 오른쪽 방향으로 탐색한 거리값이 저장되어 있다.
//                // 이 값과 왼쪽으로 탐색하여 거리값을 계산한 값중 더 작은 값이 더 가까운 거리다.
//                // 더 작은값을 answer의 해당 위치에 거리값 p를 업데이트
//                answer[i] = Math.min(answer[i], p);
//            }
//        }
//        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(가장_짧은_문자거리.solution("teachermode", 'e')));
    }
}
