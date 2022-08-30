import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q026 {
    public static int V, E, S;
    public static List<Set<Integer>> G;
    public static boolean[] visited;

    public static void DFS(int v) {
        if (visited[v])
            return;

        // 현재 방문한 정점 출력
        System.out.printf("%d ", v + 1);
        // 현재 정점을 방문 처리
        visited[v] = true;
        // 현재 정점에 연결된 모든 정점 탐색
        for (int i : G.get(v))
            // 연결된 정점 중, 방문하지 않은 정점이 있다면 재귀 호출을 통해 방문
            if (!visited[i])
                // DFS 재귀 호출로 메모리에 Stack 쌓음
                DFS(i);
    }

    public static void BFS(int v) {
        // 방문할 정점을 쌓아두는 Queue
        Queue<Integer> q = new LinkedList<>();
        // 시작 지점을 Queue에 추가
        q.add(v);
        // 현재 정점을 방문 처리
        visited[v] = true;

        int e;
        // Queue에 방문해야 할 정점이 남아있지 않을 때까지 방문
        while (!q.isEmpty()) {
            // 방문해야 할 대상 정점을 Dequeue
            e = q.poll();
            // 현재 방문한 정점 출력
            System.out.printf("%d ", e + 1);

            // 현재 정점에 연결된 모든 정점 탐색
            for (int i : G.get(e)) {
                // 연결된 정점을 모두 방문, 방문하지 않은 정점 탐색
                if (!visited[i]) {
                    // 해당 정점을 방문 처리
                    visited[i] = true;
                    // 연결된 정점은 현재 정점 e에서 탐색을 완료하면 다시 탐색
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        // 정점 개수
        V = Integer.parseInt(tmp[0]);
        // 간선 개수
        E = Integer.parseInt(tmp[1]);
        // 시작 지점
        S = Integer.parseInt(tmp[2]);
        // 그래프를 담는 ArrayList
        G = new ArrayList<>(V);

        // ArrayList의 각 요소 초기화
        for (int i = 0; i < V; i++)
            // 그래프 내부의 연결된 정점 목록은 정렬을 위해 TreeSet 사용
            G.add(i, new TreeSet<>());

        // 간선 입력
        int from, to;
        for (int i = 0; i < E; i++) {
            tmp = br.readLine().split(" ");
            from = Integer.parseInt(tmp[0]) - 1;
            to = Integer.parseInt(tmp[1]) - 1;

            // 양방향 그래프이므로, 둘 다 추가
            G.get(from).add(to);
            G.get(to).add(from);
        }

        visited = new boolean[V];
        DFS(S - 1);

        visited = new boolean[V];
        System.out.println();
        BFS(S - 1);
    }
}
