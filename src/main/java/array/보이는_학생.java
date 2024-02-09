package array;

public class 보이는_학생 {
    public static int solution(int n, int[] arr){
        // 처음 학생은 선생님 시점에서 반드시 보이므로 answer를 1로 초기화.
        int answer = 1;
        // 탐색을 시작하는 시점에서 키가 가장 큰 학생은 1번째 학생
        int maxTall = arr[0];

        // 현재 탐색한 위치의 학생이 이때까지 탐색한 학생들중 키가 가장 큰 학생의 키보다 크면
        // 선생님의 시야에서 현재 탐색한 위치에 있는 학생이 보인다는것을 이용한 풀이
        // 물론 이중 루프를 활용하여 풀 수 있겠지만 그럴 경우 시간 복잡도가 O(N^2)이기 때문에
        // 하나의 루프로 푸는것이 훨씬 효율적이다.
        // 탐색 시작
        for (int i = 1; i < n; i++) {
            // 현재 접근한 위치에 있는 학생의 키가 탐색하는 시점에서 키가 가장큰 학생의 키보다 크다면,
            if (arr[i] > maxTall) {
                // 선생님의 시점에서 보인다는 의미이므로 현재 접근한 친구의 키를 가장 큰 키로 업데이트
                maxTall = arr[i];
                // 선생님 시점에서 보이는 학생을 한명 탐색했으므로 answer값 1증가.
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.print(solution(8, new int[]{130, 135, 148, 140, 145, 150, 150, 153}));
    }
}
