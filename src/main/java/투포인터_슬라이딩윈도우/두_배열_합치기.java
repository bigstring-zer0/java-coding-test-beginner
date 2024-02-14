package 투포인터_슬라이딩윈도우;

import java.io.IOException;
import java.util.Arrays;

public class 두_배열_합치기 {

    public static int[] solution(int n, int[] arr1, int m, int[] arr2) {
        int[] answer = new int[n + m];
        int p1 = 0, p2 = 0;
        int idx = 0;
        // 처음에 n과 m이 동일한 값이면 바로 문제를 풀었겠지만 n과 m 값이 달라서 어떻게 풀어야하나 고민을 했다.
        // arr1[p1] < arr2[p2] 를 만족하는 경우에 작은수가 앞에 위치해야 오름차순을 만족함으로,
        // 값이 작은 arr1[p1]을 answer에 저장하고 값이 같은 경우이거나 arr1[p2]가 값이 큰경우는 arr2[p2]를
        // answer에다가 저장하는 방식을 생각했는데 이렇게 되면 n과 m의 길이가 다름으로 상대적으로 큰값이 많이 분포되어있는
        // arr1 또는 arr2가 answer에 저장되지 못하기 때문에 남은 원소들을 어떻게 answer에 저장해야할까 라는
        // 생각이 들었기 때문에 해당 방법은 아니라고 생각했다. 하지만 아무리 생각해도 다른방법이 떠오르지 않자
        // 어차피 arr1 arr2 둘중에 하나는 탐색을 무조건 완료할것이므로 하나의 arr만 먼저 탐색을 완료하고
        // answer에 저장되지 못하고 남은 arr을
        // p1, p2 값이 각각 n, m 보다 작다면 해당 arr이 아직 탐색이 완료된 배열이 아니므로
        // 해당 arr을 한번더 while을 활용해서 answer에 저장하기로 했다.
        // 투포인터 알고리즘을 활용하여 문제를 풀면 크게 어렵지 않게 문제를 풀수 있다.
        // p1 또는 p2 중, 하나의 값이 n, m보다 같거나 크다면 해당 arr은 탐색을 완료 했으므로 루프 종료
        while (p1 < n && p2 < m) {
            // 만약 arr1[p1]의 값이 arr2[p2]보다 작다면 answer의 앞쪽에 앞에 위치해야한다.
            if (arr1[p1] < arr2[p2]) {
                // answer에 arr[p1]을 저장하고 p1값과 idx값을 각각 1씩 증가.
                answer[idx++] = arr1[p1++];
                // 그게 아니라 arr1[p1]과 arr2[p2]의 값이 같거나 arr2[p2]의 값이 더 크다면
            } else {
                // answer에 arr[p2]을 저장하고 p2값과 idx값을 각각 1씩 증가.
                answer[idx++] = arr2[p2++];
            }
        }

        // 만약 p1이 n 보다 작다면 아직 arr1을 탐색 완료한것이 아니므로
        if (p1 < n) {
            // arr1의 남은 원소들을 answer에 저장
            while (p1 < n) {
                answer[idx++] = arr1[p1++];
            }
            // 그게 아니라면, p2가 m 보다 작다면 아직 arr2을 탐색 완료한것이 아니므로
        } else {
            // arr2의 남은 원소들을 answer에 저장
            while (p2 < m) {
                answer[idx++] = arr2[p2++];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(3, new int[]{1, 3, 5}, 5, new int[]{2, 3, 6, 7, 9})));

    }
}
