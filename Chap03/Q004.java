import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        // 표의 크기 N, 합을 구해야 하는 횟수 M
        int N = Integer.parseInt(tmp[0]), M = Integer.parseInt(tmp[1]);

        // (N * N) 행렬 생성
        int[][] A = new int[N + 1][N + 1];

        // 행렬에 데이터 입력
        for (int i = 1; i <= N; i++)
            A[i] = Arrays.stream(("0 " + br.readLine()).split(" ")).map(String::trim).mapToInt(Integer::parseInt)
                    .toArray();

        // 구간 합 배열 생성
        int[][] D = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];

        // 구간 입력
        for (int i = 0; i < M; i++) {
            int[] p = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(D[p[2]][p[3]] - D[p[0] - 1][p[3]] - D[p[2]][p[1] - 1] + D[p[0] - 1][p[1] - 1]);
        }
    }
}
