import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수의 개수 N (사용되지 않음), 구간의 개수 M
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]), M = Integer.parseInt(tmp[1]);

        // 배열 A 입력
        int[] A = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        // 배열 C의 Index는 '나머지 값'으로 사용되고, Index의 Element는 개수로 사용
        int[] C = new int[M];

        // A 배열 합 계산
        for (int i = 1; i < A.length; i++)
            A[i] += A[i - 1];

        // A 배열에 모든 값을 나머지로 변경
        for (int i = 0; i < A.length; i++) {
            A[i] %= M;

            // 나머지 연산 수행과 동시에, 나머지 합의 개수를 측정
            C[A[i]]++;
        }

        // M으로 나누어 떨어진다는 것은, A[i] == 0인 것을 고른 경우이므로, 이를 추가함
        int result = C[0];
        // Combination 공식으로 연산
        for (int i = 0; i < M; i++)
            result += (C[i] * (C[i] - 1)) / 2;

        System.out.println(result);
    }
}
