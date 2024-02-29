package dfs_bfs_활용;

import java.io.IOException;
import java.util.Scanner;

public class 조합의_경우수_메모이제이션 {

    static int[][] memo;

    //해당 문제는 주어신 공식을 활용하여 입력된 n r 값에따라 n C r 처럼 조합의 경우수를 출력하는 문제다.
    static int DFS(int n, int r) {
        // 만약 이미 n C r을 계산한 값이 memo에 저장되어 있다면,
        if (memo[n][r] != 0) {
            // 함수를 호출하여 해당 n C r을 계산할 필요가 없으므로
            // 이미 저장되어있는 n C r의 경우의 수를 리턴.
            return memo[n][r];
        }
        // 만약 r이 0이라면,
        if (r == 0) {
            // n개의 수중에서 0개를 뽑아 조합을 구성하는 경우의수는 한가지 이므로 1을 리턴.
            return 1;
        }
        // 만약 n과 r이 같다면,
        if (n == r) {
            // n개의 수중에서 r개의 수, 그러니까 n개의 수중에서 모든 원소를
            // 조합으로 구성하는 경우의 수는 한가지 이므로 1을 리턴.
            return 1;
            // 그게 아니라면 문제에서 주어진 공식을 활용하여 n C r의 경우의 수 값을 계산하기 위해서,
            // 해당 원소를 조합에 포함하는 노드와 해당 원소를 조합에 포함하지 않는 노드, 이렇게
            // 2가지의 노드를 생성하며 해당 조합의 경우의 수를 계산한다.
            // 그리고 계산된 결과 값을
            // memo[n][r]에 저장하고, memo[n][r] 값을 리턴한다.
        } else {
            return memo[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        // 인덱스의 번호는 0번 부터 시작하므로 n+1, r+1 크기의 메모제이션을 활용하기 위한 배열 생성
        memo = new int[n + 1][r + 1];

        System.out.println(DFS(n, r));

    }
}
