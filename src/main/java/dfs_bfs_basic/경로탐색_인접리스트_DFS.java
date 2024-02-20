package dfs_bfs_basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 경로탐색_인접리스트_DFS {

    static int n, m;
    static boolean[] visited;
    static int answer = 0;
    // 인접 행렬이 아닌 인접 리스트를 구현하기위해 ArrayList 생성
    static ArrayList<ArrayList<Integer>> graph;

    static void DFS(int curV) {
        // 만약 방문한 노드가 목표노드 n 노드라면
        if (curV == n) {
            // 1번 노드에서 n번 정점으로 가는 경로이므로
            // answer 값 1증가.
            answer++;
        } else {
            // 현재 노드와 연결되어있는 다른 노드와의 간선 정보가 저장되어있는 graph에서
            // 현재 노드와 연결된 다른 노드를 하나씩 꺼내어 탐색
            // 꺼내진 노드는 현재 노드에서 방문할 수 있는 노드라는 의미다.
            for (int nextV : graph.get(curV)) {
                // 만약 다음에 방문할 도느가 아직 방문하지 않은 노드라면,
                if (!visited[nextV]) {
                    // nextV 노드를 방문할것이므로 표시
                    visited[nextV] = true;
                    // 해당 노드 탐색 시작
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
        visited = new boolean[n + 1];
        graph = new ArrayList<>();
        // 노드의 갯수만큼 graph 에다가 인덱스를 정점으로 가정하고
        // 해당 정점과 연결되어있는 정점들의 번호를 해당 인덱스에 저장하기위해
        // n+1 개의 ArrayList를 생성하고 graph에 저장
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // graph 인덱스를 정점으로 가정하고
        // 해당 정점과 연결되어있는 정점들의 번호를 해당 인덱스의 ArrayList에 저장
        // graph 리스트의 a번 인덱스에 b번 노드 번호를 저장한다.
        // 이렇게 하면 a번 정점과 연결된 노드들의 정보가 graph의 a 번 인덱스에
        // ArrayList 형태로 저장된 인접 리스트가 완성된다.
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }

        // 1번 노드부터 탐색을 시작함으로 1번 노드는 방문했다는것을 기록
        visited[1] = true;

        DFS(1);
        // 인접행렬을 활용할 경우 그래프의 정점의 갯수가 작으면 상관 없지만
        // 예를들어 그래프의 노드의 갯수가 커지면 인접 행렬을 표현하는 배열의 크기가 커진다.
        // 그렇다면 해당 노드와 연결된 노드를 탐색하기 위해서는 인접행렬을 탐색해야 하는데
        // 인접행렬을 탐색하는 속도가 느려지게 된다.
        // 그래서 인접 행렬보다는 인접 리스트를 활용하여 노드들 간의 간선 정보를 저장하는것이 좋다.
    }
}
