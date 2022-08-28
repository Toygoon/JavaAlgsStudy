import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 수의 개수 N, 구간의 개수 M
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]), M = Integer.parseInt(tmp[1]);

        long[] S = new long[N], C = new long[M];
        long result = 0;

        // 배열 S 입력
        tmp = br.readLine().split(" ");
        // 배열 0의 초기값을 지정 (합산을 위함)
        S[0] = Long.parseLong(tmp[0]);
        // 배열 S에 입력받은 값을 바로 합산
        for (int i = 1; i < N; i++)
            S[i] = S[i - 1] + Long.parseLong(tmp[i]);

        // 합 배열에 나머지 연산
        for (int i = 0; i < N; i++)
            // 나머지 연산 수행과 동시에, 나머지 합의 개수를 측정
            C[(int) S[i] % M]++;

        // 구간 합 자체가 0이면 정답에 추가
        // M으로 나누어 떨어진다는 것은, A[i] == 0인 것을 고른 경우이므로, 이를 추가함
        result = C[0];

        // Combination 공식으로 연산
        for (int i = 0; i < M; i++)
            if (C[i] > 1)
                result += (C[i] * (C[i] - 1) / 2);

        System.out.println(result);
    }
}
