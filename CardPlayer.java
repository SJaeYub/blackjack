package Blackjack3;


public class CardPlayer {
	
	private Card[] hand;
	private int card_count;
	private int playerPoint;
	
	/**constructor - 플레이어
	 * 
	 * @param max_cards - 최대 보유 카드양
	 */
	public CardPlayer(int max_cards) {
		hand = new Card[max_cards];
		card_count = 0;
		playerPoint = 0;
	}
	
	/**pp_value - 플레이어 포인트 합계
	 * 
	 * @return - 현재 플레이어의 포인트 합계 반환
	 */
	public int pp_value() {
		return playerPoint;
	}
	
	/**playerSum - 플레이어 기존 포인트에 새로 포인트 합산
	 * 
	 * @param a - playerPoint에 a 만큼 증가
	 */
	public void playerSum(int a) {
		playerPoint = playerPoint + a;
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
