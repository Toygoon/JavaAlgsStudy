import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Q033 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드 수 N
        int N = Integer.parseInt(br.readLine()), sum = 0;
        // 오름차순 유지를 위한 카드 저장 PriorityQueue
        PriorityQueue<Integer> cards = new PriorityQueue<>();

        // 카드 추가
        for (int i = 0; i < 3; i++)
            cards.add(Integer.parseInt(br.readLine()));
        
        // 마지막 카드가 생길 때까지 반복
        while (cards.size() != 1) {
            // 카드 2개를 뺀 이후 합을 누적
            sum += cards.remove() + cards.remove();
            // 누적된 카드를 더함
            cards.add(sum);
        }
        
        System.out.println(sum);
    }
}
