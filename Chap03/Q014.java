import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 연산의 개수 N, 명령 임시 저장 cmd
        int N = Integer.parseInt(br.readLine()), cmd;
        // PriorityQueue를 통해 자료 저장, Comparator 선언
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1), b = Math.abs(o2);

                return a == b ? o1.compareTo(o2) : a - b;
            }
        });

        // 결과 출력에 이용될 StringBuilder
        StringBuilder sb = new StringBuilder();

        // N의 수 만큼 명령 처리
        for (int i = 0; i < N; i++) {
            // 명령 입력
            cmd = Integer.parseInt(br.readLine());
            // 0인 경우
            if (cmd == 0) {
                // 배열에 저장된 값이 없는 경우, 0만 출력
                if (q.size() == 0) {
                    sb.append("0\n");
                } else {
                    // 배열에 값이 있는 경우, 미리 정렬되어 있으므로 값만 출력
                    sb.append(q.remove());
                    sb.append("\n");
                }
            } else {
                // 그렇지 않은 경우, 배열에 저장
                q.add(cmd);
            }
        }

        // 결과 출력
        System.out.println(sb);
    }
}
