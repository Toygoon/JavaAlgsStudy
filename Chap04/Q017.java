import java.util.Arrays;
import java.util.Scanner;

public class Q017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열 A 입력
        int[] A = Arrays.stream(sc.nextLine().split("")).map(String::trim).mapToInt(Integer::parseInt).toArray();

        // 정렬
        Arrays.sort(A);

        // 거꾸로 출력
        for (int i = A.length - 1; i >= 0; i--)
            System.out.print(A[i]);
    }
}
