package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최대_수입_스케쥴 {
    static class Lecture{
        int pay, day;


        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        public int getPay() {
            return pay;
        }

        public int getDay() {
            return day;
        }

    }
    static int maxDay = Integer.MIN_VALUE;

    // 해당 문제는 가장 여유기간이 많이 남은 강의들 부터 탐색하며 최대 스입스케쥴을 계산하는 문제다.
    // 강의를 진행하기까지 여유가 없는 강의를 선택하는것보다 최대한 강의 여유기간이 많이 남은 강의들중 페이가 많은 강의들을 선택해야
    // 최대의 수입을 가질 수 있다.
    static void solution(List<Lecture> schedule, int n) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // 여유가 가장 많이 남은 강의부터 탐색하기위해 Day 값을 기준으로 내립차순 정렬
        schedule.sort(Comparator
                .comparing(Lecture::getDay)
                .reversed());

        int answer = 0;

        int idx = 0;
        // 가장 여유기간이 많이 남은 day 부터 탐색시작
        for (int i = maxDay; i > 0; i--) {

            while (idx < n) {
                // i 와 해당 강의의 여유기간이 같지 않다면,
                if (schedule.get(idx).getDay() != i) {
                    // 이미 여유기간이 i 인 강의들을 큐에 다 넣었다는 의미이므로 루프 종료
                    break;
                }
                // 큐에 여유기간이 i 인 강의들중에 페이가 가장 많은 강의를 선택하기위해 우선순위큐에 저장
                queue.offer(schedule.get(idx).getPay());
                idx++;

            }
            // 만약 큐가 비어있지 않다면, 강의를 진행하기위해 선택할 수 있는 강의가 있다는 의미다.
            if (!queue.isEmpty()) {
                // 페이가 가장 높은 강의를 꺼내어 answer에 누적한다.
                answer += queue.poll();
            }
        }

        System.out.println(answer);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Lecture> schedule = new ArrayList<>();

        int p, d;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            schedule.add(new Lecture(p, d));
            maxDay = Math.max(maxDay, d);
        }
        solution(schedule, n);
    }

}
