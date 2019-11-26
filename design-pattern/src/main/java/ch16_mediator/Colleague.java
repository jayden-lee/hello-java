package ch16_mediator;

/**
 * 회원 인터페이스
 */
public interface Colleague {

    void setMediator(Mediator mediator);

    void setColleagueEnabled(boolean enabled);
}
