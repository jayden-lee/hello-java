package ch14_chain_of_responsibility;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support jayden = new SpecialSupport("Jayden", 50);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        alice.setNext(bob)
            .setNext(jayden)
            .setNext(diana)
            .setNext(elmo)
            .setNext(fred);

        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}
