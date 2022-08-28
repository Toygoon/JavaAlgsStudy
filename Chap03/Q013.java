import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 카드 개수 N
        int N = sc.nextInt();

        // 자료구조로 Queue를 사용
        Queue<Integer> q = new LinkedList<>();
        // 1부터 N까지 Q에 추가
        for (int i = 1; i <= N; i++)
            q.add(i);

        // Queue에 자료가 하나만 남을 때까지 반복
        while (q.size() != 1) {
            q.remove();
            q.add(q.remove());
        }

        // 맨 마지막 요소를 출력
        System.out.println(q.remove());
    }
}
