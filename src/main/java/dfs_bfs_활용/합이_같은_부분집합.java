package dfs_bfs_활용;

import java.io.IOException;

public class 합이_같은_부분집합 {

    static int n, totalSum;
    static int[] arr;

    // level을 arr의 인덱스로 활용
    static void DFS(int level, int sum) {
        // 만약 sum이 totalSum의 절반값 보다 크다면,
        if (sum > totalSum / 2) {
            // sum이 totalSum의 절반값을 넘어버린 시점부터 남아있는 원소들을 집합에 포함시켜봤자
            // 남은 원소들로 서로 합이 같은 두개의 부분 집합을 구성할 수 없다.
            // 그래서 바로 해당 함수를 종료한다.
            return;
        }
        // 만약 부분 집합 구성을 완료 했다면,
        if (level == n) {
            // 완성된 부분 집합의 합을 원소들 전체의 합에서 뺀 값이 완성된 부분집합의 합고 같다면,
            if (totalSum - sum == sum) {
                // 부분 집합으로 구성하지 않은 원소들로 합을 구하면 완성된 부분집합의 합과 동일한
                // 부분집합을 구성할 수 있기 때문에 YES를 출력.
                System.out.println("YES");
                // 바로 프로그램 종료
                System.exit(0);
            }
            // 아직 부분 집합을 구성하지 못했다면,
        } else {
            // 해당 level을 인덱스로 하는 위치의 원소를 부분집합으로 포함하는 경우의 노드를 생성
            DFS(level + 1, sum + arr[level]);
            // 해당 인덱스의 원소를 부분집합으로 포함하지 않은 경우의 노드를 생성
            DFS(level + 1, sum);

        }
    }

    public static void main(String[] args) throws IOException {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        DFS(0, 0);
        System.out.println("NO");

    }
}
