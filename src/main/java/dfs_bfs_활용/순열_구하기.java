package dfs_bfs_활용;

import java.io.IOException;
import java.util.Scanner;

public class 순열_구하기 {
    static int n, m;
    static int[] arr, answer;
    static boolean[] visited;

    // level은 탐색하는 트리의 레벨을 의미하기도 하지만
    // answer에 기록하기 위한 인덱스를 의미하기도 하다.
    static void DFS(int level) {
        // 만약 level이 m 과 같다면,
        if (level == m) {
            // 문제에서 요구하는 순열을 완성했다는 의미이므로
            // 문제에서 요구하는 출력 형식에 맞게 출력
            for (int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println();


            // 만약 아직 순열을 구성하지 못했다면,
        } else {
            // n개 만큼 트리의 가지를 뻗으면서 노드를 생성하여
            // 문제에서 요구하는 순열을 완성한다.
            for (int i = 0; i < n; i++) {
                // 만약 arr[i]번째 원소가 순열에 포함되지 않았다면,
                if (!visited[i]) {
                    // 해당 원소를 순열에 포함시킬 것이므로 포함시켯다고 기록
                    visited[i] = true;
                    // level은 트리의 레벨이기도 하면서 answer에 기록하기위한 익덱스를 의미하기 때문에
                    // answer의 level인덱스에 arr[i] 값을 기록
                    answer[level] = arr[i];
                    // arr 원소 하나를 순열로 구성했으므로 다음 원소를 순열로 기록하기 위해서
                    // 다른 노드를 생성하여 트리를 탐색
                    DFS(level + 1);
                    // 해당 원소의 탐색이 끝나고 부모 노드로 되돌아갈때,
                    // 다른 순열을 구성할때 해당 원소를 다시 사용하는 경우가 있을수 있으므로,
                    // 해당 원소를 방문하지 않은 상태라고 기록한다.
                    visited[i] = false;
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        arr = new int[n];
        visited = new boolean[n];
        answer = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        DFS(0);
    }
}
