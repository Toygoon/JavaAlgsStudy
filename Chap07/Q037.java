import java.util.LinkedList;
import java.util.Scanner;

public class Q037 {
    // 소수 찾기 메서드
    public static boolean isPrime(int x) {
        // 2부터 시작해서 제곱수 하나씩 나누기
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // M <= N
        int M = sc.nextInt(), N = sc.nextInt();
        LinkedList<Integer> prime = new LinkedList<>();

        for (int i = M; i <= N; i++) {
            if (i == 0 || i == 1)
                continue;

            if (isPrime(i))
                prime.add(i);
        }

        for (int i : prime)
            System.out.println(i);
    }
}
