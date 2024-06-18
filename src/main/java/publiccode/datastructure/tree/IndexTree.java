package publiccode.datastructure.tree;

/**
 * 인덱스 트리 (Index Tree)
 * <p>
 * O(logN)의 시간 복잡도를 가진다.
 */
public class IndexTree {

    //테스트 시 원소는 7개 넣을 예정이지만,
    //구간 합 트리의 인덱스는 1부터 사용하기 때문에 배열 생성 시 크기를 8(+1)로 생성한다.
    static int[] tree = new int[8];

    public static void main(String[] args) {
        update(1, 7);
        update(2, 1);
        update(3, 9);
        update(4, 5);
        update(5, 6);
        update(6, 4);
        update(7, 1);

        //1. 구간 합 구하기
        System.out.printf("1부터 7까지의 구간 합 : %d\n", getSection(1, 7));

        //2. 구간 합 트리 수정하기
        System.out.printf("인덱스 6의 원소를 +3 만큼 수정\n");
        update(6, 3);

        //3. 구간 합 다시 구하기
        System.out.printf("4부터 7까지의 구간 합 : %d\n", getSection(4, 7));
    }

    /**
     * 구간 합 구하기
     * <p>
     * 사용 이유 예시
     * 5~7의 합을 구하라 = (1~7의 합) - (1~4의 합)
     *
     * @param start,end 시작/끝 인덱스
     */
    public static int getSection(int start, int end) {
        return sum(end) - sum(start - 1);
    }

    /**
     * 구간 합 트리의 값 수정하기
     *
     * @param i   인덱스
     * @param dif 수정할 값
     */
    public static void update(int i, int dif) {
        while (i < tree.length) { //구간 합 트리의 인덱스는 1부터 시작한다.
            //1. 인덱스 i의 값을 dif 만큼 변경한다.
            tree[i] += dif;

            //2. 인덱스 i의 마지막 비트만큼 더하면서 뒤로 이동한다.
            //인덱스 i의 마지막 비트 = i & -i (엔드 연산)
            i += (i & -i);
        }
    }

    /**
     * 합 구하기
     *
     * @param i 인덱스
     */
    public static int sum(int i) {
        int result = 0;
        while (i > 0) {
            //1. 인덱스 i의 값 합산
            result += tree[i];

            //2. 인덱스 i의 마지막 비트만큼 빼면서 앞으로 이동한다.
            //인덱스 i의 마지막 비트 = i & -i (엔드 연산)
            i -= (i & -i);
        }
        return result;
    }
}
