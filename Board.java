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
	
	/**constructor - �÷��̾�� ���� ���� ���� ���� ���
	 * 
	 * @param cp - �÷��̾� ��ü ����
	 * @param d - ���� ��ü ����
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
				g.drawString("Dealer�� �� : ******** **", defaultDealer_x, defaultDealer_Y + i);				
			}
			else {
				this.board_distributor_dealer(g, dcards[i].getSuit(), dcards[i].getRank(), i*10);
			}
		}
	}
	
	/**unknownMark - ������ ���� ù��° ī�� ������ũ ó��
	 * 
	 * @param g - Graphics g
	 * @param i - drawString �Լ� y ��ġ ��ȭ
	 */
	public void unknownMark(Graphics g, int i) {
		g.setColor(Color.BLACK);
		g.drawString("Dealer�� �� : ******** **", defaultDealer_x, defaultDealer_Y + i);
	}
	
	/**board_distributor - ���� ���� �� ù��°, �ι�° ī�� �÷��̾� �й� ���� ���
	 * 
	 * @param g - Graphics g
	 * @param s - ���� ī�� ���� 
	 * @param r - ���� ī�� ���
	 * @param i - drawString �Լ� y ��ġ ��ȭ
	 */
	public void board_distributor(Graphics g, String s, int r, int i) {
		g.setColor(Color.BLACK);
		if(r == 1 || r == 11 ||	r == 12 || r == 13) {
			if(r == 1) {	
				g.drawString("Player�� �� : " + s + " " + "ACE", defaultPlayer_x, defaultPlayer_y + i);
//				System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "ACE");
			}
			else if(r == 11) {
				g.drawString("Player�� �� : " + s + " " + "JACK", defaultPlayer_x, defaultPlayer_y + i);
//				System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "JACK");
			}
			else if(r == 12) {
				g.drawString("Player�� �� : " + s + " " + "QUEEN", defaultPlayer_x, defaultPlayer_y + i);
//				System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "QUEEN");
			}
			else if(r == 13) {
				g.drawString("Player�� �� : " + s + " " + "KING", defaultPlayer_x, defaultPlayer_y + i);
//				System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "KING");
			}
		}
		else {
			g.drawString("Player�� �� : " + s + " " + r, defaultPlayer_x, defaultPlayer_y + i);
//			System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + pcards[i].getRank());
		}
	}
	
	/**informationString - ���� �߰� �� �ȳ����� ���
	 * 
	 * @param g - Graphics g
	 */
	public void informationString(Graphics g) {
		Card [] dcards = dealer.showCards();	
		g.setColor(Color.BLACK);
		g.drawString("Dealer ���� ���� 16 �����Դϴ�. �߰��� ī�带 �̽��ϴ�.", defaultDealer_x, defaultDealer_Y + dcards.length - 10); // 105
	}
	
	/**board_distributor - ���� ���� �� ù��°, �ι�° ī�� ���� �й� ���� ���
	 * 
	 * @param g - Graphics g
	 * @param s - ���� ī�� ���� 
	 * @param r - ���� ī�� ���
	 * @param i - drawString �Լ� y ��ġ ��ȭ
	 */
	public void board_distributor_dealer(Graphics g, String s, int r, int i) {
		g.setColor(Color.BLACK);
		if(r == 1 || r == 11 ||	r == 12 || r == 13) {
			if(r == 1) {	
				g.drawString("Dealer�� �� : " + s + " " + "ACE", defaultDealer_x, defaultDealer_Y + i);
//				System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "ACE");
			}
			else if(r == 11) {
				g.drawString("Dealer�� �� : " + s + " " + "JACK", defaultDealer_x, defaultDealer_Y + i);
//				System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "JACK");
			}
			else if(r == 12) {
				g.drawString("Dealer�� �� : " + s + " " + "QUEEN", defaultDealer_x, defaultDealer_Y + i);
//				System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "QUEEN");
			}
			else if(r == 13) {
				g.drawString("Dealer�� �� : " + s + " " + "KING", defaultDealer_x, defaultDealer_Y + i);
//				System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + "KING");
			}
		}
		else {
			g.drawString("Dealer�� �� : " + s + " " + r, defaultDealer_x,  defaultDealer_Y + i);
//			System.out.println("Player�� �� : " + pcards[i].getSuit() + " " + pcards[i].getRank());
		}
	}
	
	/**board_finishPart - ���� ��� ���
	 * 
	 * @param g - Graphics g
	 * @param p - �÷��̾� ���� �հ�
	 * @param d - ���� ���� �հ�
	 */
	public void board_finishPart(Graphics g, int p, int d) {
		g.setColor(Color.black);
		if(p > 21 || d > 21) {
			if(player.pp_value() > 21 && dealer.dp_value() > 21) {
				g.drawString("player �� : " +  p, 200, 200);
				g.drawString("dealer �� : " +  d, 200, 215);
				g.drawString("Draw!", 200, 230);
			}
			else if(p > 21 && d < 21) {
				g.drawString("player �� : " +  p, 200, 200);
				g.drawString("dealer �� : " +  d, 200, 215);
				g.drawString("Burst! Dealer win!", 200, 230);
			}
			else if(p < 21 && d > 21) {
				g.drawString("player �� : " +  p, 200, 200);
				g.drawString("dealer �� : " +  d, 200, 215);
				g.drawString("Burst! Player win!", 200, 230);
			}
		}
		else {
			if(p > d) {
				g.drawString("player �� : " +  p, 200, 200);
				g.drawString("dealer �� : " +  d, 200, 215);
				g.drawString("Player win!", 200, 230);
			}
			else if(p < d) {
				g.drawString("player �� : " +  p, 200, 200);
				g.drawString("dealer �� : " +  d, 200, 215);
				g.drawString("Dealer win!", 200, 230);
			}
		}
	}

}
