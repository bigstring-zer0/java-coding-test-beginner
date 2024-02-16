package 투포인터_슬라이딩윈도우;

import java.io.IOException;

public class 최대_길이_연속_부분_수열 {
    public static int solution(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        int lt = 0;
        int len;

        // 해당 문제는 투포인터를 활용하여 푸는 문제다
        // rt 값이 1 증가한다.
        // 만약 arr[rt]값이 0 이라면 무조건 1로 바꿔주고 카운팅을 한다.
        // 0에서 1로 바꿔준 갯수가 k개를 넘기면 안되기 때문에 lt를 활용하여 오른쪽으로 한칸씩 이동하며
        // 0에서 1로 바꿔준 원소를 다시 1에서 0으로 바꿔줘야한다.
        // 만약 그리고 0에서 1로 바꿔준 횟수가 k와 같아지면 루프를 빠져나온다.
        // 현재 lt 부터 rt까지의 원소 길이를 계산한다.
        // lt 부터 rt까지의 원소 길이 최대값과 현재 계산한 len을 비교하여 최대값을 answer에 저장한다.
        // rt가 n과 같아지면 탐색 종료

        // 탐색시작
        for (int rt = 0; rt < n; rt++) {
            // 만약 rt가 가리키고 있는 값이 0이라면,
            if (arr[rt] == 0) {
                // 0에서 1로 바꿔준다고 가정하고 바꿔준 횟수를 1 증가한다.
                cnt++;
            }
            // 만약 0에서 1로 바꿔준 횟수가 k보다 크다면 루프 실행
            // lt를 활용해서 0에서 1로 바꿔준 원소를 다시 1에서 0으로 바꿔준다.
            while (cnt > k) {
                // 만약 lt가 가리키는 값이 0이라면,
                if (arr[lt] == 0) {
                    // 다시 1에서 0으로 바꿧다고 가정하고 바꿔준 횟수 1감소.
                    cnt--;
                }
                // 1에서 0으로 바꿔주고 1증가 또는 lt가 가르키는 값이 1이라면 바로 1증가.
                lt++;
            }
            // lt 부터 rt까지의 원소 길이 계산
            // 인덱스는 0부터 시작하므로 원소의 길이를 계산하기 위해서는 1을 더해줘야한다.
            len = rt - lt + 1;
            answer = Math.max(answer, len);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solution(14, 2, new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1}));
    }
}
