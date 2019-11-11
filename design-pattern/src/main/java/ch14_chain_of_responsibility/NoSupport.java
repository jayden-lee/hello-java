package ch14_chain_of_responsibility;

/**
 * 어떤 동작도 하지 않는 클래스
 */
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
