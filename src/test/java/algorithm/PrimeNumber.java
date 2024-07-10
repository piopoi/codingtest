package algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 소수 판별법 (Primality Test)
 * <p>
 * 소수(Prime Number) = 1과 자기 자신으로만 나누어지는 수 -> 약수가 2개
 * 합성수(Composite Number) = 약수의 개수가 3개 이상인 수
 * 단, 1은 소수도 합성수도 아님.
 * <p>
 * 좋은 방법이 있다.
 * 에라토스테네스의 체 (Sieve of Eratosthenes)
 * 소수가 아닌 수들을 걸라내보자.
 */
public class PrimeNumber {
    @Test
    @DisplayName("소수 찾기")
    void test() {
        assertThat(findPrimeNumber(128))
                .isEqualTo(List.of(2, 3, 5, 7, 11, 13, 17, 19,
                        23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
                        71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113))
                .hasSize(30);
    }

    private ArrayList<Integer> findPrimeNumber(int n) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        boolean[] isPrimes = new boolean[n + 1]; //소수이면 true, 아니면 false
        Arrays.fill(isPrimes, true); //모두 true로 초기화

        for (int i = 2; i <= n; i++) {
            if (isPrimes[i]) {
                primeNumbers.add(i); //소수 리스트에 추가

                //찾은 소수의 배수들은 모두 제외
                for (int j = i * 2; j <= n; j += i) {
                    if (isPrimes[j]) {
                        isPrimes[j] = false;
                    }
                }
            }
        }

        return primeNumbers;
    }
}
