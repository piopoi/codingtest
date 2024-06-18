package publiccode.datastructure.hash;

/**
 * 해시테이블 - 선형 조사법
 */
public class LinearProbing {

    static final int TABLE_SIZE = 10007;
    static final int INPUT_SIZE = 5000;

    public static void main(String[] args) {
        Student[] hashTable = new Student[TABLE_SIZE];

        for (int i = 0; i < INPUT_SIZE; i++) {
            int id = (int) (Math.random() * 32767) % 1000000;
            String name = "사람" + id;
            Student student = new Student(id, name);

            //랜덤 생성한 id가 중복되지 않는 경우에만 해시 테이블에 삽입.
            if(search(hashTable, student.id) == -1) {
                int index = findEmpty(hashTable, student.id);
                add(hashTable, student, index);
            }
        }

        show(hashTable);
    }

    /**
     * 해시 테이블 내 빈 공간을 선형 탐색으로 찾기
     */
    static int findEmpty(Student[] hashTable, int id) {
        //10007(=TABLE_SIZE)로 나눈 나머지는 0~10006이기 때문에 인덱스 값을 벗어나지 않는다.
        int i = id % TABLE_SIZE;
        while (true) {
            if (hashTable[i % TABLE_SIZE] == null) {
                return i % TABLE_SIZE;
            }
            i++;
        }
    }

    /**
     * 특정한 ID 값에 매칭되는 데이터를 해시 테이블 내에서 찾는다.
     */
    static int search(Student[] hashTable, int id) {
        int i = id % TABLE_SIZE;
        while (true) {
            if (hashTable[i % TABLE_SIZE] == null) {
                return -1;
            } else if (hashTable[i % TABLE_SIZE].id == id) {
                return i;
            }
            i++;
        }
    }

    /**
     * 해시 테이블에 데이터 삽입
     * - 특정한 키 인덱스에 데이터를 삽입한다.
     */
    static void add(Student[] hashTable, Student input, int key) {
        hashTable[key] = input;
    }

    /**
     * 해시 테이블의 특정한 키의 데이터를 반환한다.
     */
    static Student getValue(Student[] hashTable, int key) {
        return hashTable[key];
    }

    /**
     * 해시 테이블에 존재하는 모든 데이터를 출력
     */
    static void show(Student[] hashTable) {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                System.out.printf("키[%d] 이름[%s]\n", i, hashTable[i].name);
            }
        }
    }
}
