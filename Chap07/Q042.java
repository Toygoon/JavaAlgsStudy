import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q042 {
    static int gcd(int a, int b) {
        // 나머지 구함
        int mod = a % b;

        // 나머지가 0이 아니면 재귀호출
        return mod == 0 ? b : gcd(b, mod);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 개수 T
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // A, B 입력 받음
            int[] X = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
            // 최소공배수 구함
            System.out.println(X[0] * X[1] / gcd(X[0], X[1]));
        }
    }
}
