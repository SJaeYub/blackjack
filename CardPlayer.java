package Blackjack3;


public class CardPlayer {
	
	private Card[] hand;
	private int card_count;
	private int playerPoint;
	
	/**constructor - �÷��̾�
	 * 
	 * @param max_cards - �ִ� ���� ī���
	 */
	public CardPlayer(int max_cards) {
		hand = new Card[max_cards];
		card_count = 0;
		playerPoint = 0;
	}
	
	/**pp_value - �÷��̾� ����Ʈ �հ�
	 * 
	 * @return - ���� �÷��̾��� ����Ʈ �հ� ��ȯ
	 */
	public int pp_value() {
		return playerPoint;
	}
	
	/**playerSum - �÷��̾� ���� ����Ʈ�� ���� ����Ʈ �ջ�
	 * 
	 * @param a - playerPoint�� a ��ŭ ����
	 */
	public void playerSum(int a) {
		playerPoint = playerPoint + a;
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
