package dfs_bfs_활용;

import java.io.IOException;
import java.util.Scanner;

public class 바둑이_승차 {

    static int c, n;
    static int[] arr;
    static int answer = Integer.MIN_VALUE;

    static void DFS(int level, int sum) {
        // 만약 sum의 값이 최대 승차 무게 값인 c를 넘는다면,
        if (sum > c) {
            // 부분집합을 계속 구성해나가는것이 의미가 없으므로 함수 바로 종료.
            return;
        }
        // 만약 부분집합 구성을 완료하고 sum의 값이 최대 승차 무게값은 c보다 같거나 작다면,
        if (level == n && sum <= c) {
            // 문제에서 요구하는 조건을 충족하는 부분집합을 구성한것이므로
            // 문제에서 요구하는 조건을 만족하는 최대값을 계산
            answer = Math.max(answer, sum);
            return;
            // 만약 아직 부분 집합 구성을 완료하지 않았다면,
        } else {
            // 헤딩 level을 인덱스로 하는 원소를 포함하는 부분집합을 구성하기위한 함수 호출
            DFS(level + 1, sum + arr[level]);
            // 해당 level을 인덱스로 하는 원소를 포함하지 않는 부분집합을 구성하기 위한 함수 호출
            DFS(level + 1, sum);
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        DFS(0, 0);
        System.out.println(answer);

    }

}
