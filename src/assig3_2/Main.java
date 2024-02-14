package assig3_2;

public class Main {
    /**
     * The Main class represents the entry point of the program.
     * It starts a coin flipping game with two players and a judge.
     *
     * @author Yagel Atias 208905448
     * @author Slava Ignatiev 322015280
     */
    public static void main(String[] args) {
        GamePlay game = new GamePlay();
        Gamer gamer = new Gamer(game, "Slava");
        Gamer gamer2 = new Gamer(game, "Yagel");
        Judge judge = new Judge(game);
        gamer.start();
        gamer2.start();
        judge.start();
    }
}
