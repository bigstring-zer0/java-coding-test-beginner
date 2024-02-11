package array;

import java.io.IOException;

public class 등수_구하기 {
    public static int[] solution(int n, int[] arr) {
        // rank를 1로 초기화한 이유는 예를 들어 3명중에 자신보다 2명이 있을때,
        // 점수가 높은 학생이 발견될때 마다 rank 값을 1 증가 시킨다면 자신보다 높은 점수의 학생이 2명이므로,
        // rank 값은 초기값 1에서 +2 그러니까 3이 된다.
        // 해당학생은 자신보다 점수가 높은 사람이 2명이므로 3등이 되어야 하는데 올바르게 등수가 책정된다.
        int rank = 1;
        int[] answer = new int[n];

        // 하나의 루프를 활용하여 먼저 등수를 계산하려는 학생(i번째 학생)의 점수를 arr[i]로 정하고
        // 루프를 하나 더 활용하여 arr[j]로 나머지 학생(j번째 학생)들과 점수를 비교하며
        // 등수를 구하려는 학생의 점수인 arr[i] 보다 큰값이 있다면 rank 값을 1증가.
        // 여기서 rank값이 1 증가한다는 의미는 등수가 한단계 떨어진다는 의미다.
        // 점수가 같은 학생이 여러명이더라도, 기준 학생의 점수보다 작은 점수일 경우에만 rank 값을 증가시키므로,
        // 동일한 점수가 여러명인 경우 동일하게 rank가 기록된다.
        // 등수 계산 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 만약 기준 학생의 점수보다 높은점수의 학생이 발견된다면,
                if (arr[i] < arr[j]) {
                    // 등수가 한단계 밀려난다는 의미이므로, rank값 1증가.
                    rank++;
                }
            }
            // 기준 학생과 나머지 학생들의 점수 비교가 끝났다면 기준학생의 랭크를
            // 기준 학생은 i번째 학생이므로, i번째 위치에 rank를 기록
            answer[i] = rank;
            // i번째 학생에 대한 랭크 측정을 완료했으니 다음 i번째 학생의 랭크를 새롭게 측정해야한다.
            // 새로운 i번째 학생의 rank를 측정해야하므로, rank값을 1로 초기화
            rank = 1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        for (int val : solution(5, new int[]{92, 100, 92, 75, 92})) {
            System.out.print(val + " ");
        }
    }
}
