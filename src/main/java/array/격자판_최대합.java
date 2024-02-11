package array;

import java.io.IOException;

public class 격자판_최대합 {
    public static int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int rowSum, colSum;

        // 배열에 대해서 잘 이해하고 있으면 쉽게 풀수 있는 문제다.
        // row(행) 방향은 (0,1) (0,2) (0,3) (0,4)... 이렇게 row(행)은 고정이고 col(열)방향으로만 증가한다.
        // col(열) 방향은 (1,0) (2,0) (3,0) (4,0)... 이렇게 row(행)방향으로만 증가하고 col(열)은 고정이다.
        for (int i = 0; i < n; i++) {
            // rowSum과, colSum은 새로운 행, 열의 값을 누적하기전에 0으로 초기화하고
            // 새로운 i 루프를 시작해야한다.
            rowSum = colSum = 0;
            // 하나의 행, 하나의 열 값을 누적하기위한 루프
            for (int j = 0; j < n; j++) {
                // 행 한줄의 모든 값을 rowSum에 누적
                rowSum += arr[i][j];
                // 열 한줄의 모든 값을 colSum에 누적
                colSum += arr[j][i];
            }
            // 먼저 answer 값과 rowSum 값중 큰값을 answer에 저장
            answer = Math.max(answer, rowSum);
            // answer와 rowSum값중 큰값이 저장되어있는 answer 값과 colSum 값중 큰 값을 answer에 저장
            answer = Math.max(answer, colSum);
        }

        // 죄측 최상단에서 우측 최하단 방향의 대각선을 지나는 하나의 대각선의 모든값을 누적
        // 해당 대각선은 (0,0) (1,1) (2,2) (3,3) (4,4)... 처럼 행과 열의 인덱스가 동일하다.
        // 이 원리를 이용하여 배열의 원소에 접근하여 값을 누적한다.
        int sum = 0;
        // 죄측 최상단에서 우측 최하단 방향의 대각선 방향으로 탐색 시작
        for (int i = 0; i < n; i++) {
            // 행과 열의 값이 동일한 배열의 원소에 접근하여 값을 누적
            sum += arr[i][i];
        }
        // 행과 열의 방향으로 값을 누적했을때 하나의 행또는 열에 대해 최대값이 저장되어 있는 answer와
        // 죄측 최상단에서 우측 최하단 방향의 대각선 방향의 값을 비교하여 둘중 큰 값을 answer에 저장
        answer = Math.max(sum, answer);

        // 새로운 방향으로 탐색하기위해 sum값을 0으로 초기화
        sum = 0;
        // 우측 최상단에서 좌측 최하단 방향의 대각선을 지나는 하나의 대각선의 모든값을 누적
        // 해당 대각선은 (0,4) (1,3) (2,2) (3,1), (4,0)... 처럼 행과 열의 값이 변화한다.
        for (int i = 0; i < n; i++) {
            // 만약 n이 5라고 가정했을때,
            // i가 0이라면 arr[0][5-0-1]이 될것이고 이를 계산하면 arr[0][4] 즉 (0,4) 인덱스 값에 접근할 것이다
            // i가 1이라면 arr[1][5-1-1]이 될것이고 이를 계산하면 arr[1][3] 즉 (1,3) 인덱스 값에 접근할 것이다
            // i가 0이라면 arr[2][5-2-1]이 될것이고 이를 계산하면 arr[2][2] 즉 (2,2) 인덱스 값에 접근할 것이다
            // 이렇게 우측 최상단에서 좌측 최하단 방향의 대각선을 지나게 될것이다.
            sum += arr[i][n - i - 1];
        }
        // 모든 하나의 행과 열의 방향과, 하나의 좌측 최상단에서 우측 최하단 방향의 대각성 방향까지
        // 값을 누적했을때의 최대값과 하나의 우측 최상단에서 좌측 최하단 방향의 대각선 방향을 지나는
        // 원소들의 값을 누적한 값중 큰 값을 answer에 저장
        answer = Math.max(sum, answer);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.print(solution(5, new int[][]{
                {10, 13, 10, 12, 15},
                {12, 39, 30, 23, 11},
                {11, 25, 50, 53, 15},
                {19, 27, 29, 37, 27},
                {19, 13, 30, 13, 19}
        }));
    }
}
