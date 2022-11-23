import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q043 {
    static long gcd(long a, long b) {
        // 나머지 구함
        long mod = a % b;

        // 나머지가 0이 아니면 재귀호출
        return mod == 0 ? b : gcd(b, mod);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // A, B 입력
        long[] X = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToLong(Long::parseUnsignedLong).toArray();

        // StringBuilder로 String 만듬
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < gcd(X[0], X[1]); i++)
            sb.append("1");

        // 출력
        System.out.println(sb);
    }
}
