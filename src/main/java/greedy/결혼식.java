package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 결혼식 {
    static class TimeInfo{
        int start, end;

        public TimeInfo(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

    }

    static void solution(List<TimeInfo> timeTable, int n) {
        // 일반 큐가 아닌 우선순위 큐를 활용하는 이유는
        // 원소를 순차적으로 탐색하면서 start 값에 따라 해당 원소의 end 값을 저장하게 될텐데
        // 피로연 입장 순서와 상관없이 end 시각이 동일하다면 그에 해당하는 원소들은 모두 큐에서 꺼내줘야 하므로
        // 일반큐가 아닌 우선순위 큐로 정렬된 상태에서 poll()을 진행하야 해당 원소들을 꺼낼수 있다.
        // 한마디로 큐를 입력받은 시각에 따라 피로연에 해당 시간동안 피로연에 참석한 사람들을 큐에 저장하고
        // 시각이 지나면 큐에서 꺼내서 해당 사람들을 피로연장소에서 퇴장시키면서
        // 피로연에 참석하는 최대 인원수를 계산하는 무넺다.

        // 큐에 end 값을 저장하여 순차적으로 탐색하는 원소들의 start 값에 따라 해당하는 원소들을
        // 큐에서 모두 꺼내주기위한 priorityQueue를 활용
        Queue<Integer> queue = new PriorityQueue<>();

        // 입력받은 값들의 원소를 start 값에 따라 정렬하고 start 값이 같다면 end 값을 바탕으로 오름차순 정렬한다.
        timeTable.sort(Comparator
                .comparing(TimeInfo::getStart)
                .thenComparing(TimeInfo::getEnd));
        // 정렬된 리스트의 첫번째 사람이 피로연에 참석한 상태에서 탐색을 시작하므로 answer 1로 초기화
        int answer = 1;

        // 큐에 첫번째 사람이 피로연에서 퇴장하는 시각을 큐에 저장
        queue.offer(timeTable.get(0).getEnd());

        // 0번째가 아닌 1번째 사람부터 탐색 시작
        for (int i = 1; i < n; i++) {
            // 만약 큐가 비어있지않고 현재시점에서 피로연에 제일 먼저 참석한 사람의 퇴장시각이
            // 현재 피로연에 참석하려는 사람의 시작 시각보다 작거나 같다면,
            // 현재시점에서 피로연에 제일 먼제 참석한 사람은 퇴장할 시각이다.
            while (!queue.isEmpty() && queue.peek() <= timeTable.get(i).getStart()) {
                // 현재시점에서 피로연에 제일 먼저 참석한 사람을 퇴장처리
                queue.poll();
            }

            // 현재 피로연에 참석하려는 사람의 퇴장 시각을 큐에 저장
            queue.offer(timeTable.get(i).getEnd());
            // 현재 사람의 입장 정보와 퇴장 정보를 바탕으로 queue를 업데이트 했으므로
            // 이전 참석자까지 탐색했을때의 참석자 수와
            // 현재 사람이 입장했을때 참석자의 수를 비교하여 최대값을 업데이트
            answer = Math.max(answer, queue.size());
        }

        System.out.println(answer);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<TimeInfo> timeTable = new ArrayList<>();

        int s, e;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            timeTable.add(new TimeInfo(s, e));
        }
        solution(timeTable, n);
    }
}
