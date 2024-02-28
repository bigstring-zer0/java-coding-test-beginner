package dfs_bfs_활용;

import java.io.IOException;
import java.util.Scanner;

public class 수열_추측하기 {

    static int[] combination;
    static int[] permutation;
    static boolean[] visited;
    static int n,f;
    static int[][] memo;
    static boolean findAnswer;

    static int combination(int n, int r) {
        //만약 이미 n C r을 계산한 값이 memo에 저장되어 있다면,
        if(memo[n][r] != 0) {
            //함수를 호출하여 해당 n C r을 계산할 필요가 없으므로
            //이미 저장되어있는 n C r의 경우의 수를 리턴.
            return memo[n][r];
        }
        //만약 r이 0이라면,
        if(r == 0) {
            // n개의 수중에서 0개를 뽑아 조합을 구성하는 경우의수는 한가지 이므로 1을 리턴.
            return 1;
        }
        // 만약 n과 r이 같다면,
        if(n == r) {
            // n개의 수중에서 r개의 수,그러니까 n개의 수중에서 모든 원소를
            //조합으로 구성하는 경우의 수는 한가지 이므로 1을 리턴.
            return 1;
            // 그게 아니라면 문제에서 주어진 공식을 활용하여 n C r의 경우의 수 값을 계산하기 위해서,
            // 해당 원소를 조합에 포함하는 노드와 해당 원소를 조합에 포함하지 않는 노드,이렇게
            // 2가지의 노드를 생성하며 해당 조합의 경우의 수를 계산한다.
            //그리고 계산된 결과 값을// memo[n][r]에 저장하고, memo[n][r]값을 리턴한다.
        } else {
            return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }

    static void DFS(int level, int sum) {
        //만약 정답을 찾았다면,
        if(findAnswer) {
            //재귀 호출로 인해 스택에 쌓여있는 함수들은 더이상 신경쓰지 않아도 되므로
            //해당 함수가 부모 노드로 리턴하는 즉시 함수 종료.
            return;
        }
        //만약 level이 n과 같다면
        if(level == n) {
            // 1... N로 만들수 있는 수열중 하나를 완성한 것이므로,
            //해당 수열의 각각의 원소와 이항계수 원소들을 곱한 값을 누적한 값이
            // f와 같다면,
            if(sum == f) {
                //문제에서 요구하는 정답을 찾은것이므로 문제에서 요구하는 형식대로 정답을 출력.
                for(int val : permutation) {
                    System.out.print(val + " ");
                }
                //문제에서 요구하는 정답을 찾았으므로,
                //백트래킹을 위해 답을 찾았다고 표시한다.
                findAnswer = true;
            }
            //그게 아니라면 수열을 아직 완성하지 못했으므로
        } else {
            //루프를 n번 실행하며 1.. n까지 원소들로 수열을 구성한다.
            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    //현재 트리의 level에 따라 조합의 원소와 수열의 원소가 원소 정해지며,
                    //현재 트리의 level에 따라 permutation[level]에 해당 원소를 기록한다.
                    permutation[level] = i;
                    // sum에 combination[level] * permutiaon[level]값을 누적하여
                    //수열을 구성하기위해 새로운 원소를 탐색한다.
                    DFS(level+1, sum+(combination[level]*permutation[level]));
//해당 원소로 수열의 구성이 끝나 해당 함수의 호출이 종료되고 해당 원소를
//다른 경우의 수열을 구성할때 필요하므로 사용하지 않은 원소라고 표시한다.
                    visited[i] =false;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        combination = new int[n];
        permutation = new int[n];
        visited = new boolean[n + 1];
        //인덱스의 번호는 0번 부터 시작하므로 n+1, n+1크기의 메모제이션을 활용하기 위한 배열 생성
        memo = new int[n + 1][n + 1];
        //먼저 n차수의 이항계수를 먼저 계산한다.
        // n차수의 이항계수는 n-1 C 0... n-1의 조합의 경우의수와 같으므로
// n-1 C 0...n-1조합의 경우의수를 combination[i]에 기록한다.
        //먼저 콤비네이션이션의 경우의 수를 먼저 계산한다.
        for(var i = 0; i < n; i++) {
            combination[i] = combination(n - 1, i);
        }

        DFS(0, 0);
    }


}
