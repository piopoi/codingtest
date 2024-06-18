package publiccode.algorithm.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 순차 탐색 (Sequential Search)
 *
 * 문자열을 n개만큼 입력하여 배열 생성 후, 특정 문자열을 찾는 로직
 */
public class SequentialSearch {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //1. 입력할 단어 개수 지정
        System.out.println("1. 입력할 단어 개수 지정");
        String[] arr = new String[Integer.parseInt(s.nextLine())];

        //2. 생성된 배열에 단어 채우기
        System.out.println("2. 생성된 배열에 단어 채우기");
        for (int i = 0; i < arr.length; i++) {
            //2-1. 단어 입력
            String inputStr = s.nextLine();

            //2-2. 기존 입력 단어랑 중복되는지 체크
            boolean isDup = false;
            for(String str : arr) {
                if(str != null && str.equals(inputStr)){
                    isDup = true;
                    break;
                }
            }
            if(isDup) {
                System.out.println("!!! 기존에 입력한 단어와 같습니다. 다시 입력해주세요.");
                i--;
                continue;
            }

            //2-3. 배열에 단어 넣기
            arr[i] = inputStr;
        }

        //3. 배열에서 찾을 단어 입력
        System.out.println("3. 배열에서 찾을 단어 입력");
        String target = s.nextLine();

        //4. 순차 탐색 수행
        int index = sequentialSearch(arr, target);

        if(index < 0) {
            System.out.println("찾는 단어가 배열에 없습니다.");
        } else {
            System.out.printf("찾는 단어가 %d번째에 있습니다.\n", index);
        }

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    public static int sequentialSearch(String[] arr, String target) {
        //1. 배열에서 문자열을 찾으면 해당 index 반환
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(target)) {
                return i;
            }
        }

        //2. 배열에 찾는 문자열이 없을 경우 -1 반환
        return -1;
    }

}
