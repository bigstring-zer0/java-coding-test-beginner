package dfs_bfs_활용;

import java.io.IOException;
import java.util.Scanner;

public class 조합_구하기 {

    static int n, m;
    static int[] answer;

    // level은 트리의 레벨을 의미하기도 하지만 조합을 구성할때 answer의 인덱스를 의미하기도 한다.
    static void DFS(int level, int start) {
        // 만약 level과 m이 같다면,
        if (level == m) {
            // 문제에서 요구하는 조합 하나를 구성했다는 의미미르
            // 문제에서 요구하는 형식대로 출력
            for (int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println();
            // 그게 아니라면 하나의 조합을 구성하지 못했다는 의미다.
        } else {
            // 루플를 활용하며 start부터 n까지 반복한다.
            // 탐색을 진행할때 함수를 호출할때마다 start 값을 현재 i 값에서 1 더한 값을 매개변수로
            // 넘겨주기 때문에, 트리의 레벨이 증가할 수록 루프를 반복하는 횟수가 1씩 감소하기 때문에,
            // 트리의 레벨이 증가할 떄 마다 자식노드의 갯수가 1씩 감소한
            // 노드의 갯수가 생성된다.
            for (int i = start; i <= n; i++) {
                // 해당 level의 인덱스에 i값을 기록한다.
                answer[level] = i;
                // 새로운 탐색을 진행하기 위하여 함수를 호출할때, 현재 level 값에서 1 더한 값과,
                // start 값에 현재 i 값에서 1 더한 값을 매개변수로 넘겨준다.
                DFS(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        answer = new int[m];
        DFS(0, 1);

    }
}
