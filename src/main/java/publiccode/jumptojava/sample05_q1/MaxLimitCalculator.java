package publiccode.jumptojava.sample05_q1;

//객체변수 value가 100 보다 큰 값은 가질 수 없도록 제한
public class MaxLimitCalculator extends Calculator {

    @Override
    void add(int val) {
        super.add(val);
        if(this.value > 100) {
            System.out.println("100보다 큰 값을 가질 수 없습니다.");
            this.value = 100;
        }
    }
}
