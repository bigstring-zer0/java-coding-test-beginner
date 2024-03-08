package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 원더랜드_프림_알고리즘 {

    static class Edge {
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public int getWeight() {
            return weight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n + 1];
        List<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int vertexA, vertexB, weight;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            vertexA = Integer.parseInt(st.nextToken());
            vertexB = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            // 무방향 그래프이기때문에 양방향으로 이동할 수 있다.
            // 그래서 입력값을 바탕으로 무방향 그래프를 저장한다.
            graph.get(vertexA).add(new Edge(vertexB, weight));
            graph.get(vertexB).add(new Edge(vertexA, weight));
        }

        // 간선의 가중치가 작은것부터 꺼내서 탐색을 진행해야하므로 간선의 가중치 값을 기준으로 정렬하여 꺼낸다.
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        // 1번 노드부터 탐색해야하므로 1번노드와 가중치값 0을 추가한다.
        // -> 노드 1에서 노드 1로 가는 가중치값은 0이다.
        queue.offer(new Edge(1, 0));
        int answer = 0;

        // 탐색시작
        while (!queue.isEmpty()) {
            // 바로 이전에 탐색한 노드와 인접한 노드들 중에서 가중치가 제일 작은 간선의 정보를 꺼낸다
            Edge curEdge = queue.poll();
            // 현재 탐색하려는 노드의 번호
            int curVertex = curEdge.getVertex();
            // 만약 현재 탐색하려는 노드가 이전에 이미 방문했던 노드라면,
            if (visited[curVertex]) {
                // 해당 노드를 탐색하지 않고 바로 이전에 탐색한 노드와 인접한 다른 노드를 탐색하기위해
                // 다음 루프 실행
                continue;
            }
            // 아직 방문하지 않은 노드라면 방문했다고 표시
            visited[curVertex] = true;

            // 해당 노드를 방문했으므로 해당노드를 방문하기위한 가중치 값을 더한다.
            answer += curEdge.getWeight();
            // 현재 방문한 노드와 인접한 노드를 방문하기위해 인접 리스트를 활용하여
            // 현재 노드와 인접한 탐색 가능한 노드가 있는지 탐색
            for (Edge nextEdge : graph.get(curVertex)) {
                // 현재 탐색중인 노드와 인접한 노드를 큐에 추가
                queue.offer(nextEdge);
            }
        }
        System.out.println(answer);
    }
}
