package Blackjack3;

import javax.swing.JOptionPane;

public class Starter {

	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		CardPlayer player = new CardPlayer(25);
		Dealer dealer = new Dealer(25);
		Board view = new Board(player, dealer);
		Controller controller = new Controller(deck, player, dealer, view);
		
		
		controller.distributor();
//		JOptionPane.showInputDialog("게임을 시작하시겠습니까?");
	}
}
