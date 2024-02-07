package assig3_2;

public class Main {
    public static void main(String[] args) {
        GamePlay game = new GamePlay();
        Gamer gamer = new Gamer(game, "Ron");
        Gamer gamer2 = new Gamer(game, "Noe");
        Judge judge = new Judge(game);
        gamer.start();
        gamer2.start();
        judge.start();
    }
}
