package blackjack;

public class BlackJack {

    static Game g = new Game();

    public static void main(String[] args) {
        GUI gui = new GUI();
        g.Generate_deck();
        g.set_information();
        gui.runGUI(g.getCards(),
                g.Players[0].getHand(),
                g.Players[1].getHand(),
                g.Players[2].getHand(),
                g.Players[3].getHand()
        );
        g.Start_Game(gui);
        g.dealer_turn(gui);
    }
}
