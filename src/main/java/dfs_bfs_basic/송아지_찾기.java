package dfs_bfs_basic;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class 송아지_찾기 {
    public class Solution {

        static int s, e;
        // 좌표 생성
        static int[] map;
        // 해당 노드를 방문했는지에 대한 여부를 알기위한 check 배열
        static boolean[] check;

        static int BFS() {
            Queue<Integer> queue = new LinkedList<>();
            // 최상위 노드인 시작점을 큐에 저장
            queue.offer(s);
            // 최상위 노드부터 탐색을 시작하기 때문에 최상위 노드는 방문했다고 체크
            check[s] = true;
            // 점프 횟수를 저장하기 위한 answer
            int answer = 0;
            // 큐에 값이 남아 있다는건 탐색할 노드가 있다는 의미기 떄문에
            // 큐가 완전히 비어있을때 까지 탐색 시작
            while (!queue.isEmpty()) {
                // 현재 큐에 저장되어있는 원소 갰수만큼 루프를 실행하기위해 큐의 사이즈 구하기
                int len = queue.size();
                // 현재 큐에 저장되어있는 원소 갯수 만큼 탐색 시작
                for (int i = 0; i < len; i++) {
                    // 큐의 제일 앞에 위치한 원소를 꺼낸다.
                    int cur = queue.poll();
                    // 현재 꺼낸 값을 기준으로 다음 순서로 탐색할 앞으로 한칸, 뒤로 한칸, 앞으로 5칸 이동하는 3갈래의 노드를 생성
                    for (int next : new int[]{cur + 1, cur - 1, cur + 5}) {
                        // 만약 다음에 탐색할 새롭게 생성된 노드가 좌표 범위 내이고 해당 좌표를 아직 방문하지 않았다면,
                        if (0 < next && next < 10001 && !check[next]) {
                            // 새롭게 방문할 노드가 송아지가 있는 위치라면,
                            if (next == e) {
                                // 해당 노드는 다음 순서에 방문할 노드 임으로 현재 점프한 횟수에서 1더한 값을 리턴한다.
                                return ++answer;
                            }
                            // 다음에 방문할 노드에 방문한 노드라는 표시
                            check[next] = true;
                            // 다음에 방문할 노드를 탐색하기 위해 큐에 저장
                            queue.offer(next);
                        }
                    }
                }
                // 한번의 레벨 탐색이 끝났으면 점프를 한번해서 다음의 노드를 방문 한다는 의미이므로 answer값 1증가.
                answer++;
            }
            return 0;
        }

        public static void main(String[] args) throws IOException {
            int maxVal = 10001;
            map = new int[maxVal];
            check = new boolean[maxVal];
            s = 5;
            e = 14;

            System.out.println(BFS());

        }
    }
}
