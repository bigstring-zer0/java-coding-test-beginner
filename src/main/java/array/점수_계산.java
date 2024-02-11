package array;

import java.io.IOException;

public class 점수_계산 {
    public static int solution(int n, int[] arr) {
        int point = 0;
        int answer = 0;

        // 연속으로 받을 맞힐경우, point 값을 계속 누적해주면서
        // 연속으로 정답을 맞힌 수 만큼 answer에다가 point를 누적해주면서 문제를 풀면 된다.
        // 점수 계산 시작 val이 1이면 정답을 맞춤, 0이면 정담을 맞추지 못함.
        for (int val : arr) {
            // 만약 정답을 맞혔다면,
            if (val == 1) {
                // 정답을 맞췄으므로 point값 1증가
                point++;
                // 연속으로 정답을 맞춘 횟수 만큼 point가 누적되어있으므로
                // 정답을 맞출때마다 answer에 point를 즉시 누적.
                answer += point;
                // 만약 정답을 맞추지 못했다면,
            } else {
                // point를 0으로 초기화.
                point = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution(10, new int[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 0}));
    }
}
