package publiccode.datastructure.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 해시 테이블 - 체이닝
 */
public class Chaining {
    static final int TABLE_SIZE = 5000;
    static final int INPUT_SIZE = 5000;

    public static void main(String[] args) {
        Bucket[] hashTable = new Bucket[TABLE_SIZE];

        for (int i = 0; i < INPUT_SIZE; i++) {
            int id = (int) (Math.random() * 10000) % 1000000;
            String name = "사람" + id;
            Student student = new Student(id, name);

            //랜덤 생성한 id가 중복되지 않는 경우에만 해시 테이블에 삽입.
            if(!isExist(hashTable, id)) {
                add(hashTable, student);
            }
        }

        show(hashTable);
    }

    /**
     * 해시 테이블 체이닝 데이터 검색
     */
    static boolean isExist(Bucket[] hashTable, int id) {
        int i = id % TABLE_SIZE;
        if (hashTable[i] != null) {
            Bucket cur = hashTable[i];
            while (cur != null) {
                if (cur.data.id == id) return true; //Case 1. 데이터 찾음
                cur = cur.next;
            }
        }
        //Case 2-1. 해당 index에 Student 데이터가 없거나
        //Case 2-2. 해당 index의 버킷의 체이닝 데이터를 while로 검색했는데도 못찾았거나
        return false;
    }

    /**
     * 특정한 키 인덱스에 데이터 삽입
     */
    static void add(Bucket[] hashTable, Student input) {
        int i = input.id % TABLE_SIZE;
        if (hashTable[i] == null) {
            //해당 인덱스에 데이터 없으면 객체 생성하여 넣어줌.
            hashTable[i] = new Bucket(input, null);
        } else {
            //해당 인덱스에 데이터가 있다면, 연결 리스트의 앞 부분에 새 데이터 끼워넣기.
            Bucket cur = new Bucket(input, hashTable[i]);
            hashTable[i] = cur;
        }
    }

    /**
     * 해시 테이블에 존재하는 모든 데이터 출력
     */
    static void show(Bucket[] hashTable) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                Bucket cur = hashTable[i];
                int cnt = 0;
                while (cur != null) {
                    System.out.printf("키[%d] 이름[%s]\n", i, cur.data.name); //키(Key)는 id가 아니다.
                    cur = cur.next;
                    cnt++;
                }
                if(cnt > 1){
                    list.add(i);
                }
            }
        }

        Collections.sort(list);

        System.out.println("list = " + list);
    }
}
