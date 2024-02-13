package array;

import java.io.IOException;

public class 멘토링 {
    public static int solution(int n, int m, int[][] arr) {
        int answer = 0;
        int iRank, jRank;
        boolean isMatch;
        // 바로 직전의 문제와 비슷한 문제다.
        //i학생을 기준으로 하여 한번이라도 j학생이 i 학생보다 m번의 테스트 동안 등수가 높은 적이 있다면
        // 두 학생은 멘토가 될수 없다는 점을 활용하여 문제를 풀것이다.
        // i학생을 기준으로 하여 한번이라도 j학생이 i 학생보다 m번의 테스트 동안 등수가 높은 적이 있다면
        // 두 학생은 멘토가 될수 없으므로 바로 루프를 종료하고 i학생과 비교할 다음 j 학생을 정한다.
        // 이렇게 i와 j가 멘토 멘티가 될수 있는 모든 경우의 수를 루프가 실행되는 동안 i와 j학생을 정하면서,
        // m번의 테스트 동안 해당 학생들의 등수를 비교하며 멘토와 멘티가 될수있는 경우의 수를 찾을것이다.
        // i학생 정하기 학생번호는 1번부터 시작
        for (int i = 1; i <= n; i++) {
            // j학생 정하기
            for (int j = 1; j <= n; j++) {
                // 동일한 학생이 멘토 멘티 둘다 될수 없으므로 i와 j가 다른경우에만 테스트 결과를 본다.
                if (i != j) {
                    // 일단 i와 j 두 학생은 멘토와 멘티가 될수 있다고 가정한다.
                    isMatch = true;
                    // 테스트 회차 정하기 - k회차
                    for (int k = 0; k < m; k++) {
                        iRank = jRank = 0;
                        // 등수 정하기 - s등
                        for (int s = 0; s < n; s++) {
                            // 만약 k회차 s등을 기록한 학생이 멘토가 될수 있는지를 판별하는 i 학생이라면,
                            if (arr[k][s] == i) {
                                // i학생의 랭크는 s등이므로 s를 저장
                                iRank = s;
                                // 그게아니라 k회차 s등을 기록한 학생이 멘티가 될수 있는지를 판별하는 j학생이라면,
                            } else if (arr[k][s] == j) {
                                // j학생의 랭크는 s등이므로 s를 저장
                                jRank = s;
                            }
                        }
                        // 하나의 시험 결과를 탐색했을때 만약 멘토 후보 학생의 등수가 멘티 후보 학생의 등수보다 낮은 경우가 한번이라도 있다면,
                        // 만약에 iRank의 값이 1, jRank의 값이 0이라면 i학생의 등수가 j학생의 등수보다 낮다.
                        // 등수 자체의 값이 작을수록 등수가 높다는걸 의미한다.
                        if (iRank > jRank) {
                            // i 학생과 j 학생은 절대 멘토 멘티 관계가 될 수 없다.
                            isMatch = false;
                            // i 학생과 j 학생은 이미 멘토 멘티가 관계가 될 수 없다는 것을 알았으므로,
                            // 남은 회차의 시험 결과를 탐색할 필요 없이 바로 시험 회차를 정하는 루프를 종료하고,
                            // 다음 멘티 후보인 j 학생을 정한다.
                            break;
                        }
                    }
                    // i학생, j학생 두 학생의 k회의 시험 결과를 모두 탐색했음에도
                    // 문제에서 요구하는 멘토, 멘티 관계가 될 자격을 충족한다면
                    if (isMatch) {
                        // i 학생과 j 학생이 멘토 멘티 관계가 될 수 있는 경우의수를 찾았으므로 answer값 1 증가
                        answer++;
                    }
                }
            }
        }
        return answer;

    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution(4,3, new int[][]{
                {3, 4, 1, 2},
                {4, 3, 2, 1},
                {3, 1, 4, 2},
        }));
    }
}
