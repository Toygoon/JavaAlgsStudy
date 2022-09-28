import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 식을 저장, -를 기준으로 나눔
        String[] eq = br.readLine().split("-");

        // 맨 처음 값으로 시작
        int result = 0, sum;

        for (int i = 0; i < eq.length; i++) {
            // 총합을 저장
            sum = 0;

            // 만약 식에 +가 있다면, 숫자들을 모두 더함
            for (String ss : eq[i].split("[+]"))
                sum += Integer.parseInt(ss);

            if (i == 0)
                // 처음 값은 더해줘야 함
                result += sum;
            else
                // 다른 값들은 괄호를 침
                result -= sum;
        }

        System.out.println(result);
    }
}
