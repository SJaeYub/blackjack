package Blackjack3;


public class Dealer {
	
	private CardDeck deck;
	private Card[] hand;
	private int card_count;
	private int dealerPoint;

	/**constructor - ����
	 * 
	 * @param max_cards - ������ ������ �� �ִ� ī�� ����
	 */
	public Dealer(int max_cards) {
		deck = new CardDeck();
		hand = new Card[max_cards];
		card_count = 0;
		dealerPoint = 0;
	}
	
	/**dp_value - ���� ����Ʈ ��
	 * 
	 * @return - ���� ����Ʈ �հ� ��ȯ
	 */
	public int dp_value() {
		return dealerPoint;
	}
	
	/**dealerSum - ���� ����Ʈ ������Ű��
	 * 
	 * @param a - dealerpoint�� a ��ŭ ����
	 */
	public void dealerSum(int a) {
		dealerPoint = dealerPoint + a;
	}
	
	/** receiveCard - ī�带 ���� �޴´�. �ѵ��� �ʰ��ϸ� ���� �� ����.
	 * @param c - ī��
	 * @return ���������� �޾����� true, �׷��� ������ false
	 */
	public boolean receiveCard(Card c) {
		if(card_count < hand.length) {
			hand[card_count] = c;
			card_count += 1;
			return true;
		}
		else
			return false;
	}
	
	/** showCards - ��� �ִ� ī�帣 ���ش�.
	 * 
	 * @return ��� �ִ� ī�� ��ü
	 */
	public Card[] showCards() {
		Card[] cards = new Card[card_count];
		for(int i = 0; i < card_count; i++) {
			cards[i] = hand[i];
		}
		return cards;
	}
	
}
