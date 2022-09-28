import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 회의 수 N
        int N = Integer.parseInt(br.readLine()), result = 0, end = 0;
        // room[n][0] : 시작 시간, room[n][1] : 종료 시간
        int[][] room = new int[N][2];

        // 입력
        for (int i = 0; i < N; i++)
            room[i] = Arrays.stream(br.readLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });


        for (int i = 0; i < N; i++) {
            // 비어있다면 종료시간 만큼 이용하기
            if (end <= room[i][0]) {
                end = room[i][1];
                result++;
            }
            // 아직 다른 회의가 진행 중이면 넘김
        }

        System.out.println(result);
    }
}
