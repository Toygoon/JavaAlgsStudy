import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수의 개수 N (사용되지 않음)
        int N = Integer.parseInt(br.readLine());
        // 정수 배열 A
        int[] A = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        // 이진 탐색을 위해 미리 정렬
        Arrays.sort(A);

        // 찾을 수의 개수 M
        int M = Integer.parseInt(br.readLine());
        // 찾을 수의 배열 target
        int[] target = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();

        // 찾을 수를 하나씩 찾음
        for (int i = 0; i < M; i++) {
            // 결과를 저장할 변수
            boolean found = false;
            // 왼쪽 포인터 l, 오른쪽 포인터 r, 중간 포인터 m(Index 저장)
            int l = 0, r = A.length - 1, m;
            while (l <= r) {
                // 가운데 지점을 지정
                m = (l + r) / 2;
                // 가운데 값이 찾고자 하는 값보다 큰 경우
                if (A[m] > target[i]) {
                    // 오른쪽 포인터를 줄임
                    r = m - 1;
                } else if (A[m] < target[i]) {
                    // 그렇지 않고, 가운데 값보다 작은 경우는 왼쪽 포인터를 키움
                    l = m + 1;
                } else {
                    // 그렇지 않으면 같은 경우이므로, 찾음
                    found = true;
                    break;
                }
            }

            System.out.println(found ? 1 : 0);
        }
    }
}
