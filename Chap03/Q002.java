import java.util.Arrays;
import java.util.Scanner;

public class Q002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 시험을 본 과목의 개수 (쓰이지 않음)
        sc.nextLine();

        // 각 과목의 시험 성적을 String으로 입력받아 int 배열로 변환
        int[] score = Arrays.stream(sc.nextLine().split(" ")).map(String::trim).mapToInt(Integer::parseInt).toArray();

        // 최댓값을 구하기 위해 배열을 정렬
        Arrays.sort(score);

        // 배열을 정렬하였으므로, 최댓값은 맨 마지막 요소가 됨
        final int M = score[score.length - 1];

        // 점수를 조작하며 평균 계산
        double avg = 0.0;
        for (int i : score)
            avg += (double) i / M * 100.0;
        avg /= score.length;

        System.out.println(avg);
    }
}
