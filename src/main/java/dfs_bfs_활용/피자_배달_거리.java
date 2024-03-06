package dfs_bfs_활용;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 피자_배달_거리 {
    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, dominoPizzaCnt;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static List<Point> house = new ArrayList<>();
    static List<Point> dominoPizza = new ArrayList<>();
    static int[] combination;
    // level은 트리의 레벨을 의미하기도 하지만 조합을 구성하는 배열의 인덱스이기도 하다.
    static void DFS(int level, int start) {
        // 만약 level과 m이 같다면 하나의 조합을 구성했다는 의미다.
        if (level == m) {
            // 피자집들에 대한 하나의 조합을 구성했을때 각 집의 최소 피자 배달거리를 저장하기 위한 변수 생성
            int distanceSum = 0;
            // 피자배달거리를 계산할 집 선택
            for (Point house : house) {
                int pizzaX, pizzaY;
                // 하나의 집에 대해 m개의 피자집 중에서 최소 배달거리를 계산하여 저장하기 위한 변수 생성
                int distance = Integer.MAX_VALUE;
                // m개의 피자집중 하나의 피자집 선택
                for (int pizzaNum : combination) {
                    // 해당 피자집의 x 좌표
                    pizzaX = dominoPizza.get(pizzaNum).x;
                    // 해당 피자집의 y 좌표
                    pizzaY = dominoPizza.get(pizzaNum).y;
                    // 문제에서 요구하는 |x1 - x2| + |y1 - y2|를 계산하여
                    // 이전에 계산했던 현재 집에대한 피자배달 거리와 비교하여 작은 값을 저장한다.
                    distance = Math.min(distance, Math.abs(house.x - pizzaX) + Math.abs(house.y - pizzaY));
                }
                // 하나의 집에대한 최소 피자 배달거리가 계산되면 도시 피자 배달거리를 계산하기 위해 해당 값을 누적.
                distanceSum += distance;
            }
            // 하나의 피자집들의 조합에 대한 도시 피자배달거리가 계산되면 이전에 피자집들의
            // 조합에 대한 도시피자배달거리와 비교하여 더 작은값을 저장한다.
            answer = Math.min(answer, distanceSum);
        }
        // 그게 아니라면 아직 피자집들에 대한 하나의 조합이 구성되지 않았으므로 루프를 실행하여 조합을 구성한다.
        else {
            // 탐색을 진행할때 함수를 호출할때마다 start 값을 현재 i 값에서 1 더한 값을 매개변수로
            // 넘겨주기 때문에, 트리의 레벨이 증가할 수록 루프를 반복하는 횟수가 1씩 감소하기 때문에,
            // 트리의 레벨이 증가할 떄 마다 자식노드의 갯수가 1씩 감소한 노드의 갯수가 생성된다.
            // 이렇게 생성된 노드들을 바탕으로 하나의 조합을 구성하기 위해서 탐색을 진행한다.
            for (int i = start; i < dominoPizzaCnt; i++) {
                // 해당 level의 인덱스에 피자집들의 인덱스를 의미하는 i값을 기록한다.
                combination[level] = i;
                // 새로운 탐색을 진행하기 위하여 함수를 호출할때, 현재 level 값에서 1 더한 값과,
                // start 값에 현재 i 값에서 1 더한 값을 매개변수로 넘겨준다.
                DFS(level + 1, i+1);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        map = new int[n][n];
        combination = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = kb.nextInt();
            }
        }

        // 주어진 맵을 탐색하면서 집과 피자집의 좌표를 각각 저장.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 해당 원소가 1이면
                if (map[i][j] == 1) {
                    // 집을 의미하므로 house에 해당 좌표 추가.
                    house.add(new Point(i, j));
                }
                // 해당 원소가 2면
                if (map[i][j] == 2) {
                    // 피자집을 의미하므로 pizza에 해당 좌표 추가.
                    dominoPizza.add(new Point(i, j));
                }
            }
        }
        // 주어진 피자집들 중에서 하나의 조합을 구성할것이기 때문에 피자집의 갯수를 저장
        dominoPizzaCnt = dominoPizza.size();
        // 탐색 시작
        DFS(0, 0);
        System.out.println(answer);

    }
}
