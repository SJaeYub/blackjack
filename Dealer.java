package Blackjack3;


public class Dealer {
	
	private CardDeck deck;
	private Card[] hand;
	private int card_count;
	private int dealerPoint;

	/**constructor - 딜러
	 * 
	 * @param max_cards - 딜러가 보유할 수 있는 카드 수량
	 */
	public Dealer(int max_cards) {
		deck = new CardDeck();
		hand = new Card[max_cards];
		card_count = 0;
		dealerPoint = 0;
	}
	
	/**dp_value - 딜러 포인트 합
	 * 
	 * @return - 딜러 포인트 합계 반환
	 */
	public int dp_value() {
		return dealerPoint;
	}
	
	/**dealerSum - 딜러 포인트 누적시키기
	 * 
	 * @param a - dealerpoint에 a 만큼 누적
	 */
	public void dealerSum(int a) {
		dealerPoint = dealerPoint + a;
	}
	
	/** receiveCard - 카드를 한장 받는다. 한도를 초과하면 받을 수 없다.
	 * @param c - 카드
	 * @return 성공적으로 받았으면 true, 그렇지 않으면 false
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
	
	/** showCards - 들고 있는 카드르 내준다.
	 * 
	 * @return 들고 있는 카드 전체
	 */
	public Card[] showCards() {
		Card[] cards = new Card[card_count];
		for(int i = 0; i < card_count; i++) {
			cards[i] = hand[i];
		}
		return cards;
	}
	
}
