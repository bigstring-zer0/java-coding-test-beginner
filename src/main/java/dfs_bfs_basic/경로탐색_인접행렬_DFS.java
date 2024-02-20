package dfs_bfs_basic;

import java.io.IOException;
import java.util.Scanner;

public class 경로탐색_인접행렬_DFS {

    static int n, m;
    static boolean[] visited;
    static int answer = 0;
    static int[][] graph;

    static void DFS(int curV) {
        // 만약 현재 방문한 노드가 목표노드 n이라면,
        if (curV == n) {
            // 1번 노드에서 n번 정점으로 가는 경로이므로
            // answer 값 1증가.
            answer++;
        } else {
            // 현재 노드에서 방문할 수 있는 노드는 1 부터 n까지의 노드이기 때문에
            // 1부터 n까지 루프 실행
            for (int nextV = 1; nextV <= n; nextV++) {
                // 만약 인접 행렬에서 해당 노드에서 다음에 방문할 노드를 인덱싱해서 저장된 값이 1이라면
                // nextV 노드에 방문할 수 있다는 의미이다.
                // 그리고 다음에 방문할 노드 nextV가 아직 방문한 노드가 아니라면,
                if (graph[curV][nextV] == 1 && !visited[nextV]) {
                    // 다음에 방문할 노드 nextV 노드를 방문했다고 표시
                    visited[nextV] = true;
                    // nextV 노드 탐색시작
                    DFS(nextV);
                    // nextV 노드에 대한 탐색이 끝나면 다른 경로를 찾아야 하므로
                    // nextV 노드를 다시 방문해야 하는 경우가 있다.
                    // 그래서 nextV 노드를 방문했다는 표시를 방문하지 않았다는 표시로 바꾼다.
                    visited[nextV] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        // 노드들에 대한 간선 정보를 저장하기 위한 인접행렬 생성.
        graph = new int[n + 1][n + 1];
        // 해당 노드를 방문했는지를 기록하기 위한 배열 생성
        visited = new boolean[n + 1];

        // 인접 행렬을 만들기 위해 루프 실행
        // 예를들어 graph[1][2] = 1의 의미는 1번 노드에서 2번노드가 간선으로 연결되어
        // 방문할 수 있다는 의미다.
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }

        // 1번 노드부터 시작하므로 방문했다고 표시
        visited[1] = true;

        // 탐색 시작
        DFS(1);
    }
}
