package dfs_bfs_basic;

import java.io.IOException;

public class 팩토리얼 {
    public static int DFS(int num) {
        // 만약 num 1 이라면 1을 리턴후 함수 종료
        if (num == 1) {
            return 1;
            // 만약 1이 아니라면,
        } else {
            // num - 1 값을 매개변수로 전달하고 DFS() 함수 호출
            // num 이 5라고 가정했을때 함수가 호출되는 순서를 나열하면,
            // DFS(5) -> DFS(4) -> DFS(3) -> DFS(2) -> DFS(1) 호출 되며
            // 함수가 종료되어 값을 리턴하는 순서는 DFS(1) -> DFS(2) -> DFS(3) -> DFS(4) -> DFS(5) 순서로 값이 리턴된다.
            // 결과적으로 1 -> 2(2*1) -> 6(3*2) -> 24(4*6), 120(5*24)가 차례대로 리턴된다.
            return num * DFS(num - 1);
        }
    }

    public static int solution(int n) {
        // 팩토리얼을 계산하기위한 재귀함수 호출
        // 스택은 First In Last Out 방식으로 동작하며
        // 함수가 호출되면 스택에 스택프레임에 함수에 대한 정보가 저장되게 된다.
        // 재귀함수는 함수가 호출되면 내부에 동일한 함수가 호출되는것을 의미하며,
        // 가장 마지막에 호출된 함수부터 먼저 종료되기 때문에 해당 함수가 값을 리턴한다면
        // 함수가 호출된 순서의 역순으로 값을 리턴한다.
        return DFS(5);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution(5));
    }
}
