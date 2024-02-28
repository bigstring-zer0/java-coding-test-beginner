package dfs_bfs_활용;

import java.io.IOException;
import java.util.Scanner;

public class 섬나라_아일랜드_DFS {

    static int n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;

    static void DFS(int x, int y) {
        int nx, ny;
        // 8방향으로 탐색
        for (int i = 0; i < 8; i++) {
            // 새로운 위치를 탐색할 new x 좌표값
            nx = x + dx[i];
            // 새로운 위치를 탐색할 new y 좌표값
            ny = y + dy[i];
            // 만약 nx, ny가 주어진 map의 범위에서 벗어나지 않고 탐색하려는 위치가 바다가 아니라면, 해당 위치는 탐색 가능한 위치이므로
            if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] != 0) {
                // 새롭게 탐색하려는 위치의 재탐색을 방지하기 위해 0으로 초기화
                map[nx][ny] = 0;
                // 새로운 위치 탐색 시작
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = kb.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 만약 해당 위치의 원소가 1이라면, 땅을 발견했다는 의미이므로,
                if (map[i][j] == 1) {

                    // 해당 위치의 재탐색을 방지하기 위해서 0으로 초기화.
                    map[i][j] = 0;
                    // 해당 위치부터 탐색 시작
                    DFS(i, j);
                    // answer 값 1 증가
                    answer++;
                }
            }
        }
        System.out.println(answer);



    }
}
