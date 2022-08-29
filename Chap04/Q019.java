import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 데이터 개수 N (사용되지 않음), K 번째 수
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]), K = Integer.parseInt(tmp[1]);

        // 배열 A 입력
        int[] A = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        // 정렬
        Arrays.sort(A);

        // [K-1]의 Index 요소 출력
        System.out.println(A[K - 1]);
    }
}
