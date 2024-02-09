package array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 가위_바위_보 {
    public static List<String> solution(int n, int[] aPerson, int[] bPerson) {
        List<String> answer = new ArrayList<>();

        // 딱히 어떠한 알고리즘을 요구하는 문제는 아닌것 같다.
        // 주어진 문제에서 가위바위보를 했을때 결과값에 따른 규칙을 찾아서 구현하는 문제인것같다.
        //
        // 가위는 1, 바위는 2, 보는 3 이렇게 가위 바위 보가 각각 수자로 표현되었다보니
        // 가위바위보를 했을때 abs() 메서드를 활용하여 각 상황의 숫자 차이를 이용하여 문제를 풀기로 했다.
        for (int i = 0; i < n; i++) {
            // 만약 A와 B가 같은 경우는 D를 answer에 추가한다.
            if (aPerson[i] == bPerson[i]) {
                answer.add("D");
                // 그게 아니라면 A와 B가 각각 다른것을 냇다는 의미다.
            } else {
                // A와 B가 낸것의 차이가 1이 난다면,
                if (Math.abs(aPerson[i] - bPerson[i]) == 1) {
                    // 그중에서 A가 낸것이 B가 낸것보다 크다면,
                    if (aPerson[i] > bPerson[i]) {
                        // 승자는 A
                        answer.add("A");
                        // 그게 아니라 B가 낸것이 A가 낸것보다 크다면,
                    } else {
                        // 승자는 B
                        answer.add("B");
                    }
                    // A와 B가 낸것이 차이가 2가 난다면,
                } else if (Math.abs(aPerson[i] - bPerson[i]) == 2) {
                    // 그중에서 A가 낸것이 B가 낸것보다 작다면,
                    if (aPerson[i] > bPerson[i]) {
                        // 1이 차이날때와는 달리 B가 승자
                        answer.add("B");
                        // 그게아니라, B가 낸것이 A가 낸것보다 작다면,
                    } else {
                        // 1이 차이날때와는 달리 A가 승자
                        answer.add("A");
                    }
                }
            }
        }

//        // 문제에서 주어진 결과표를 보고 직관적으로 구현한 코드.
//        // A와 B가 비긴경우와 A가 이긴경우를 제외하면 나머지는 B가 이긴다는 것을 이용한 코드.
//        List<String> answer = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            // A와 B가 같은것을 낸 경우
//            if (aPerson[i] == bPerson[i]) {
//                answer.add("D");
//                // A가 가위를 내고 B가 보를 낸 경우
//            } else if (aPerson[i] == 1 && bPerson[i] == 3) {
//                // 승자는 A
//                answer.add("A");
//                // 아니면, A가 바위 내고 B가 가위를 낸 경우
//            } else if (aPerson[i] == 2 && bPerson[i] == 1) {
//                // 승자는 A
//                answer.add("A");
//                // 아니면, A가 보를 내고 B가 바위를 낸 경우
//            } else if (aPerson[i] == 3 && bPerson[i] == 2) {
//                // 승자는 A
//                answer.add("A");
//                // A와 B가 비긴경우와 A가 이긴경우가 아닌 다른 경우라면,
//            } else {
//                // 나머지 경우의 승자는 B
//                answer.add("B");
//            }
//        }
//        return answer;

        return answer;

    }
    public static void main(String[] args) throws IOException {
        for (String s : solution(5, new int[]{2, 3, 3, 1, 3}, new int[]{1, 1, 2, 2, 3})) {
            System.out.println(s);
        }
    }
}
