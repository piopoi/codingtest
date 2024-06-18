package publiccode.datastructure.hash;

/**
 * 버킷(Bucket) 구조체
 */
public class Bucket {
    Student data;
    Bucket next;

    public Bucket(Student data, Bucket next) {
        this.data = data;
        this.next = next;
    }
}
