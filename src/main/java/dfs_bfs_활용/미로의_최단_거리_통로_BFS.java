package dfs_bfs_활용;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로의_최단_거리_통로_BFS {

    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] distance;

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        // 큐에 출발 위치의 좌표값 추가.
        queue.offer(new int[]{x, y});
        // 출발 위치는 방문했다고 표시.
        map[x][y] = 1;

        // 탐색 시작
        while (!queue.isEmpty()) {
            // 큐의 제일 앞에 위치한 원소를 꺼낸다.
            int[] cur = queue.poll();
            int nx, ny;
            // 4방향으로 탐색 시작.
            for (int i = 0; i < 4; i++) {
                // 새로운 위치를 탐색할 new x 좌표값
                nx = cur[0] + dx[i];
                // 새로운 위치를 탐색할 new y 좌표
                ny = cur[1] + dy[i];
                // 만약 nx, ny가 주어진 map의 범위에서 벗어나지 않고 탐색하려는 위치가 벽이 아니라면 해당 위치는 탐색 가능한 위치이므로
                if (0 <= nx && nx < 7 && 0 <= ny && ny < 7 && map[nx][ny] != 1) {
                    // 해당 경로에서 해당 위치를 재탐색하는 것을 방지하고, 해당 위치는 이미 탐색했다는 의미의 1로 표시.
                    map[nx][ny] = 1;
                    // 새로운 위치 탐색 시작
                    queue.offer(new int[]{nx, ny});
                    // 출발 위치부터 현재 위치까지의 거리값에서 1 더한 값을 새롭게 탐색할 위치에 거리값으로 기록한다.
                    distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        map = new int[7][7];
        distance = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = kb.nextInt();
            }
        }

        // 출발점에서 탐색을 시작하므로 출발점은 이미 탐색했다는 의미와 재탐색을 방지하기 위한 벽이라는 의미의 1표시.
        // 탐색 시작

        BFS(0, 0);
        if (distance[6][6] != 0) {
            System.out.println(distance[6][6]);
        } else {
            System.out.println(-1);
        }
    }
}
