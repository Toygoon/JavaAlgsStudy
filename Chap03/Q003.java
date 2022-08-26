import java.util.Arrays;
import java.util.Scanner;

public class Q003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tmp = sc.nextLine().split(" ");
        // 총 데이터의 개수 (쓰이지 않음)
        int N = Integer.parseInt(tmp[0]);
        // 합을 구해야 하는 개수
        int M = Integer.parseInt(tmp[1]);

        // 데이터 배열 입력
        int[] data = Arrays.stream(("0 " + sc.nextLine()).split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();

        // 구간 합 배열 계산
        for (int i = 1; i < data.length; i++)
            data[i] += data[i - 1];

        // 구간을 입력 받은 후, 출력
        for (int i = 0; i < M; i++) {
            tmp = sc.nextLine().split(" ");
            System.out.println(data[Integer.parseInt(tmp[1])] - data[Integer.parseInt(tmp[0]) - 1]);
        }
    }
}
