package ch09_bridge;

/**
 * DisplayImpl는 구현 클래스 계층 중에 최상위에 위치하는 추상 클래스
 */
public abstract class DisplayImpl {

    abstract public void rawOpen();


    abstract public void rawPrint();

    abstract void rawClose();
}
