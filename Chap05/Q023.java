import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q023 {
    // 그래프 (인접 행렬)
    public static boolean[][] G;
    // 방문 여부 배열
    public static boolean[] visited;
    // 연결 요소 개수
    public static int count = 0;

    public static void DFS(int v) {
        // 이미 방문한 상태면, 반환
        if (visited[v])
            return;

        // 현재 정점에 방문
        visited[v] = true;
        // 현재 정점과 연결된 정점 중 방문하지 않은 정점이면 방문
        for (int i = 1; i <= visited.length - 1; i++) {
            if (G[v][i] && !visited[i])
                DFS(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        // V, E 입력
        int V = Integer.parseInt(tmp[0]), E = Integer.parseInt(tmp[1]), from, to;
        // 각 배열 초기화
        G = new boolean[V][V];
        visited = new boolean[V];

        // 그래프 입력
        for (int i = 0; i < E; i++) {
            tmp = br.readLine().split(" ");
            from = Integer.parseInt(tmp[0]) - 1;
            to = Integer.parseInt(tmp[1]) - 1;
            // 무방향성 그래프
            G[from][to] = true;
            G[to][from] = true;
        }


        // 방문하지 않은 정점을 모두 탐색
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        // 출력
        System.out.println(count);
    }
}
