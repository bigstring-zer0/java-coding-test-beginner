package array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 큰_수_출력하기 {

    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        // 배열의 원소에 접근하여 해당 값을 비교할 수 있는지를 물어보는 간단한 문제인것 같다.
        // 첫번째 수는 무조건 크다했으니 먼저 answer에 추가한다.
        answer.add(arr[0]);
        // 첫번째수는 이미 answer에 추가했으니 배열의 1번째 원소부터 바로 앞의 원소와 비교한다.
        for (int i = 1; i < arr.length; i++) {
            // 만약 현재 배열의 원소와 바로 앞의 원소보다 크다면
            if (arr[i] > arr[i-1]){
                // answer에 해당 원소을 추가한다.
                answer.add(arr[i]);
            }

        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        for (Integer i : solution(6, new int[]{7, 3, 9, 5, 6, 12})) {
            System.out.print(i + " ");
        }
    }
}
