import java.util.Scanner;

public class Q001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 숫자 개수 (쓰이지 않음)
        sc.nextLine();

        // 숫자 저장
        String[] num = sc.nextLine().split("");
        
        // 숫자의 합 구함
        int sum = 0;
        for (String s : num)
            sum += Integer.parseInt(s);

        // 출력
        System.out.println(sum);
    }
}