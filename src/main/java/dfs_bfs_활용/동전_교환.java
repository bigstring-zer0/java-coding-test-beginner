package dfs_bfs_활용;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전_교환 {
    static int n, m;
    static Integer[] coin;
    static int answer = Integer.MAX_VALUE;

    // level은 동전의 갯수
    static void DFS(int level, int sum) {
        // 만약 m보다 만들어진 동전 조합의 합 sum이 크다면
        if (sum > m) {
            // 해당 동전 조합은 더 조합할 필요가 없으므로 바로 함수 종료.
            return;
        }
        // 만약 동전의 갯수가 문제에서 요구하는 최소 동전의 갯수가
        // 이미 저장되어있는 answer 보다 크거나 같다면,
        if (level >= answer) {
            // 이미 문제에서 요구하는 조건을 충족한 동전의 최소갯수를 계산했으므로,
            // 더 탐색을할 필요가 없다.
            // 바로 함수 종료
            return;
        }
        // 만약 만들어진 동전 조합의 합 sum이 m과 같다면,
        if (sum == m) {
            // 동전의 최저 갯수 계산.
            answer = Math.min(answer, level);
            return;
            // 만약 아직 문제에서 요구하는 동전의 조합을 만들지 못했다면,
        } else {
            // 동전의 종류 n 만큼 루프를 실행하며 깊이 우선 탐색 방식으로
            // 노드를 생성하며 트리의 가지를 뻗으면서 탐색.
            for (int i = 0; i < n; i++) {
                DFS(level + 1, sum + coin[i]);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        coin = new Integer[n];
        for (int i = 0; i < n; i++) {
            coin[i] = kb.nextInt();
        }

        // 만약 m = 15라면,
        // 오름차순으로 정렬된 동전들을 탐색을 진행한다면, 1, 2, 5인 경우에는
        // 탐색이 시작되면, 1부터 탐색을 시작할 것이고,
        // 계속 1이 sum에 더해지면서 m값과 같아지려먼 트리의 레벨이 15레벨이 되야된다.
        // 함수 호출을 최소 15번 해야한다는 의미다.
        // 만약 입력받은 동전의 종류들을 5, 2, 1 이렇게 내림차순으로 정렬하고 탐색을 진행한다면,
        // 탐색이 시작되면 5부터 탐색을 시작하게 될것이다.
        // 탐색이 시작되면 5가 m값과 같아질때 까지, sum에 더해지게 되고 m값과 같아지려면 트리의 레빌이 3 레벨이 되면된다.
        // 함수 호출을 3번만 하면 된다는 의미다.
        // 그래서 큰값부터 탐색을 진행하도록 입력받은 동전의 종류를 내림차순으로 진행하고 탐색을 진행한다.
        Arrays.sort(coin, Collections.reverseOrder());
        m = kb.nextInt();
        DFS(0, 0);
        System.out.println(answer);
    }
}
