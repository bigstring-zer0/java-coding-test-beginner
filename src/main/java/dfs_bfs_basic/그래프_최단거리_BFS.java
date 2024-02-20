package dfs_bfs_basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그래프_최단거리_BFS {

    static int n, m;
    // 해당 노드가 방문한 노드인지를 기록하기 위한 배열 생성
    static boolean[] visited;
    // 시작노드부터 각 노드까지의 거리 값을 저장하기 위한 배열 생성
    static int[] distance;
    // 각 노드들 사이의 간선 정보를 저장하기 위한 인접 리스트 생성
    static ArrayList<ArrayList<Integer>> graph;

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        // 1번 노드에서 출발하기 때문에 1번 노드를 먼저 큐에 저장
        queue.offer(v);

        // 탐색 시작
        while (!queue.isEmpty()) {
            // 큐의 가장 앞에 위치한 노드를 꺼낸다.
            int curV = queue.poll();
            // 현재 노드와 연결되어있는 간선 정보가 저장되어있는 graph에서
            // 현재 노드와 연결된 다른 노드를 하나씩 꺼내어 탐색
            // 꺼내진 노드는 현재 노드에서 방문할 수 있는 노드라는 의미다.
            for (int nextV : graph.get(curV)) {
                // 만약 다음에 방문할 노드가 방문하지 않은 노드라면,
                if (!visited[nextV]) {
                    // 해당 노드를 방문할 것이므로 방문했다는 표시
                    visited[nextV] = true;
                    // 현재 노드와 다음에 방문할 노드의 거리는 간선하나 차이이므로
                    // 시작 노드부터 현재 노드의 거리가 저장되어있는 distance[curV]에
                    // 1을 더한 값을 시작 노드부터 다음에 방문할 노드의 거리값이 저장되어 있는
                    // distance[nextV]에 저장
                    distance[nextV] = distance[curV] + 1;
                    // 다음에 방문할 노드를 탐색하기 위해 큐에 다음에 방문할 노드를 저장.
                    queue.offer(nextV);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        visited = new boolean[n + 1];
        distance = new int[n + 1];

        graph = new ArrayList<>();
        // 노드의 갯수만큼 graph 에다가 인덱스를 정점 번호로 가정하고
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

        // 1번노드에서 탐색을 시작하므로 방문했다고 표시
        visited[1] = true;
        // 인접 리스트를 기반으로 탐색 시작.
        BFS(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " " + distance[i]);
        }
    }
}
