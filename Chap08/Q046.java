import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Q046 {
    // 그래프
    public static boolean[][] G;
    // 가는 거리 비용
    public static int[] cost;

    public static void BFS(int node) {
        // 방문할 노드 저장할 Queue
        LinkedList<Integer> queue = new LinkedList<>();

        // 방문 여부 확인
        boolean[] visited = new boolean[G[0].length];

        // Queue에 시작 노드 추가
        queue.add(node);
        while (!queue.isEmpty()) {
            // 대기 중인 노드 꺼냄
            int cur = queue.poll();

            for (int i = 1; i < G[0].length; i++) {
                // 가는 길이 있고, 방문하지 않았으면 방문
                if (G[cur][i] && !visited[i]) {
                    // i번째 노드를 방문하기 위한 비용은, 현재까지 온 비용을 더해줘야 함
                    cost[i] = cost[cur] + 1;
                    // 방문했다고 표시
                    visited[i] = true;
                    // 다음엔 여기서 시작하기 위해 Queue에 추가
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M, K, X 입력 받음
        int[] tmp = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        int N = tmp[0], M = tmp[1], K = tmp[2], X = tmp[3];

        // 출력했는지 확인
        boolean printed = false;

        // 그래프 배열 생성, Index를 바로 이용하기 위해 1개씩 더 만듬
        G = new boolean[N + 1][N + 1];
        cost = new int[N + 1];

        for (int i = 0; i < M; i++) {
            // 에지 입력
            tmp = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            G[tmp[0]][tmp[1]] = true;
        }

        BFS(X);
        for (int i = 1; i < N + 1; i++) {
            if (cost[i] == K) {
                printed = true;
                System.out.println(i);
            }
        }

        if (!printed)
            System.out.println(-1);
    }
}
