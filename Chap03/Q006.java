import java.util.Scanner;

public class Q006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 자연수 N 입력
        int N = sc.nextInt();

        // count : N 미만까지의 경우를 확인하므로, N을 고를 경우를 미리 추가함
        int count = 1, lo = 1, hi = 1, sum = 1;

        while (lo != N) {
            if (sum > N) {
                // 현재 연속 합이 N보다 큰 경우, lo 값을 변경함
                // lo 값을 변경하므로, 기존 lo 값을 sum에서 뺌
                sum -= lo;
                // lo 포인터를 증가시켜서, 새로운 최소 범위를 찾게 함
                lo++;
            } else {
                // 혹은 현재 연속 합이 N보다 작거나 같은 경우

                // 그 중 현재까지의 연속 합이 N과 같은 경우, 개수를 증가시킴
                if (sum == N)
                    count++;
                // hi 포인터를 증가시켜서, 새로운 최대 범위를 찾게 함
                hi++;
                // 현재 총합을 증가시켜 다음 조건식으로 넘어가게 함
                sum += hi;
            }
        }

        System.out.println(count);
    }
}
