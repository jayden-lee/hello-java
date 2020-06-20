package ch10_strategy;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("ella", new WinningStrategy(12));
        Player player2 = new Player("jayden", new ProbStrategy(2000));

        for (int i =0 ; i < 10000; i++) {
            Hand hand1 = player1.nextHand();
            Hand hand2 = player2.nextHand();

            if (hand1.isStrongerThan(hand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (hand2.isStrongerThan(hand1)) {
                System.out.println("Winner: " + player2);
                player2.win();
                player1.lose();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }

        System.out.println("==========================================");
        System.out.println("Total result : ");
        System.out.println(player1);
        System.out.println(player2);
    }
}
