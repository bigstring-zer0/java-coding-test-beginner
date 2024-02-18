package dfs_bfs_basic;

import java.io.IOException;

public class 부분집합_구하기 {

    static boolean[] check;
    static int n;
    // level은 부분 집합을 구성할 원소다.
    public static void DFS(int level) {
        // 먄약 level 이 n보다 크다면, 부분 집합을 구성한 원소의 범위를 넘기 때문에, 이미 구성한 부분 집합을 출력
        if (level > n) {
            // for 루프를 활용하여 1부터 n까지의 원소를 check에 true고 저장되어있는 원소만으로 부분 집합을 구성한다.
            for (int i = 1; i <= n; i++) {
                // 만약 해당 원소를 사용할 것이라고 저장해뒀다면,
                if (check[i]) {
                    // 해당 원소 출력
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;

        } else {
            // 해당 원소를 포함한 부분집합을 구성할 것이라는 의미에서 check[level]에 true를 저장
            check[level] = true;
            // level+1 원소에 대한 부분 집합을 구성하기 위해서 DFS() 호출
            DFS(level + 1);
            // 해당 원소를 포함하지 않은 부분 집합을 구성할 것이라는 의미에서 check[level]에 false를 저장.
            check[level] = false;
            // level+1 원소에 대한 부분 집합을 구성하기 위해서 DFS() 호출
            DFS(level + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        // 해당 문제는 n이 주어지면 1부터 n까지의 원소를 갖는 집합의 부분 집합을 모두 출력하는 문제다.
        n = 3;
        check = new boolean[n + 1];
        DFS(1);
    }
}
