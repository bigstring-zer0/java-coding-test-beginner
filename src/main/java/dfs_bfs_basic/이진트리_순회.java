package dfs_bfs_basic;

import java.io.IOException;

public class 이진트리_순회 {
    public static void DFS(int num) {
        if (num > 7) {
            return;
        } else {
            // 전위 순회
            System.out.print(num + " ");
            DFS((num * 2));
            DFS((num * 2) + 1);

            // 중위 순회
            DFS((num * 2));
            System.out.print(num + " ");
            DFS((num * 2) + 1);

            // 후위 순회
            DFS((num * 2));
            DFS((num * 2) + 1);
            System.out.print(num + " ");
        }

    }

    public static void solution(int n) {
        DFS(n);
    }

    public static void main(String[] args) throws IOException {
        solution(1);
    }
}
