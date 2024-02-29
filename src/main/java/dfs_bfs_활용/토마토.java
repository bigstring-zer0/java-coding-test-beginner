package dfs_bfs_활용;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] tomatoes;
    static int[][] distance;
    static Queue<Point> queue = new LinkedList<>();


    static void BFS() {

        // 큐가 완전히 빌때까지 탐색 시작
        while (!queue.isEmpty()) {
            // 큐의 제일 앞에 위치한 원소를 꺼낸다.
            Point cur = queue.poll();
            int nx, ny;
            // 4방향으로 탐색시작
            for (int i = 0; i < 4; i++) {
                // 새로운 위치를 탐색할 new x 좌표값
                nx = cur.x + dx[ i];
                // 새로운 위치를 탐색할 new y 좌표
                ny = cur.y + dy[i];
                // 만약 nx, ny가 주어진 토마토 박스의 범위에서 벗어나지 않고,
                // 탐색하려는 위치에 있는 토마토가 아직 익지않은 토마토를 의미하는 0이라면
                // 해당 위치는 탐색 가능한 위치이므로,
                if (0 <= nx && nx < n && 0 <= ny && ny < m && tomatoes[nx][ny] == 0) {
                    // 해당 경로에서 해당 위치의 토마토를 재탐색하는 것을 방지하고,
                    // 해당 위치는 익은 토마토라는 의미로 1 표시.
                    tomatoes[nx][ny] = 1;
                    // 처음 익어있던 토마토의 위치부터 현재 위치의 토마토의 거리값에서
                    // 1 더한 값을 새롭게 탐색할 위치에 거리값으로 기록.
                    distance[nx][ny] = distance[cur.x][cur.y] + 1;
                    // 새로운 위치의 토마토 탐색 시작
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();
        n = kb.nextInt();
        tomatoes = new int[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = kb.nextInt();
                // 만약 토마토 박스의 원소값이 1이라면 익은 토마토라는 의미다.
                if (tomatoes[i][j] == 1) {
                    // 익은 토마토들을 기점으로 탐색을 시작할 것이므로 큐에 저장.
                    queue.offer(new Point(i, j));
                }
            }
        }
        // 탐색시작
        BFS();

        // 탐색이 완료됬는데도 아직 토마토박스에 덜익은 토마토를 의미하는 0이 발견되는걸 생각하기 위해서 선언
        boolean findUnripenedTomato = false;

        int answer = Integer.MIN_VALUE;
        // 토마토 박스를 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 만약 탐색이 완료 됬음에도 아직 토마토 박스에 덜익은 토마토인 0이 남아있다면,
                if (tomatoes[i][j] == 0){
                    // 덜익은 토마토를 발견했다는 의미로 true로 초기화.
                    findUnripenedTomato = true;
                    break;
                }
            }
            // 덜익은 토마토를 하나라도 발견했다면 루프 종료.
            if (findUnripenedTomato) break;
        }

        // 만약 덜익은 토마토를 발견했다면,
        if (findUnripenedTomato) {
            // -1을 출력
            System.out.println(-1);

            // 만약 덜익은 토마토를 발견하지 못했다면,
        } else {
            // 토마토가 정상적으로 익었거나, 아니면 처음부터 모든 토마토들이 익어있었다는 의미다.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 만약에 모든 토마토들이 이미 익어있었다면, distance는 모든 값이 0이였을 것이다.
                    // 그럼 distance의 모든 원소값들과 answer에 저장되어있는 값을 비교해도
                    // 우리가 시작부터 모든 토마토들이 익어있을때의 경우의 정답인
                    // answer에 0이 저장될것이다.

                    // 그게아니라면, 토마토가 정상적으로 익은 경우이므로 answer와 값을 비교하면서,
                    // distance에 저장된 최대값을 answer에 저장한다.
                    answer = Math.max(answer, distance[i][j]);
                }
            }
            // 정답 출력
            System.out.println(answer);
        }
    }
}
