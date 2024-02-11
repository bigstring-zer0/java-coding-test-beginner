package array;

import java.io.IOException;

public class 봉우리 {
    public static int solution(int n, int[][] map) {
        int answer = 0;
        // 상, 우, 하, 좌 시계방향 순서대로 주어진 주어진 정해진 위치에서 map을 탐색한다.
        // 예를 들어 (1,1) 위치에 인접한 윗방향을 탐색하려면 x좌표(row) -1을 더해주고
        // col의 위치는 변동이 없기 때문에,y좌표(col)에다가 0을 더해준다.
        // 이렇게 되면 (0,1)의 원소에 접근하는 것이므로 (1,1)의 원소에 인접한 윗방향을 탐색하는것과 같다
        // 따라서 dx, dy의 0번째 인덱스는 상, 1번째 인덱스는 우, 2번쨰 인덱스는 하, 3번째 인덱스는 좌,
        // 시계방향으로 탐색을 진행하게 된다.
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        // 이중 루프를 돌며 (i, j) 위치의 원소에서 차례대로 dx, dy 값을 더해주며 탐색하게될 새로운
        // 위치의 좌표를 저장하게될 nx(new x), ny(new y) 좌표
        int nx, ny;
        // 루프를 돌며 접근한 (i, j)의 원소가 주어진 조건을 만족하는 봉우리인지를 판별하기위한 isPeak
        boolean isPeak;
        // 이중 루프를 활용하여 주어진 map의 원소 위치 (i, j)를 정한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 원소 (i,j)를 정하고 상,우,하,좌 방향으로 탐색을 시작하기 전에
                // (i,j) 위치의 원소는 봉우리라고 가정한다.
                isPeak = true;
                // 상, 우, 하, 좌 시계방향 순서대로 탐색 시작
                for (int k = 0; k < 4; k++) {
                    // (i, j)에 위치해 있는 원소를 기준으로 시계방향 순서대로 탐색할때
                    // i에서 탐색 방향을 더한 새로운 X 좌표
                    nx = i + dx[k];
                    // (i, j)에 위치해 있는 원소를 기준으로 시계방향 순서대로 탐색할때 새로운 y 좌표
                    // j에서 탐색 방향을 더한 새로운 y 좌표
                    ny = j + dy[k];
                    // 새로 탐색한 위치가 주어진 map의 범위 그러니까 인덱스를 벗어난 위치라면
                    if (0 > nx || 0 > ny || n <= nx || n <= ny) {
                        // 바로 다음 위치 탐색 시작
                        continue;
                    }
                    // 만약 (i,j)의 위치에서 시계방향으로 탐색한 위치의 원소들중 (i,j) 위치의 값보다
                    // 크거나 같은 값이 있다면
                    if (map[i][j] <= map[nx][ny]){
                        // 해당 (i,j) 위치의 원소는 봉우리가 아니므로 isPeak를 false로 초기화
                        isPeak = false;
                        // 이미(i,j)위치의 원소는 봉우리의 기준을 만족할 수 없는 인접 원소를 발견했으므로,
                        // 더이상 인접 원소를 탐색할 필요가 없다.
                        // 상,우,하,좌 4방향 탐색 종료
                        break;
                    }
                }
                // 상, 우, 하, 좌 시계방향으로의 탐색이 종료되었을때
                // isPeak의 값이 true 라면
                if (isPeak) {
                    // 해당 (i,j)의 원소는 봉우리라는 의미이므로 봉우리의 갯수가 저장될 answer 값을 1 증가.
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution(5, new int[][]{
                {5, 3, 7, 2, 3},
                {3, 7, 1, 6, 1},
                {7, 2, 5, 3, 4},
                {4, 3, 6, 4, 1},
                {8, 7, 3, 5, 2},
        }));
    }
}
