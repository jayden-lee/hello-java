package ch14_chain_of_responsibility;

/**
 * 지정한 번호의 트러블에 한하여 처리하는 클래스
 */
public class SpecialSupport extends Support {

    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}
