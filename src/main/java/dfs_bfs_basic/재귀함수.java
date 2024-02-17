package dfs_bfs_basic;

public class 재귀함수 {

    public static void DFS(int n){
        if (n == 0) {
            return;
        } else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void solution(int n){
        DFS(n);
    }

    public static void main(String[] args){
        solution(3);
    }
}

