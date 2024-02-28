package dfs_bfs_활용;

import java.io.IOException;
import java.util.Scanner;

public class 미로_탐색_DFS {

    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    static void DFS(int x, int y) {
        // (x, y) 좌표가 도착점의 좌표인 (6, 6)이라면
        if (x == 6 && y == 6) {
            // 출발점에서 목적지에 도착할수 있는 경우의수를 한개 찾은것이므로 answer값 1 증가.
            answer++;
            // 그게 아니라면 아직 목적지를 찾지 못한것 이므로 목적지 까지 도착하는 경로 탐색
        } else {
            int nx, ny;
            // 상, 우, 좌, 하 시계방향 순서대로 탐색을 시작
            for (int i = 0; i < 4; i++) {
                // 새롭게 탐색할 new x 좌표
                nx = x + dx[i];
                // 새롭게 탐색할 new y 좌표
                ny = y + dy[i];
                // 만약 nx, ny가 주어진 map의 범위에서 벗어나지 않고 탐색하려는 위치가 벽이 아니라면 해당 위치는 탐색 가능한 위치이므로
                if (0 <= nx && nx < 7 && 0 <= ny && ny < 7 && map[nx][ny] != 1) {
                    // 해당 경로에서 해당 위치를 재탐색하는 것을 방지하고, 해당 위치는 이미 탐색했다는 의미의 1로 표시.
                    map[nx][ny] = 1;
                    // 해당 위치로 탐색 시작
                    DFS(nx, ny);
                    // 해당 탐색으로 인한 도착지까지의 경로의 가짓수 이외에도 다른 경로를 탐색하면서
                    // 해당 위치를 다시 탐색할 수도 있으므로 해당 위치에 대한 탐색이 종료되고 해당 위치를 다시 방문할수 있도록
                    // 아직 방문하지 않은 위치라는 의미와 벽이아닌 탐색 가능한 경로라는 의미로 0으로 표시
                    map[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        map = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = kb.nextInt();
            }
        }

        // 출발점에서 탐색을 시작하므로 출발점은 이미 탐색했다는 의미와 재탐색을 방지하기 위한 벽이라는 의미의 1표시.
        map[0][0] = 1;
        // 탐색 시작
        DFS(0, 0);
        System.out.print(answer);

    }
}
