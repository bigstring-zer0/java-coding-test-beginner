package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 원더랜드_크루스칼_알고리즘 {
    static class Edge {
        int vertexA, vertexB, weight;

        public Edge(int vertexA, int vertexB, int weight) {
            this.vertexA = vertexA;
            this.vertexB = vertexB;
            this.weight = weight;
        }

        public int getVertexA() {
            return vertexA;
        }

        public int getVertexB() {
            return vertexB;
        }

        public int getWeight() {
            return weight;
        }
    }
    static int[] parent;

    // 해당 노드의 부모노드를 찾는 메서드, 그러니까 해당 노드는 어느 집합에 속해있는지를 계산하는 메서드
    static int find(int vertex) {
        // 현재 노드의 번호가 해당 노드가 속해있는 집합의 번호와 같다면
        if (parent[vertex] == vertex) {
            // 자기 자신의 번호를 반환한다.
            return vertex;
            // 그게 아니라면 어떠한 집합에 속해있다는 의미기 때문에, 자신이 속해있는 집합의 번호인
            // 부모노드의 번호를 재귀 호출로 찾아가면서 해당 노드와 연결된 노드들의 집합 번호를
            // 부모노드의 번호로 업데이트 하면서 현재 탐색중인 노드의 번호도 속해있는 집합의 번호로 업데이트 한다.
            // 집합의 번호는 해당 노드가 속해있는 부모노드의 번호와 동일하다.
        } else {
            return parent[vertex] = find(parent[vertex]);
        }
    }


    // 두개의 노드를 연결하기 위한 함수
    static boolean union(int vertexA, int vertexB) {
        // 친구 A의 최상위 부모노드를 찾는다.
        int vertexAParent = find(vertexA);
        // 친구 B의 최상위 부모노드를 찾는다.
        int vertexBParent = find(vertexB);

        // 만약 부모느드이 번호가 같다면 두 노드는 이미 연결되었다는 의미다.
        if (vertexAParent == vertexBParent) {
            // 두개의 노드를 연결하면 해당 트리는 사이클 특성을 가지기 때문에 연결하지 않을것 이므로 false 리턴
            return false;
        }
        // 만약 두 노드의 부모노드가 다르다면, 아직 두 노드는 연결되지 않았다는 의미다.
        else {
            if (vertexAParent < vertexBParent) {
                // 둘중 더 작은값을 부모에 노드의 번호로 저장하고 같은 집합으로 만들어준다.
                // 그러니까, 노드번호가 큰 노드를 노드번호가 작은 노드의 자식노드로 연결한다.
                parent[vertexBParent] = vertexAParent;
            } else {
                parent[vertexAParent] = vertexBParent;
            }
        }
        // 두 노드를 연결하였으므로 true 리턴
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> list = new ArrayList<>();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int vertexA, vertexB, weight;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            vertexA = Integer.parseInt(st.nextToken());
            vertexB = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            list.add(new Edge(vertexA, vertexB, weight));
        }

        list.sort(Comparator.comparing(Edge::getWeight));

        int answer = 0, edgeCnt = 0;
        // 루프를 실행하면서 탐색 시작
        for (Edge edge : list) {
            if (union(edge.getVertexA(), edge.getVertexB())){
                answer += edge.getWeight();
                edgeCnt++;
                if (edgeCnt == n - 1) {
                    break;
                }
            }
        }

        System.out.println(answer);


    }
}
