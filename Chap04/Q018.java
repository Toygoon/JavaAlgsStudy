import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 사람 수 N
        int N = Integer.parseInt(br.readLine());
        // 시간 배열 P
        int[] P = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();

        // 배열을 오름차순으로 정렬
        Arrays.sort(P);
        // 누적 합 계산
        for (int i = 1; i < N; i++)
            P[i] += P[i - 1];

        // 배열의 모든 요소 합 출력
        System.out.println(Arrays.stream(P).sum());
    }
}
