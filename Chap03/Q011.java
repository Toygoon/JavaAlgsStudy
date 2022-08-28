import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 개수 N, 현재의 Index, 현재 누적 수 cur
        int N = Integer.parseInt(br.readLine()), idx = 0, cur = 1;
        // 원본 수열 A
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        // Stack 선언
        Stack<Integer> stack = new Stack<>();
        // StringBuilder를 통해 결과로 출력할 String 저장
        StringBuilder sb = new StringBuilder();
        // 현재의 Index가 N이 될 때까지 
        while (idx != N) {
            // Stack이 비어있거나, 현재 Index가 더 큰 경우
            if (stack.isEmpty() || A[idx] >= cur) {
                // Stack에 추가
                stack.push(cur++);
                sb.append("+\n");
            } else {
                // Stack의 요소가 현재의 Index보다 크다면, 진행이 불가
                if (stack.pop() > A[idx++]) {
                    System.out.println("NO");
                    return;
                }
                // 그렇지 않은 경우, Stack에서 pop
                sb.append("-\n");
            }
        }

        System.out.println(sb.toString());
    }
}
