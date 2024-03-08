package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 친구인가_Union_Find {
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

    // friendA와 friendB는 친구임을 알고 같은 집합으로 만들어주기위한 함수
    static void union(int vertexA, int vertexB) {
        // 친구 A의 최상위 부모노드를 찾는다.
        int vertexAParent = find(vertexA);
        // 친구 B의 최상위 부모노드를 찾는다.
        int vertexBParent = find(vertexB);

        // 만약 두 친구의 부모노드가 다르다면, 아직 두 친구는 친구임에도 같은 집합이 아니라는 의미다.
        if (vertexAParent != vertexBParent) {
            if (vertexAParent < vertexBParent) {
                // 둘중 더 작은값을 부모에 노드의 번호로 저장하고 같은 집합으로 만들어준다.
                // 그러니까, 노드번호가 큰 노드를 노드번호가 작은 노드의 자식노드로 연결한다.
                parent[vertexBParent] = vertexAParent;
            } else {
                parent[vertexAParent] = vertexBParent;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 배열의 인덱스 번호는 노드 번호를 의미하며 값은 해당 노드의 부모 노드를 의미한다.
        // 여기서 부모노드의 번호는 집합의 번호를 의미하기도 한다.
        parent = new int[n + 1];

        // 배열의 초기값을 인덱스 번호와 동일하게 초기화한다.
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 입력값을 바탕으로 두 입력값이 같은 집합에 속하도록 union 메서드 호출
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int friendA = Integer.parseInt(st.nextToken());
            int friendB = Integer.parseInt(st.nextToken());
            union(friendA, friendB);
        }

        st = new StringTokenizer(br.readLine());
        int findA = Integer.parseInt(st.nextToken());
        int findB = Integer.parseInt(st.nextToken());

        // 만약 문제에서 찾는 두 사람의 집합이 같다면
        if (find(findA) == find(findB)) {
            // 둘은 친구이다
            System.out.println("YES");
            // 그렇지 않다면,
        } else {
            // 둘은 친구가 아니다
            System.out.println("NO");
        }

    }
}
