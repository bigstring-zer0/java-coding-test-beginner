package dfs_bfs_활용;

import java.io.IOException;
import java.util.Scanner;

public class 최대_점수_구하기 {

    static int n, m;
    static int[] scoreArr, timeArr;
    static int answer = Integer.MIN_VALUE;

    static void DFS(int level, int scoreSum, int timeSum) {
        // 만약 문제를 푸는데 소비한 시간이 제한시간 m 보다 크다면,
        if (timeSum > m) {
            // 제한시간을 초과한 것이므로 문제를 더 푸는것이 의미가 없다.
            // 바로 함수 종료
            return;
        }

        // 전체 문제중에서 풀 문제를 모두 선택하고 선택한 문제들을 푸는 시간들의 합이 제한시간보다 작거나 같다면,
        if (level == n && timeSum <= m) {
            // 문제에서 요구하는 조건을 만족하는 문제들을 선택해서 푼것이므로, 최댓값을 계산
            answer = Math.max(answer, scoreSum);
            return;

        } else {
            DFS(level + 1, scoreSum + scoreArr[level], timeSum + timeArr[level]);
            DFS(level + 1, scoreSum, timeSum);
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        scoreArr = new int[n];
        timeArr = new int[n];
        for (int i = 0; i < n; i++) {
            scoreArr[i] = kb.nextInt();
            timeArr[i] = kb.nextInt();
        }

        DFS(0, 0, 0);
        System.out.println(answer);

    }
}
