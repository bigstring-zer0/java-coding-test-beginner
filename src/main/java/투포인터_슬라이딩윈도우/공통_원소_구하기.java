package 투포인터_슬라이딩윈도우;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 공통_원소_구하기 {

    public static List<Integer> solution(int n, int[] arr1, int m, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        // 해당 문제도 두 배열 합치가 문제와 풀이가 비슷하다.
        // arr1과 arr2 값을 투포인터를 활용하여 값을 비교하며 값이 같을때만 answer에 저장한다.
        // 만약에 arr[p1] < arr[p2] 인경우에 작은 값을 원소로 가지고있는 arr의 포인터를 옮겨줘야한다.
        // 왜냐하면 이미 오름차순으로 arr1, arr2를 정렬한 상태에서 값을 비교했을때 만약에, 원소의 값이 큰 arr1의 포인터를 옮긴다면
        // arr1의 나머지 원소는에는 arr2의 해당 원소값보다 작은 값이 없는 상태인데 원소의 값이 작은 arr2의 포인터를 옮겨주지 않고 arr1의 포인터를 옮긴다면
        // arr2 의 해당 원소값은 계속 arr1의 값보다 작을것이므로
        // 포인터는 움직이지 못하고 올바르지 못한 답을 출력할 것이다.
        // 따라서, 원소의 값이 작은 arr2의 포인터를 옮겨야 arr1의 원소와 값이 같은 원소를 발견할 확률이 크기때문에,
        // 두 원소값을 비교했을떄 원소의 값이 작은 arr의 포인터를 옮겨줘야 올바른 답을 계산할 수 있다.

        // 문제에서 arr1, arr2가 오름차순으로 입력된다는 보장이 없으므로 탐색을 진행하기전 오름차순 정렬
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // p1 또는 p2 중, 하나의 값이 n, m보다 같거나 크다면 해당 arr은 탐색을 완료힘으로써 공통 원소를 다 탐색한것이므로 루프 종료
        while (p1 < n && p2 < m) {
            // 만약 arr1값과 arr2값이 같다면,
            if (arr1[p1] == arr2[p2]) {
                // answer에 해당 값을 저장하고 p1값 1증가.
                answer.add(arr1[p1++]);
                // p2값 1증가
                p2++;
                // 만약 그게아니라 arr1값이 arr2값 보다 작다면
            } else if (arr1[p1] < arr2[p2]) {
                // arr1[p1]값보다 작은값이 arr2[p2]에는 없다는 의미이므로 공통원소를 찾기위해 p1값 1증가.
                p1++;
                // 만약 그게아니라 arr2값이 arr1값 보다 작다면
            } else {
                // arr2[p2]값보다 작은값이 arr1[p1]에는 없다는 의미이므로 공통원소를 찾기위해 p2값 1증가.
                p2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        for (Integer val : solution(5, new int[]{1, 3, 9, 5, 2}, 5, new int[]{3, 2, 5, 7, 8})) {
            System.out.print(val + " ");
        }
    }

}
