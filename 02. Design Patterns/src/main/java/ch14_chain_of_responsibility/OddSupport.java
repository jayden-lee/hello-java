package ch14_chain_of_responsibility;

/**
 * 홀수 번호의 트러블을 처리하는 클래스
 */
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1;
    }
}
