package Blackjack3;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;

public class Board extends JPanel {
	private int defaultDealer_x = 30;
	private int defaultDealer_Y = 80;
	private int defaultPlayer_x = 350;
	private int defaultPlayer_y = 80;
	private CardPlayer player;
	private Dealer dealer;
	
	/**constructor - 플레이어와 딜러 게임 진행 내용 출력
	 * 
	 * @param cp - 플레이어 객체 정보
	 * @param d - 딜러 객체 정보
	 */
	public Board(CardPlayer cp, Dealer d) {
		player = cp;
		dealer = d;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 400);
		
		Card [] pcards = player.showCards();
		Card [] dcards = dealer.showCards();
		
		for(int i = 0; i < pcards.length; i++) {
			this.board_distributor(g, pcards[i].getSuit(), pcards[i].getRank(), i*10);
		}
		
		for(int i = 0; i < dcards.length; i++) {
			if(i == 0) {
				g.setColor(Color.BLACK);
				g.drawString("Dealer의 패 : ******** **", defaultDealer_x, defaultDealer_Y + i);				
			}
			else {
				this.board_distributor_dealer(g, dcards[i].getSuit(), dcards[i].getRank(), i*10);
			}
		}
	}
	
	/**unknownMark - 딜러가 받은 첫번째 카드 모자이크 처리
	 * 
	 * @param g - Graphics g
	 * @param i - drawString 함수 y 위치 변화
	 */
	public void unknownMark(Graphics g, int i) {
		g.setColor(Color.BLACK);
		g.drawString("Dealer의 패 : ******** **", defaultDealer_x, defaultDealer_Y + i);
	}
	
	/**board_distributor - 게임 시작 후 첫번째, 두번째 카드 플레이어 분배 내용 출력
	 * 
	 * @param g - Graphics g
	 * @param s - 받은 카드 무늬 
	 * @param r - 받은 카드 등급
	 * @param i - drawString 함수 y 위치 변화
	 */
	public void board_distributor(Graphics g, String s, int r, int i) {
		g.setColor(Color.BLACK);
		if(r == 1 || r == 11 ||	r == 12 || r == 13) {
			if(r == 1) {	
				g.drawString("Player의 패 : " + s + " " + "ACE", defaultPlayer_x, defaultPlayer_y + i);
//				System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "ACE");
			}
			else if(r == 11) {
				g.drawString("Player의 패 : " + s + " " + "JACK", defaultPlayer_x, defaultPlayer_y + i);
//				System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "JACK");
			}
			else if(r == 12) {
				g.drawString("Player의 패 : " + s + " " + "QUEEN", defaultPlayer_x, defaultPlayer_y + i);
//				System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "QUEEN");
			}
			else if(r == 13) {
				g.drawString("Player의 패 : " + s + " " + "KING", defaultPlayer_x, defaultPlayer_y + i);
//				System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "KING");
			}
		}
		else {
			g.drawString("Player의 패 : " + s + " " + r, defaultPlayer_x, defaultPlayer_y + i);
//			System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + pcards[i].getRank());
		}
	}
	
	/**informationString - 딜러 추가 패 안내문구 출력
	 * 
	 * @param g - Graphics g
	 */
	public void informationString(Graphics g) {
		Card [] dcards = dealer.showCards();	
		g.setColor(Color.BLACK);
		g.drawString("Dealer 패의 합이 16 이하입니다. 추가로 카드를 뽑습니다.", defaultDealer_x, defaultDealer_Y + dcards.length - 10); // 105
	}
	
	/**board_distributor - 게임 시작 후 첫번째, 두번째 카드 딜러 분배 내용 출력
	 * 
	 * @param g - Graphics g
	 * @param s - 받은 카드 무늬 
	 * @param r - 받은 카드 등급
	 * @param i - drawString 함수 y 위치 변화
	 */
	public void board_distributor_dealer(Graphics g, String s, int r, int i) {
		g.setColor(Color.BLACK);
		if(r == 1 || r == 11 ||	r == 12 || r == 13) {
			if(r == 1) {	
				g.drawString("Dealer의 패 : " + s + " " + "ACE", defaultDealer_x, defaultDealer_Y + i);
//				System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "ACE");
			}
			else if(r == 11) {
				g.drawString("Dealer의 패 : " + s + " " + "JACK", defaultDealer_x, defaultDealer_Y + i);
//				System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "JACK");
			}
			else if(r == 12) {
				g.drawString("Dealer의 패 : " + s + " " + "QUEEN", defaultDealer_x, defaultDealer_Y + i);
//				System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "QUEEN");
			}
			else if(r == 13) {
				g.drawString("Dealer의 패 : " + s + " " + "KING", defaultDealer_x, defaultDealer_Y + i);
//				System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + "KING");
			}
		}
		else {
			g.drawString("Dealer의 패 : " + s + " " + r, defaultDealer_x,  defaultDealer_Y + i);
//			System.out.println("Player의 패 : " + pcards[i].getSuit() + " " + pcards[i].getRank());
		}
	}
	
	/**board_finishPart - 게임 결과 출력
	 * 
	 * @param g - Graphics g
	 * @param p - 플레이어 점수 합계
	 * @param d - 딜러 점수 합계
	 */
	public void board_finishPart(Graphics g, int p, int d) {
		g.setColor(Color.black);
		if(p > 21 || d > 21) {
			if(player.pp_value() > 21 && dealer.dp_value() > 21) {
				g.drawString("player 합 : " +  p, 200, 200);
				g.drawString("dealer 합 : " +  d, 200, 215);
				g.drawString("Draw!", 200, 230);
			}
			else if(p > 21 && d < 21) {
				g.drawString("player 합 : " +  p, 200, 200);
				g.drawString("dealer 합 : " +  d, 200, 215);
				g.drawString("Burst! Dealer win!", 200, 230);
			}
			else if(p < 21 && d > 21) {
				g.drawString("player 합 : " +  p, 200, 200);
				g.drawString("dealer 합 : " +  d, 200, 215);
				g.drawString("Burst! Player win!", 200, 230);
			}
		}
		else {
			if(p > d) {
				g.drawString("player 합 : " +  p, 200, 200);
				g.drawString("dealer 합 : " +  d, 200, 215);
				g.drawString("Player win!", 200, 230);
			}
			else if(p < d) {
				g.drawString("player 합 : " +  p, 200, 200);
				g.drawString("dealer 합 : " +  d, 200, 215);
				g.drawString("Dealer win!", 200, 230);
			}
		}
	}

}
