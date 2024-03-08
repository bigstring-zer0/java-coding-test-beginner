package dfs_bfs_basic;

import java.io.IOException;

public class 이진수_출력 {
    public static void DFS(int num) {
        if (num == 0) {
            return;
        } else {
            DFS(num / 2);
            System.out.print(num % 2);
        }
    }
    public static void solution(int n) {
        DFS(11);
    }
    public static void main(String[] args) throws IOException {
        solution(11);
    }
}
