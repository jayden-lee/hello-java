package ch18_memento.main;

import ch18_memento.game.Gamer;
import ch18_memento.game.Memento;

public class Main {

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento(); // 최초의 상태 저장

        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("상태: " + gamer);

            gamer.bet();

            System.out.println("소지금: "+ gamer.getMoney());

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("Memento 새로 생성");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() /2 ) {
                System.out.println("Memento 상태 복원");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // ignore
            }

            System.out.println();
        }
    }
}
