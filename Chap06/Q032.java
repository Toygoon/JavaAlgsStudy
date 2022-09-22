import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        // 동전의 수 N, 총 금액 K
        int N = Integer.parseInt(tmp[0]), K = Integer.parseInt(tmp[1]), count = 0;

        // 동전 종류 저장 배열
        int[] A = new int[N];

        // 동전 종류 입력 받음
        for (int i = N - 1; i >= 0; i--)
            A[i] = Integer.parseInt(br.readLine());

        // 큰 수부터 반복
        for (int i : A) {
            // 현재 동전의 단위가 K 이하여야 줄 수 있음
            if (i <= K) {
                // K의 배수 만큼 나누어서 count에 추가
                count += K / i;
                // 현재 동전의 값 만큼 나머지
                K %= i;
            }
        }

        System.out.println(count);
    }
}