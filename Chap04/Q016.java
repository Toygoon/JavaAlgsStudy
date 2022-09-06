import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 크기 N
        int N = Integer.parseInt(br.readLine());

        // 배열 A 저장
        Element[] A = new Element[N];
        for (int i = 0; i < N; i++)
            A[i] = new Element(Integer.parseInt(br.readLine()), i);

        // 정렬
        Arrays.sort(A);

        // 정렬 후 Index 비교
        int max = 0, tmp;
        for (int i = 0; i < N; i++) {
            tmp = A[i].idx - i;

            if (max < tmp)
                max = tmp;
        }

        // Index 차이가 가장 많이 난다는 것은 안쪽 for 문에서 swap이 일어나지 않았다는 것을 의미
        System.out.println(max + 1);
    }
}

class Element implements Comparable<Element> {
    // value : 저장될 값
    // idx : 처음 저장됐던 Index
    public int value, idx;

    public Element(int value, int idx) {
        super();
        this.value = value;
        this.idx = idx;
    }

    @Override
    public int compareTo(Element o) {
        // value 끼리의 비교
        return this.value - o.value;
    }
}
