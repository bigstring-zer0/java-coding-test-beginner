package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다익스트라_알고리즘 {
    static List<ArrayList<Edge>> graph;
    static int[] distance;

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

    static void solution() {
        // 1번 노드부터 n번 노드까지 갈때 최소 가중치 값부터 꺼내어 탐색하기 위한 우선순위 큐 생성
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        // 1번 노드 부터 시작하므로 1번 노드와 1번노드에서 1번노드로 가는 가중치 값은 0이므로 해당 정보를 저장
        queue.offer(new Edge(1, 0));
        // 1번노드에서 1번노드로 가는 가중치는 0이므로 해당 정보를 저장
        distance[1] = 0;

        // 탐색시작
        while (!queue.isEmpty()) {
            // 1번노드에서 n번 노드로 가는 최소 가중치 값을 가진 노드 정보부터 꺼낸다.
            Edge cur = queue.poll();
            // 현재 노드의 번호
            int curVertex = cur.getVertex();
            // 1번 노드에서 현재 노드까지 가는 가중치값
            int curWeight = cur.getWeight();
            // 만약 1번 노드에서 현재 노드까지 가는 가중치 값이 이전에 탐색을 통하여 기록된 가중치 값보다 크다면,
            // 최소 가중치값을 계산하는 문제이므로 현재 노드 정보로 탐색을 진행할 필요가없다.
            if (distance[curVertex] < curWeight) {
                // 다음 루프를 실행
                continue;
            }
            // 현재 노드와 연결된 노드의 정보를 탐색
            for (Edge nextEdge : graph.get(curVertex)) {
                // 만약 현재노드와 연결되어있는 새롭게 탐색을 진행할 노드의 1번 노드부터 새롭게 진행할 노드까지의
                // 이전의 탐색을 통하여 기록되어있는 가중치 값이 현재 노드에서 새롭게 탐색할 노드까지의 가중치값과
                // 1번 노드부터 현재 노드까지의 가는 가중치 값을 더한 값보다 크다면,
                if (distance[nextEdge.getVertex()] > nextEdge.getWeight() + curWeight) {
                    // 1번 노드부터 새롭게 탐색할 노드로 가는 더 작은 가중치 값을 찾은것 이므로
                    // 1번 노드부터 새롭게 탐색할 노드로가는 가중치 값을 해당 값으로 초기화
                    distance[nextEdge.getVertex()] = nextEdge.getWeight() + curWeight;
                    // 새롭게 탐색할 노드와 연결된 노드를 탐색하기위해 새롭게 탐색할 노드의 번호와
                    // 1번 노드부터 새롭게 탐색하는 노드로 가는 가중치 값을 큐에 추가
                    queue.offer(new Edge(nextEdge.getVertex(), nextEdge.getWeight() + curWeight));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        graph = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 1번 노드부터 N번 노드까지 가는 최소비용을 기록하기위한 배열 생성
        distance = new int[n + 1];
        // 최소비용을 기록해야하므로 배열의 모든 원소들을 최대 값으로 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 노드는 1번 부터 N번 까지의 인접리스트를 생성하기위한 graph 초기화.
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int from, to, weight;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 출발 노드번호를 입력으로 받는 from
            from = Integer.parseInt(st.nextToken());
            // 도착 노드 번호를 입력으로 받는 to
            to = Integer.parseInt(st.nextToken());
            // from 노드에서 to 노드로 갈때 가중치값을 입력으로 받는 weight
            weight = Integer.parseInt(st.nextToken());
            // from노드에서 to 노드로 갈때 가중치값에 대한 정보를 인접리스트에 저장
            graph.get(from).add(new Edge(to, weight));
        }

        solution();

        // 문제에서 요구하는 형식에 맞게 정답 출력
        for (int i = 2; i <= n; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + distance[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }

    }
}
