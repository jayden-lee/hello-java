package ch14_chain_of_responsibility;

/**
 * 지정한 번호 미만의 트러블을 해결하는 클래스
 */
public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() < limit;
    }
}
