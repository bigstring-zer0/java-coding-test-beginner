package dfs_bfs_활용;

import java.io.IOException;
import java.util.Scanner;

public class 중복_순열_구하기 {

    static int n, m;
    static int[] answer;

    static void DFS(int level) {
        // 만약 level이 m이라면 문제에서 요구하는 수열을 완성했다는 의미이므로,
        if (level == m) {
            // 완성된 수열을 출력
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();

            // 그게아니라, 아직 수열을 완성하지 못했다면,
        } else {
            // 1부터 n만큼 깊이 우선 탐색 방식으로 노드를 생성하며,
            // 트리의 가지를 뻗으면서 문제에서 요구하는 수열을 완성한다.
            for (int i = 1; i <= n; i++) {
                answer[level] = i;
                DFS(level + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        n = 3;
        m = 2;

        answer = new int[m];

        DFS(0);
    }
}
